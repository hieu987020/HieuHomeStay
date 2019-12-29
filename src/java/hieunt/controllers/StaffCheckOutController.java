/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hieunt.controllers;

import hieunt.daos.BillDAO;
import hieunt.daos.ProductDAO;
import hieunt.daos.ProductDetailDAO;
import hieunt.daos.RoomDAO;
import hieunt.daos.RoomDetailDAO;
import hieunt.daos.ServiceDAO;
import hieunt.daos.ServiceDetailDAO;
import hieunt.dtos.BillDTO;
import hieunt.dtos.ProductDTO;
import hieunt.dtos.ProductDetailDTO;
import hieunt.dtos.RoomDTO;
import hieunt.dtos.RoomDetailDTO;
import hieunt.dtos.ServiceDTO;
import hieunt.dtos.ServiceDetailDTO;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author hieu
 */
public class StaffCheckOutController extends HttpServlet {

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
            int billID = Integer.parseInt(request.getParameter("id"));
            request.setAttribute("BILLID", billID);
            // lay het detail cua bill ra 
            RoomDetailDAO roomDetailDAO = new RoomDetailDAO();
            ProductDetailDAO productDetailDAO = new ProductDetailDAO();
            ServiceDetailDAO serviceDetailDAO = new ServiceDetailDAO();
            List<RoomDetailDTO> listRoom = roomDetailDAO.loadRoomDetailByBillID(billID);
//            System.out.println("listRoom " + listRoom.size());
            List<ProductDetailDTO> listPro = productDetailDAO.loadProductDetailByBillID(billID);
//            System.out.println("listPro " + listPro.size());
            List<ServiceDetailDTO> listSer = serviceDetailDAO.loadServiceDetailByBillID(billID);
//            System.out.println("listSer" + listSer.size());

            // lay room
            if (listRoom != null) {
                RoomDAO roomDAO = new RoomDAO();
                List<RoomDTO> roomResult = new ArrayList<>();
                RoomDTO roomDto = null;
                for (RoomDetailDTO x : listRoom) {
                    roomDto = roomDAO.findByPrimaryKeyNoCondition(x.getRoomID());
                    roomResult.add(roomDto);
                }
                System.out.println("roomResult" + roomResult.size());
                request.setAttribute("ROOM", roomResult);
            }

            //lay product
            if (listPro != null) {
                ProductDAO productDAO = new ProductDAO();
                List<ProductDTO> proResult = new ArrayList<>();
                ProductDTO productDto = null;
                for (ProductDetailDTO x : listPro) {
                    productDto = productDAO.findByPrimaryKey(x.getProID());
                    proResult.add(productDto);
                }
                request.setAttribute("PRODUCT", proResult);
            }

            //lay service
            if (listSer != null) {
                ServiceDAO serviceDAO = new ServiceDAO();
                List<ServiceDTO> serResult = new ArrayList<>();
                ServiceDTO serDto = null;
                for (ServiceDetailDTO x : listSer) {
                    serDto = serviceDAO.findByPrimaryKey(x.getSerID());
                    serResult.add(serDto);
                }
                request.setAttribute("SERVICE", serResult);
            }
            //Load all product va service de add vao bill
            ProductDAO productDAO = new ProductDAO();
            List<ProductDTO> allProduct = productDAO.listAllProduct();
            request.setAttribute("ALLPRODUCT", allProduct);
            
            ServiceDAO serviceDAO = new ServiceDAO();
            List<ServiceDTO> allService = serviceDAO.listAllService();
            request.setAttribute("ALLSERVICE", allService);
        } catch (Exception e) {
            log("Error at StaffCheckOutController" + e.getMessage());
        } finally {
            request.getRequestDispatcher("staff/checkOut.jsp").forward(request, response);
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
