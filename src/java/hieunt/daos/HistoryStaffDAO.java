/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hieunt.daos;

import hieunt.db.MyConnection;
import hieunt.dtos.HistoryStaffDTO;
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
public class HistoryStaffDAO implements Serializable {
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
    public boolean insertActionNormal(HistoryStaffDTO dto) throws Exception {
        boolean check = false;
        try {
            conn = MyConnection.getMyConnection();
            String sql = "Insert Into HistoryStaffs(InfoID,Des,Time) values(?,?,?) ";
            preStm = conn.prepareCall(sql);
            preStm.setInt(1, dto.getInfoID());
            preStm.setString(2, dto.getDes());
            preStm.setString(3, dto.getTime());
            check = preStm.executeUpdate() > 0;
        } finally {
            closeConnection();
        }
        return check;
    }
    public List<HistoryStaffDTO> loadAllByInfoID(int infoID) throws Exception {
        List<HistoryStaffDTO> result = new ArrayList<>();
        HistoryStaffDTO dto = null;
        int id = 0;
        String des = null;
        String time = null;
        try {
            conn = MyConnection.getMyConnection();
            String sql = "Select ID, Des, Time From HistoryStaffs Where InfoID = ?";
            preStm = conn.prepareStatement(sql);
            preStm.setInt(1, infoID);
            rs = preStm.executeQuery();
            while(rs.next()){
                id = rs.getInt("ID");
                des = rs.getString("Des");
                time = rs.getString("Time");
                dto = new HistoryStaffDTO(infoID, des, time);
                dto.setId(id);
                result.add(dto);
            }
        } finally {
            closeConnection();
        }
        return result;
    }
}
