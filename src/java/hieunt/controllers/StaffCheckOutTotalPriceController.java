/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hieunt.controllers;

import hieunt.daos.BillDAO;
import hieunt.daos.HistoryStaffDAO;
import hieunt.daos.InformationDAO;
import hieunt.daos.LevelDAO;
import hieunt.daos.ProductDetailDAO;
import hieunt.daos.RoomDetailDAO;
import hieunt.daos.ServiceDetailDAO;
import hieunt.dtos.BillDTO;
import hieunt.dtos.HistoryStaffDTO;
import hieunt.dtos.InformationDTO;
import hieunt.dtos.LevelDTO;
import hieunt.dtos.ProductDetailDTO;
import hieunt.dtos.RoomDetailDTO;
import hieunt.dtos.ServiceDetailDTO;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
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
public class StaffCheckOutTotalPriceController extends HttpServlet {

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
            int billId = Integer.parseInt(request.getParameter("billId"));//billId
            HttpSession session = request.getSession();
            int infoId = (int) session.getAttribute("USERINFOID");//staffId
            RoomDetailDAO roomDetailDAO = new RoomDetailDAO();
            ProductDetailDAO productDetailDAO = new ProductDetailDAO();
            ServiceDetailDAO serviceDetailDAO = new ServiceDetailDAO();
            List<RoomDetailDTO> listRoom = roomDetailDAO.loadRoomDetailByBillID(billId);
            List<ProductDetailDTO> listPro = productDetailDAO.loadProductDetailByBillID(billId);
            List<ServiceDetailDTO> listSer = serviceDetailDAO.loadServiceDetailByBillID(billId);
            float roomTotal = 0;
            float productTotal = 0;
            float serviceTotal = 0;
            if (listRoom != null) {
                for (RoomDetailDTO x : listRoom) {
                    roomTotal += x.getPrice();
                }
            }
            if (listPro != null) {
                for (ProductDetailDTO x : listPro) {
                    productTotal += x.getPrice();
                }
            }
            if (listSer != null) {
                for (ServiceDetailDTO x : listSer) {
                    serviceTotal += x.getPrice();
                }
            }
            float sumBefore = roomTotal + productTotal + serviceTotal; // sumBefore

            BillDAO billDAO = new BillDAO();
            BillDTO billDTO = billDAO.loadByPrimaryKey(billId); // lay cusId de tim level
            InformationDAO informationDAO = new InformationDAO();
            InformationDTO informationDTO = informationDAO.loadInfo(billDTO.getInfoID());
            LevelDAO levelDAO = new LevelDAO();
            LevelDTO levelDTO = levelDAO.findByPrimaryKey(informationDTO.getLevelID());
            float moneyDiscount = (sumBefore * levelDTO.getDes()) / 100; //moneyDiscount
            float sumAfter = sumBefore - moneyDiscount; // sumAfter

            SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
            Date date = Calendar.getInstance().getTime();
            String time = format.format(date); // time
            BillDTO checkOutBill = new BillDTO(billId, infoId, sumBefore, moneyDiscount, sumAfter, time);//day la cai bill
            if (billDAO.checkOut(checkOutBill)) {
                url = "staff/success.jsp";
                BillDTO billSuccess = billDAO.loadByPrimaryKey(billId);
                request.setAttribute("BILL", billSuccess);
                
                //update level cho customer
                List<BillDTO> listBill = billDAO.loadListByCustometId(billDTO.getInfoID());// day la cusId de tim list bill
                float totalBillPrice = 0;
                if (listBill != null) {
                    if (listBill.size() != 0) {
                        for (BillDTO x : listBill) {
                            totalBillPrice += x.getSumAfter();
                        }
                    }
                    if (totalBillPrice >= 0 && totalBillPrice < 1000) {
                        if (!informationDAO.updateLevel(billDTO.getInfoID(), 6)) {
                            request.setAttribute("ERROR", "update levelId fail");
                            url = "error.jsp";
                        }
                    } else if (totalBillPrice >= 1000 && totalBillPrice < 2000) {
                        if (!informationDAO.updateLevel(billDTO.getInfoID(), 5)) {
                            request.setAttribute("ERROR", "update levelId fail");
                            url = "error.jsp";
                        }
                    } else if (totalBillPrice >= 2000 && totalBillPrice < 3000) {
                        if (!informationDAO.updateLevel(billDTO.getInfoID(), 4)) {
                            request.setAttribute("ERROR", "update levelId fail");
                            url = "error.jsp";
                        }
                    } else if (totalBillPrice >= 3000 && totalBillPrice < 4000) {
                        if (!informationDAO.updateLevel(billDTO.getInfoID(), 3)) {
                            request.setAttribute("ERROR", "update levelId fail");
                            url = "error.jsp";
                        }
                    } else if (totalBillPrice >= 4000 && totalBillPrice < 5000) {
                        if (!informationDAO.updateLevel(billDTO.getInfoID(), 2)) {
                            request.setAttribute("ERROR", "update levelId fail");
                            url = "error.jsp";
                        }
                    } else if (totalBillPrice >= 5000) {
                        if (!informationDAO.updateLevel(billDTO.getInfoID(), 1)) {
                            request.setAttribute("ERROR", "update levelId fail");
                            url = "error.jsp";
                        }
                    }
                }               
                //update coin cho customer
                if(sumAfter >= 5000){
                    int coin = informationDTO.getCoin() + 100;
                    if(!informationDAO.updateCoin(informationDTO.getId(), coin)){
                        request.setAttribute("ERROR", "update coin fail");
                        url = "error.jsp";
                    }
                } 
                //NEW HISTORY FOR STAFF
                Date todayHis = Calendar.getInstance().getTime();
                SimpleDateFormat formatHis = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                String dateHis = formatHis.format(todayHis);
                HistoryStaffDAO historyStaffDAO = new HistoryStaffDAO();
                HistoryStaffDTO historyStaffDTO = new HistoryStaffDTO(infoId, "Check out . Bill ID is " + billId, dateHis);
                if(!historyStaffDAO.insertActionNormal(historyStaffDTO)){
                    request.setAttribute("ERROR", "Add new history checkout fail");
                    url = "error.jsp";
                }
            } else {
                request.setAttribute("ERROR", "checkout bill fail");
            }

        } catch (Exception e) {
            log("Error at StaffCheckOutTotalPriceController" + e.getMessage());
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
