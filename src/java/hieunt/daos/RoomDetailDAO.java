/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hieunt.daos;

import hieunt.db.MyConnection;
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
public class RoomDetailDAO implements Serializable {
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
    public boolean insert(RoomDetailDTO dto) throws Exception {
        boolean check = false;
        try {
            conn = MyConnection.getMyConnection();
            String sql = "Insert Into RoomDetails(RoomID,BillID,DateFrom,DateTo,Price) values(?,?,?,?,?)";
            preStm = conn.prepareStatement(sql);
            preStm.setInt(1, dto.getRoomID());
            preStm.setInt(2, dto.getBillID());
            preStm.setString(3, dto.getDateFrom());
            preStm.setString(4, dto.getDateTo());
            preStm.setFloat(5, dto.getPrice());
            check = preStm.executeUpdate() > 0;
        } finally {
            closeConnection();
        }
        return check;
    }
    public List<RoomDetailDTO> loadRoomDetailByBillID(int billId) throws Exception {
        List<RoomDetailDTO> result = new ArrayList<>();
        RoomDetailDTO dto = null;
        int id = 0;
        int roomId = 0;
        String dateFrom = null;
        String dateTo = null;
        float price = 0;
        try {
            conn = MyConnection.getMyConnection();
            String sql = "Select ID, RoomID, DateFrom, DateTo, Price From RoomDetails Where BillID = ?";
            preStm = conn.prepareStatement(sql);
            preStm.setInt(1, billId);
            rs = preStm.executeQuery();
            while(rs.next()){
                id = rs.getInt("ID");
                roomId = rs.getInt("RoomID");
                dateFrom = rs.getString("DateFrom");
                dateTo = rs.getString("DateTo");
                price = rs.getFloat("Price");
                dto = new RoomDetailDTO(id, roomId, billId, dateFrom, dateTo, price);
                result.add(dto);
            }
        } finally {
            closeConnection();
        }
        return result;
    }
    
    
}
