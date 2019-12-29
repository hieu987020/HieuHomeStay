/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hieunt.daos;

import hieunt.db.MyConnection;
import hieunt.dtos.ServiceDetailDTO;
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
public class ServiceDetailDAO implements Serializable {
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
    public List<ServiceDetailDTO> loadServiceDetailByBillID(int billId) throws Exception {
        List<ServiceDetailDTO> result = new ArrayList<>();
        ServiceDetailDTO dto = null;
        int id = 0;
        int serId = 0;
        float price = 0;
        try {
            conn = MyConnection.getMyConnection();
            String sql = "Select ID,SerID,Price From ServiceDetails Where BillID = ? ";
            preStm = conn.prepareStatement(sql);
            preStm.setInt(1, billId);
            rs = preStm.executeQuery();
            while(rs.next()){
                id = rs.getInt("ID");
                serId = rs.getInt("SerID");
                price = rs.getFloat("Price");
                dto = new ServiceDetailDTO(id, serId, billId, price);
                result.add(dto);
            }
                    
        } finally {
            closeConnection();
        }
        return result;
    }
    public float checkDup(int billId, int serId) throws Exception {
        float price = -1;
        try {
            conn = MyConnection.getMyConnection();
            String sql = "Select Price From ServiceDetails Where BillID = ? And SerID = ?";
            preStm = conn.prepareStatement(sql);
            preStm.setInt(1, billId);
            preStm.setInt(2, serId);
            rs = preStm.executeQuery();
            if(rs.next()){
                price = rs.getFloat("Price");
            }
        } finally {
            closeConnection();
        }
        return price;
    }
    public boolean insert(ServiceDetailDTO dto) throws Exception {
        boolean check = false;
        try {
            conn  = MyConnection.getMyConnection();
            String sql = "Insert Into ServiceDetails(SerID,BillID,Price) values(?,?,?)";
            preStm = conn.prepareStatement(sql);
            preStm.setInt(1, dto.getSerID());
            preStm.setInt(2, dto.getBillID());
            preStm.setFloat(3, dto.getPrice());
            check = preStm.executeUpdate() > 0;
        } finally {
            closeConnection();
        }
        return check;
    }
    public boolean remove(int billId, int serId) throws Exception {
        boolean check = false;
        try {
            conn = MyConnection.getMyConnection();
            String sql = "Delete ServiceDetails Where BillID = ? And SerID = ?";
            preStm = conn.prepareStatement(sql);
            preStm.setInt(1, billId);
            preStm.setInt(2, serId);
            check = preStm.executeUpdate() > 0;
        } finally {
            closeConnection();
        }
        return check;
    }
}
