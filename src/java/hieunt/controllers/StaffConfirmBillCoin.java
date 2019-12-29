/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hieunt.controllers;

import hieunt.daos.BillCoinDAO;
import hieunt.daos.InformationDAO;
import hieunt.daos.ProductCoinDetailDAO;
import hieunt.daos.ProductDAO;
import hieunt.dtos.BillCoinDTO;
import hieunt.dtos.InformationDTO;
import hieunt.dtos.ProductCoinDetailDTO;
import hieunt.dtos.ProductDTO;
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
public class StaffConfirmBillCoin extends HttpServlet {

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
            int billID = Integer.parseInt(request.getParameter("billID"));
            BillCoinDAO dao = new BillCoinDAO();
            ProductCoinDetailDAO productCoinDetailDAO = new ProductCoinDetailDAO();
            List<ProductCoinDetailDTO> result = productCoinDetailDAO.loadAllByBillCoinID(billID);
            int totalCoin = 0;
            for (ProductCoinDetailDTO x : result) {
                totalCoin += x.getCoin();
            }
            BillCoinDTO dto = dao.loadBillByPrimaryKey(billID);
            int infoId = dto.getInfoID(); //lay infoID ra de lay xu cua nguoi dung va check xem du? xu de mua ko
            InformationDAO informationDAO = new InformationDAO();
            InformationDTO infoDTO = informationDAO.loadInfo(infoId);
            int check = infoDTO.getCoin() - totalCoin;
            if (check >= 0) {
                if (dao.approveBillCoin(billID, totalCoin)) {
                    //them 1 lan load nua de load thang xu len :))
                    dto = dao.loadBillByPrimaryKey(billID);
                    request.setAttribute("BILL", dto);
                    //tru coin cua user di
                    if (informationDAO.updateCoin(infoId, check)) {
                        url = "staff/billCoinSuccess.jsp";
                    } else {
                        request.setAttribute("ERROR", "update coin to order bill coin fail");
                    }
                } else {
                    request.setAttribute("ERROR", "approve bill coin fail");
                }
            } else {
                //ko du coin => chinh sua product trong bill coin
                request.setAttribute("INVALID", "Not enought coin !!!!!!!!!!!!");
                url = "staff/addBillCoinChooseProduct.jsp";
                //tiep tuc lay list product va bill ra 
                request.setAttribute("BILLID", billID);
                ProductDAO productDAO = new ProductDAO();
                List<ProductDTO> list = productDAO.listAllProductToShow();
                request.setAttribute("INFO", list);
            }

        } catch (Exception e) {
            log("Error at StaffConfirmBillCoin" + e.getMessage());
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
