/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hieunt.daos;

import hieunt.db.MyConnection;
import hieunt.dtos.InformationDTO;
import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author hieu
 */
public class InformationDAO implements Serializable {
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
    public boolean register() throws Exception {
        boolean check = false;
        try {
            conn = MyConnection.getMyConnection();
            String sql = "Insert Into Informations(LevelID,Coin) values(?,?)";
            preStm = conn.prepareStatement(sql);
            preStm.setInt(1, 6);
            preStm.setInt(2, 0);
            check = preStm.executeUpdate() > 0;
        } finally{ 
            closeConnection();
        }
        return check;
    }
    public int findRegisterInfo() throws Exception {
        int infoId = 0;
        try {
            conn = MyConnection.getMyConnection();
            String sql = "Select max(ID) as ID From Informations";
            preStm = conn.prepareStatement(sql);
            rs = preStm.executeQuery();
            if(rs.next()){
                infoId = rs.getInt("ID");
            }
        } finally {
            closeConnection();
        }
        return infoId;
    }
    public InformationDTO loadInfo(int id) throws Exception {
        InformationDTO dto = null;
        String name = null;
        String phone = null;
        String email = null;
        String sex = null;
        int levelId = 0;
        int coin = 0;
        try {
            conn = MyConnection.getMyConnection();
            String sql = "Select Name, Phone, Email, Sex, LevelID, Coin From Informations Where ID = ?";
            preStm = conn.prepareStatement(sql);
            preStm.setInt(1, id);
            rs = preStm.executeQuery();
            if(rs.next()){
                name = rs.getString("Name");
                phone = rs.getString("Phone");
                email = rs.getString("Email");
                sex = rs.getString("Sex");
                levelId = rs.getInt("LevelID");
                coin = rs.getInt("Coin");
                dto = new InformationDTO(id, name, phone, email, sex, levelId, coin);
            }
        } finally {
            closeConnection();
        }
        return dto;
    }
    public boolean updateInfo(InformationDTO dto) throws Exception {
        boolean check = false;
        try {
            conn = MyConnection.getMyConnection();
            String sql = "Update Informations Set Name = ?, Phone = ?, Email = ?, Sex = ? Where ID = ?";
            preStm = conn.prepareStatement(sql);
            preStm.setString(1, dto.getName());
            preStm.setString(2, dto.getPhone());
            preStm.setString(3, dto.getEmail());
            preStm.setString(4, dto.getSex());
            preStm.setInt(5, dto.getId());
            check = preStm.executeUpdate() > 0;
        } finally {
            closeConnection();
        }
        return check;
    }
    public boolean updateLevel(int infoId, int levelId) throws Exception {
        boolean check = false;
        try {
            conn = MyConnection.getMyConnection();
            String sql = "Update Informations Set LevelID = ?  Where ID = ?";
            preStm = conn.prepareStatement(sql);
            preStm.setInt(1, levelId);
            preStm.setInt(2, infoId);          
            check = preStm.executeUpdate() > 0;
        } finally {
            closeConnection();
        }
        return check;
    }
    public boolean updateCoin(int infoId, int coin) throws Exception {
        boolean check = false;
        try {
            conn = MyConnection.getMyConnection();
            String sql = "Update Informations Set Coin = ?  Where ID = ?";
            preStm = conn.prepareStatement(sql);
            preStm.setInt(1, coin);
            preStm.setInt(2, infoId);          
            check = preStm.executeUpdate() > 0;
        } finally {
            closeConnection();
        }
        return check;
    }
}
