/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hieunt.controllers;

import hieunt.daos.ProductCoinDetailDAO;
import hieunt.daos.ProductDAO;
import hieunt.dtos.ProductCoinDetailDTO;
import hieunt.dtos.ProductDTO;
import hieunt.dtos.ProductDetailDTO;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author hieu
 */
public class StaffAddBillChooseProductController extends HttpServlet {

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
            System.out.println("toi la");
            int billID = Integer.parseInt(request.getParameter("billID"));
            int proID = Integer.parseInt(request.getParameter("proID"));
            int quantity = Integer.parseInt(request.getParameter("quantity"));
            int coin = Integer.parseInt(request.getParameter("coin"));
            ProductCoinDetailDAO productCoinDetailDAO = new ProductCoinDetailDAO();
            int check = productCoinDetailDAO.checkDup(billID, proID);
            if (check == -1) {
                //chua add vao bill coin
                int totalCoin = coin * quantity;
                ProductCoinDetailDTO dto = new ProductCoinDetailDTO(proID, billID, quantity, totalCoin);
                if (productCoinDetailDAO.addPro(dto)) {
                    url = "staff/addBillCoinChooseProduct.jsp";
                } else {
                    request.setAttribute("ERROR", "add new product to productcoindetail fail");
                }
            } else {
                //chinh quantity
                int totalCoin = coin * quantity;
                ProductCoinDetailDTO dto = new ProductCoinDetailDTO(proID, billID, quantity, totalCoin);
                if (productCoinDetailDAO.updateQuantityAndCoin(dto)) {
                    url = "staff/addBillCoinChooseProduct.jsp";
                } else {
                    request.setAttribute("ERROR", "update new product to productcoindetail fail");
                }
            }
            // load lai list dto va bill id de tiep tuc them product
            ProductDAO dao = new ProductDAO();
            List<ProductDTO> result = dao.listAllProductToShow();
            request.setAttribute("INFO", result);
            request.setAttribute("BILLID", billID);

        } catch (Exception e) {
            log("Error at StaffAddBillChooseProductController" + e.getMessage());
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
