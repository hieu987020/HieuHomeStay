/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hieunt.daos;

import hieunt.db.MyConnection;
import hieunt.dtos.ProductDetailDTO;
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
public class ProductDetailDAO implements Serializable {
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
    
    public List<ProductDetailDTO> loadProductDetailByBillID(int billId) throws Exception {
        List<ProductDetailDTO> result = new ArrayList<>();
        ProductDetailDTO dto = null;
        int id = 0;
        int proId = 0;
        int quan = 0;
        float price = 0;
        try {
            conn = MyConnection.getMyConnection();
            String sql = "Select ID, ProID, Quantity, Price From ProductDetails Where BillID = ?";
            preStm = conn.prepareStatement(sql);
            preStm.setInt(1, billId);
            rs = preStm.executeQuery();
            while(rs.next()){
                id = rs.getInt("ID");
                proId = rs.getInt("ProID");
                quan = rs.getInt("Quantity");
                price = rs.getFloat("Price");
                dto = new ProductDetailDTO(id, proId, billId, quan, price);
                result.add(dto);
            }
        } finally {
            closeConnection();
        }
        return result;
    }
    public boolean insert(ProductDetailDTO dto) throws Exception {
        boolean check = false;
        try {
            conn = MyConnection.getMyConnection();
            String sql = "Insert Into ProductDetails(ProID,BillID,Quantity,Price) values(?,?,?,?)";
            preStm = conn.prepareStatement(sql);
            preStm.setInt(1, dto.getProID());
            preStm.setInt(2, dto.getBillID());
            preStm.setInt(3, dto.getQuantity());
            preStm.setFloat(4, dto.getPrice());
            check = preStm.executeUpdate() > 0;
        } finally {
            closeConnection();
        }
        return check;
    }
    
    public int checkDupProduct(int billId, int proId) throws Exception {
        int quantity = -1;
        try {
            conn = MyConnection.getMyConnection();
            String sql = "Select Quantity From ProductDetails Where BillID = ? And ProID = ?";
            preStm = conn.prepareStatement(sql);
            preStm.setInt(1, billId);
            preStm.setInt(2, proId);
            rs = preStm.executeQuery();
            if(rs.next()){
                quantity = rs.getInt("Quantity");
            }
        } finally {
            closeConnection();
        }
        return quantity;
    }
    
    public boolean remove(int billId, int proId) throws Exception {
        boolean check = false;
        try {
            conn = MyConnection.getMyConnection();
            String sql = "Delete ProductDetails Where BillID = ? And ProID = ?";
            preStm = conn.prepareStatement(sql);
            preStm.setInt(1, billId);
            preStm.setInt(2, proId);
            check = preStm.executeUpdate() > 0;
        } finally {
            closeConnection();
        }
        return check;
    }
    
    public boolean updateQuantityPriceBill(ProductDetailDTO dto) throws Exception {
        boolean check = false;
        try {
          conn = MyConnection.getMyConnection();
          String sql = "Update ProductDetails Set Quantity = ?, Price = ? Where BillID = ? And ProID = ? ";
          preStm = conn.prepareStatement(sql);
          preStm.setInt(1, dto.getQuantity());
          preStm.setFloat(2, dto.getPrice());
          preStm.setInt(3, dto.getBillID());
          preStm.setInt(4, dto.getProID());
          check = preStm.executeUpdate() > 0;
        } finally {
            closeConnection();
        }
        return check;
    }
}
