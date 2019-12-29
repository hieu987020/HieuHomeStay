/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hieunt.daos;

import hieunt.db.MyConnection;
import hieunt.dtos.ProductCoinDetailDTO;
import hieunt.dtos.ProductDetailDTO;
import hieunt.dtos.RoomDetailDTO;
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
public class ProductCoinDetailDAO implements Serializable {
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
    public int checkDup(int billCoinId, int proId) throws Exception {
        int quantity = -1;
        try {
            conn = MyConnection.getMyConnection();
            String sql = "Select Quantity From ProductCoinDetails Where ProductID = ? and BillCoinID = ?";
            preStm = conn.prepareStatement(sql);
            preStm.setInt(1, proId);
            preStm.setInt(2, billCoinId);
            rs = preStm.executeQuery();
            if(rs.next()){
                quantity = rs.getInt("Quantity");
            }
        } finally {
            closeConnection();
        }
        return quantity;
    }
    public boolean addPro(ProductCoinDetailDTO dto) throws Exception {
        boolean check = false;
        try {
            conn = MyConnection.getMyConnection();
            String sql = "Insert Into ProductCoinDetails(ProductID,BillCoinID,Quantity,Coin) values(?,?,?,?)";
            preStm = conn.prepareStatement(sql);
            preStm.setInt(1, dto.getProID());
            preStm.setInt(2, dto.getBillCoinID());
            preStm.setInt(3, dto.getQuantity());
            preStm.setInt(4, dto.getCoin());
            check = preStm.executeUpdate() > 0;
        } finally {
            closeConnection();
        }
        return check;
    }
    public boolean updateQuantityAndCoin(ProductCoinDetailDTO dto) throws Exception {
        boolean check = false;
        try {
            conn = MyConnection.getMyConnection();
            String sql = "Update ProductCoinDetails Set Quantity = ?, Coin = ? Where ProductID = ? And BillCoinID = ?";
            preStm= conn.prepareStatement(sql);
            preStm.setInt(1, dto.getQuantity());
            preStm.setInt(2, dto.getCoin());
            preStm.setInt(3, dto.getProID());
            preStm.setInt(4, dto.getBillCoinID());
            check = preStm.executeUpdate() > 0;
        } finally {
            closeConnection();
        }
        return check;
    }
    public List<ProductCoinDetailDTO> loadAllByBillCoinID(int billCoinID) throws Exception {
        List<ProductCoinDetailDTO> result = new ArrayList<>();
        ProductCoinDetailDTO dto = null;
        int id = 0;
        int proId = 0;
        int quantity = 0;
        int coin = 0;
        try {
            conn = MyConnection.getMyConnection();
            String sql = "Select ID,ProductID,Quantity,Coin From ProductCoinDetails Where BillCoinID = ?";
            preStm = conn.prepareStatement(sql);
            preStm.setInt(1, billCoinID);
            rs = preStm.executeQuery();
            while(rs.next()){
                id = rs.getInt("ID");
                proId = rs.getInt("ProductID");
                quantity = rs.getInt("Quantity");
                coin = rs.getInt("Coin");
                dto = new ProductCoinDetailDTO(id, proId, billCoinID, quantity, coin);
                result.add(dto);
            }
        } finally {
            closeConnection();
        }
        return result;
    }
}
