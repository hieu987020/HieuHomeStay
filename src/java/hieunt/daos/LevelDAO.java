/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hieunt.daos;

import hieunt.db.MyConnection;
import hieunt.dtos.LevelDTO;
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
public class LevelDAO implements Serializable {
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
    public LevelDTO findByPrimaryKey(int id) throws Exception {
        LevelDTO dto = null;
        try {
            conn = MyConnection.getMyConnection();
            String sql = "Select Name, Des From Levels Where ID = ?";
            preStm = conn.prepareStatement(sql);
            preStm.setInt(1, id);
            rs = preStm.executeQuery();
            if(rs.next()){
                String  name = rs.getString("Name");
                int des = rs.getInt("Des");
                dto = new LevelDTO(id, name, des);
            }
        } finally {
            closeConnection();
        }
        return dto;
    }
    
    public List<LevelDTO> listAll() throws Exception {
        List<LevelDTO> result = new ArrayList<>();
        LevelDTO dto = null;
        int id = 0;
        String  name = null;
        int des = 0;
        String  condition = null;
        try {
            conn = MyConnection.getMyConnection();
            String sql = "Select ID, Name, Des, Condition From Levels";
            preStm = conn.prepareStatement(sql);
            rs = preStm.executeQuery();
            while(rs.next()){
                id = rs.getInt("ID");
               name = rs.getString("Name");
                des = rs.getInt("Des");
                condition = rs.getString("Condition");
                dto = new LevelDTO(id, name, des, condition);
                result.add(dto);
            }
        } finally {
            closeConnection();
        }
        return result;
    }
}
