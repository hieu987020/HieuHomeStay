/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hieunt.controllers;

import hieunt.daos.BillDAO;
import hieunt.daos.RoomDAO;
import hieunt.daos.RoomDetailDAO;
import hieunt.dtos.BillDTO;
import hieunt.dtos.CartObj;
import hieunt.dtos.RoomDTO;
import hieunt.dtos.RoomDetailDTO;
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
public class CustomerBookRoomController extends HttpServlet {

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
            HttpSession session = request.getSession();
            CartObj shoppingCart = (CartObj) session.getAttribute("cart");
            RoomDAO dao = new RoomDAO();
            RoomDTO dto = null;
            String invalid = "";
            int count = 1;
            boolean check = true;
            for (Integer key : shoppingCart.getCart().keySet()) {
                if (!dao.checkRoom(key)) {
                    dto = dao.findByPrimaryKeyNoCondition(key);
                    invalid += "Problem " + count + ":\n";
                    invalid += "Room " + dto.getName() + " is maintenance . Please choose another room!!!\n";
                    url = "CustomerMyCartController";
                    count++;
                    check = false;
                }
            }
            //lay ngay from va to
            SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
            String dateFrom = request.getParameter("dateFrom");
            String dateTo = request.getParameter("dateTo");
            Date from = format.parse(dateFrom);
            Date to = format.parse(dateTo);
            System.out.println("====================================");
            //after lon hon to 1 ngay
            Long amountDay = (to.getTime() - from.getTime()) / 86400000;
            if (amountDay < 1) {
                check = false;
                url = "CustomerMyCartController";
                request.setAttribute("INVALIDDATE2", "Please book a least 1 day !");
            }
            //from > today 1 ngay
            Date today = Calendar.getInstance().getTime();
            format.format(today);
            if (!from.after(today)) {
                check = false;
                url = "CustomerMyCartController";
                request.setAttribute("INVALIDDATE3", "Please From > Today in Real Life !");
            }
            if (check) {
                BillDAO billDAO = new BillDAO();
                int infoId = (int) session.getAttribute("USERINFOID");
                BillDTO billDto = new BillDTO(infoId, dateFrom, dateTo, false);
                if (billDAO.insertNewBill(billDto)) {
                    //lay billid moi tao 
                    int billId = billDAO.findNewBillID();
                    //tao roomdetail va add vao bill 
                    RoomDetailDAO roomDetailDao = new RoomDetailDAO();
                    RoomDetailDTO roomDetailDto = null;
                    boolean checkLast = true;
                    float total = 0;
                    for (Integer key : shoppingCart.getCart().keySet()) {
                        dto = dao.findByPrimaryKeyNoCondition(key);
                        total = dto.getPrice() * amountDay;
                        roomDetailDto = new RoomDetailDTO(key, billId, dateFrom, dateTo, total);
                        if (!roomDetailDao.insert(roomDetailDto)) {
                            checkLast = false;
                            request.setAttribute("ERROR", "insert roomDetail Name is " + dto.getName() + " fail");
                        }
                    }
                    //book xong thi remove all item trong shoppingcart va chuyen den trang mycart 
                    if (checkLast) {
                        shoppingCart.removeAll();
                        session.setAttribute("cart", shoppingCart);
                        url = "CustomerMyCartController";
                    }
                } else {
                    request.setAttribute("ERROR", "insert new bill error");
                }

            }
            request.setAttribute("INVALID", invalid);
        } catch (Exception e) {
            log("Error at CustomerBookRoomController" + e.getMessage());
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
