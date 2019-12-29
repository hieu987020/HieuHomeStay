/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hieunt.controllers;

import hieunt.daos.BillDAO;
import hieunt.daos.InformationDAO;
import hieunt.daos.LevelDAO;
import hieunt.dtos.BillDTO;
import hieunt.dtos.InformationDTO;
import hieunt.dtos.LevelDTO;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author hieu
 */
public class CustomerMyLevelController extends HttpServlet {

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
        try {
            HttpSession session = request.getSession();
            int infoId = (int) session.getAttribute("USERINFOID");
            InformationDAO dao = new InformationDAO();
            InformationDTO dto = dao.loadInfo(infoId);
            int levelId = dto.getLevelID();
            LevelDAO levelDAO = new LevelDAO();
            LevelDTO levelDTO = levelDAO.findByPrimaryKey(levelId);
            request.setAttribute("LEVEL", levelDTO);
            request.setAttribute("INFO", dto);          
            List<LevelDTO> result = levelDAO.listAll();
            request.setAttribute("LISTLEVEL", result);
            
            //tong tienbill
            BillDAO billDAO = new BillDAO();
            List<BillDTO> listBill = billDAO.loadListByCustometId(infoId);
            float total = 0;
            for (BillDTO x : listBill) {
                total += x.getSumAfter();
            }
            request.setAttribute("TOTAL", total);
        } catch (Exception e) {
            log("Error at CustomerMyLevelController" + e.getMessage());
        } finally {
            request.getRequestDispatcher("customer/mylevel.jsp").forward(request, response);
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
