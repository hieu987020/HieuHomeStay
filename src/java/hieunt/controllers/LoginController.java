/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hieunt.controllers;

import hieunt.daos.AccountDAO;
import hieunt.daos.RoleDAO;
import hieunt.dtos.CartObj;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author hieu
 */
public class LoginController extends HttpServlet {
    private static final String ADMIN = "admin/index.jsp";
    private static final String CUSTOMER = "customer/index.jsp";
    private static final String STAFF = "staff/index.jsp";
    private static final String ERROR = "error.jsp";
    
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
        String url = ERROR;
        try {
            String username = request.getParameter("txtUsername");
            String password = request.getParameter("txtPassword");
            AccountDAO accountDao = new AccountDAO();
            int roleId = accountDao.checkLogin(username, password);
            
            RoleDAO roleDao = new RoleDAO();
            String role = roleDao.checkRole(roleId);
            if(role.equals("failed")){
                request.setAttribute("ERROR", "Wrong username or password");
            } else {
                HttpSession session = request.getSession();
                session.setAttribute("USERROLE", role);
                session.setAttribute("USERLOGIN", username);
                int infoId = accountDao.findInfoID(username);
                session.setAttribute("USERINFOID", infoId);
                if(role.equals("admin")){
                    url = ADMIN;
                } else if(role.equals("staff")){
                    url = STAFF;
                } else if(role.equals("customer")){
                    
                    url = CUSTOMER;
                }
                CartObj shoppingCart = new CartObj();
                session.setAttribute("cart", shoppingCart);
            } 
        } catch (Exception e) {
            log("error at logincontroller" + e.getMessage());
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
