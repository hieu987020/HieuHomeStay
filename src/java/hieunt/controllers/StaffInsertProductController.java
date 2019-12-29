/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hieunt.controllers;

import hieunt.daos.HistoryStaffDAO;
import hieunt.daos.ProductDAO;
import hieunt.dtos.HistoryStaffDTO;
import hieunt.dtos.ProductDTO;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author hieu
 */
public class StaffInsertProductController extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String url = "error.jsp";
        try {
            String name = request.getParameter("name");
            int quantity = Integer.parseInt(request.getParameter("quantity"));
            float price = Float.parseFloat(request.getParameter("price"));
            int coin = Integer.parseInt(request.getParameter("coin"));
            String type = request.getParameter("type");
            String source = request.getParameter("source");
            ProductDTO dto = new ProductDTO(name, quantity, price, coin, type, source, false);
            ProductDAO dao = new ProductDAO();
            if (dao.insert(dto)) {
                int id = dao.findNewID();
                //NEW HISTORY
                HttpSession session = request.getSession();
                int infoId = (int) session.getAttribute("USERINFOID");
                Date today = Calendar.getInstance().getTime();
                SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                String date = format.format(today);
                HistoryStaffDAO historyStaffDAO = new HistoryStaffDAO();
                HistoryStaffDTO historyStaffDTO = new HistoryStaffDTO(infoId, "Insert Product. Product ID is " + id, date);
                if (historyStaffDAO.insertActionNormal(historyStaffDTO)) {
                    url = "StaffViewProductController";
                } else {
                    request.setAttribute("ERROR", "New History fail : Insert Product");
                }
            } else {
                request.setAttribute("ERROR", "insert product fail");
            }
        } catch (Exception e) {
            log("error at StaffInsertProductController" + e.getMessage());
        } finally {
            request.getRequestDispatcher(url).forward(request, response);
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}