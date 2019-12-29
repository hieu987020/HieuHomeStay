/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hieunt.daos;

import com.sun.imageio.plugins.jpeg.JPEG;
import hieunt.db.MyConnection;
import hieunt.dtos.BillDTO;
import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author hieu
 */
public class BillDAO implements Serializable {
    private Connection conn;
    private PreparedStatement preStm;
    private ResultSet rs;
    
    private void closeConnection() throws Exception {
        if(rs != null)
            rs.close();
        if(preStm != null)
            preStm.close();
        if(conn != null)
            conn.close();
    }
    public boolean insertNewBill(BillDTO dto) throws Exception {
        boolean check = false;
        try {
            conn = MyConnection.getMyConnection();
            String sql = "Insert Into Bills(InfoID, DateFrom, DateTo, IsApproved) values(?,?,?,?)";
            preStm = conn.prepareStatement(sql);
            preStm.setInt(1, dto.getInfoID());
            preStm.setString(2, dto.getDateFrom());
            preStm.setString(3, dto.getDateTo());
            preStm.setBoolean(4, dto.isApproved());
            check = preStm.executeUpdate() > 0;
        } finally {
            closeConnection();
        }
        return check;
    }
    public int findNewBillID() throws Exception {
        int billId = 0;
        try {
            conn = MyConnection.getMyConnection();
            String sql = "Select max(ID) as ID From Bills";
            preStm = conn.prepareStatement(sql);
            rs = preStm.executeQuery();
            if(rs.next()){
                billId = rs.getInt("ID");
            }
        } finally {
            closeConnection();
        }
        return billId;
    }
    public List<BillDTO> listAllBill(int infoId) throws Exception {
        List<BillDTO> result = new ArrayList<>();
        BillDTO dto = null;
        int id = 0;
        String time = "Not yet";
        boolean isApproved = false;
        try {
            conn = MyConnection.getMyConnection();
            String sql = "Select ID,Time,IsApproved From Bills Where InfoID = ?";
            preStm = conn.prepareStatement(sql);
            preStm.setInt(1, infoId);
            rs = preStm.executeQuery();
            while(rs.next()){
                id = rs.getInt("ID");
                time = rs.getString("Time");
                isApproved = rs.getBoolean("IsApproved");
                dto = new BillDTO(id, time, isApproved);
                result.add(dto);
            }
        } finally {
            closeConnection();
        }
        return result;
    }
    
    public BillDTO loadByPrimaryKey(int id) throws Exception {
        BillDTO dto = null;
        int infoId = 0;
        int staffId = 0;
        String dateF = null;
        String dateT = null;
        float sumBefore = 0;
        float discount = 0;
        float sumAfter = 0;
        String time = null;
        boolean IsApproved = false;
        try {
            conn = MyConnection.getMyConnection();
            String sql = "Select InfoID, StaffID, DateFrom, DateTo, SumBefore, MoneyDiscount, SumAfter, Time, IsApproved From Bills Where ID =?";
            preStm = conn.prepareStatement(sql);
            preStm.setInt(1, id);
            rs = preStm.executeQuery();
            if(rs.next()){
                infoId = rs.getInt("InfoID");
                staffId = rs.getInt("StaffID");
                dateF = rs.getString("DateFrom");
                dateT = rs.getString("DateTo");
                sumBefore = rs.getFloat("SumBefore");
                discount = rs.getFloat("MoneyDiscount");
                sumAfter = rs.getFloat("SumAfter");
                time = rs.getString("Time");
                IsApproved = rs.getBoolean("IsApproved");
                dto = new BillDTO(id, infoId, staffId, dateF, dateT, sumBefore, discount, sumAfter, time, IsApproved);
            }
        } finally {
            closeConnection();
        }
        return dto;
    }
    
    public List<BillDTO> listBillNotApproved() throws Exception {
        List<BillDTO> result = new ArrayList<>();
        BillDTO dto = null;
        int id = 0;
        int infoId = 0;
        int staffId = 0;
        String dateF = null;
        String dateT = null;
        float sumBefore = 0;
        float discount = 0;
        float sumAfter = 0;
        String time = null;
//        boolean IsApproved = false;
        try {
            conn = MyConnection.getMyConnection();
            String sql = "Select ID, InfoID, StaffID, DateFrom, DateTo, SumBefore, MoneyDiscount, SumAfter, Time From Bills Where IsApproved = 'false'";
            preStm = conn.prepareStatement(sql);
            rs = preStm.executeQuery();
            while(rs.next()){
                id = rs.getInt("ID");
                infoId = rs.getInt("InfoID");
                staffId = rs.getInt("StaffID");
                dateF = rs.getString("DateFrom");
                dateT = rs.getString("DateTo");
                sumBefore = rs.getFloat("SumBefore");
                discount = rs.getFloat("MoneyDiscount");
                sumAfter = rs.getFloat("SumAfter");
                time = rs.getString("Time");
                dto = new BillDTO(id, infoId, staffId, dateF, dateT, sumBefore, discount, sumAfter, time, false);
                result.add(dto);
            }
        } finally {
            closeConnection();
        }
        return result;
    }
    
    public List<BillDTO> listBillApproved() throws Exception {
        List<BillDTO> result = new ArrayList<>();
        BillDTO dto = null;
        int id = 0;   
        int infoId = 0;
        int staffId = 0;
        String dateF = null;
        String dateT = null;
        float sumBefore = 0;
        float discount = 0;
        float sumAfter = 0;
        String time = null;
//        boolean IsApproved = false;
        try {
            conn = MyConnection.getMyConnection();
            String sql = "Select ID, InfoID, StaffID, DateFrom, DateTo, SumBefore, MoneyDiscount, SumAfter, Time From Bills Where IsApproved = 'true'";
            preStm = conn.prepareStatement(sql);
            rs = preStm.executeQuery();
            while(rs.next()){
                id = rs.getInt("ID");
                infoId = rs.getInt("InfoID");
                staffId = rs.getInt("StaffID");
                dateF = rs.getString("DateFrom");
                dateT = rs.getString("DateTo");
                sumBefore = rs.getFloat("SumBefore");
                discount = rs.getFloat("MoneyDiscount");
                sumAfter = rs.getFloat("SumAfter");
                time = rs.getString("Time");
                dto = new BillDTO(id, infoId, staffId, dateF, dateT, sumBefore, discount, sumAfter, time, true);
                result.add(dto);
            }
        } finally {
            closeConnection();
        }
        return result;
    }
    
    public boolean checkOut(BillDTO dto) throws Exception {
        boolean check = false;
        try {
            conn = MyConnection.getMyConnection();
            String sql = "Update Bills Set StaffID = ?, SumBefore = ?, MoneyDiscount = ?, "
                    + "SumAfter = ?, Time = ?, IsApproved = ? Where ID = ?";
            preStm = conn.prepareStatement(sql);
            preStm.setInt(1, dto.getStaffID());
            preStm.setFloat(2, dto.getSumBefore());
            preStm.setFloat(3, dto.getDiscount());
            preStm.setFloat(4, dto.getSumAfter());
            preStm.setString(5, dto.getTime());
            preStm.setBoolean(6, true);
            preStm.setInt(7, dto.getId());
            check = preStm.executeUpdate() > 0;
        } finally {
            closeConnection();
        }
        return check;
    }
    public List<BillDTO> loadListByCustometId(int cusId) throws Exception {
        List<BillDTO> result = new ArrayList<>();
        BillDTO dto = null;
        int id = 0;
        int infoId = 0;
        int staffId = 0;
        String dateF = null;
        String dateT = null;
        float sumBefore = 0;
        float discount = 0;
        float sumAfter = 0;
        String time = null;
        try {
            conn = MyConnection.getMyConnection();
            String sql = "Select ID, InfoID, StaffID, DateFrom, DateTo, SumBefore, MoneyDiscount, "
                    + "SumAfter, Time, IsApproved From Bills Where InfoID = ? And IsApproved = ?";
            preStm = conn.prepareStatement(sql);
            preStm.setInt(1, cusId);
            preStm.setBoolean(2, true);
            rs = preStm.executeQuery();
            while(rs.next()){
                id = rs.getInt("ID");
                infoId = rs.getInt("InfoID");
                staffId = rs.getInt("StaffID");
                dateF = rs.getString("DateFrom");
                dateT = rs.getString("DateTo");
                sumBefore = rs.getFloat("SumBefore");
                discount = rs.getFloat("MoneyDiscount");
                sumAfter = rs.getFloat("SumAfter");
                time = rs.getString("Time");
                dto = new BillDTO(id, infoId, staffId, dateF, dateT, sumBefore, discount, sumAfter, time, true);
                result.add(dto);
            }
        } finally {
            closeConnection();
        }
        return result;
    }
    
}
