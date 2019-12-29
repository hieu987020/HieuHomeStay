/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hieunt.daos;

import hieunt.db.MyConnection;
import hieunt.dtos.BillCoinDTO;
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
public class BillCoinDAO implements Serializable {

    private Connection conn;
    private PreparedStatement preStm;
    private ResultSet rs;

    private void closeConnection() throws Exception {
        if (rs != null) {
            rs.close();
        }
        if (preStm != null) {
            preStm.close();
        }
        if (conn != null) {
            conn.close();
        }
    }

    public boolean insertNewBill(int infoId, String time) throws Exception {
        boolean check = false;
        try {
            conn = MyConnection.getMyConnection();
            String sql = "Insert Into BillCoins(InfoID,Coin,Time) values (?,?,?)";
            preStm = conn.prepareStatement(sql);
            preStm.setInt(1, infoId);
            preStm.setInt(2, 0);
            preStm.setString(3, time);
            check = preStm.executeUpdate() > 0;
        } finally {
            closeConnection();
        }
        return check;
    }

    public int findNewBill(int infoId) throws Exception {
        int id = 0;
        try {
            conn = MyConnection.getMyConnection();
            String sql = "Select max(ID) as ID From BillCoins Where InfoID = ?";
            preStm = conn.prepareStatement(sql);
            preStm.setInt(1, infoId);
            rs = preStm.executeQuery();
            if (rs.next()) {
                id = rs.getInt("ID");
            }
        } finally {
            closeConnection();
        }
        return id;
    }

    public boolean approveBillCoin(int id, int totalCoin) throws Exception {
        boolean check = false;
        try {
            conn = MyConnection.getMyConnection();
            String sql = "Update BillCoins Set Coin = ? , isApproved = 'true' Where ID = ?";
            preStm = conn.prepareStatement(sql);
            preStm.setInt(1, totalCoin);
            preStm.setInt(2, id);
            check = preStm.executeUpdate() > 0;
        } finally {
            closeConnection();
        }
        return check;
    }

    public BillCoinDTO loadBillByPrimaryKey(int id) throws Exception {
        BillCoinDTO dto = null;
        int infoId = 0;
        int coin = 0;
        String time = null;
        boolean isApproved = false;
        try {
            conn = MyConnection.getMyConnection();
            String sql = "Select InfoID,Coin,Time,isApproved From BillCoins Where ID = ?";
            preStm = conn.prepareStatement(sql);
            preStm.setInt(1, id);
            rs = preStm.executeQuery();
            if (rs.next()) {
                infoId = rs.getInt("InfoID");
                coin = rs.getInt("Coin");
                time = rs.getString("Time");
                isApproved = rs.getBoolean("isApproved");
                dto = new BillCoinDTO(id, infoId, coin, time, isApproved);
            }
        } finally {
            closeConnection();
        }
        return dto;
    }

    public List<BillCoinDTO> loadAllByInfoID(int infoId) throws Exception {
        List<BillCoinDTO> result = new ArrayList<>();
        BillCoinDTO dto = null;
        int id = 0;
        int coin = 0;
        String time = null;
        try {
            conn = MyConnection.getMyConnection();
            String sql = "Select ID, InfoID,Coin,Time From BillCoins Where InfoID = ? And isApproved = 'true'";
            preStm = conn.prepareStatement(sql);
            preStm.setInt(1, infoId);
            rs = preStm.executeQuery();
            while (rs.next()) {
                id = rs.getInt("ID");
                coin = rs.getInt("Coin");
                time = rs.getString("Time");
                dto = new BillCoinDTO(id, infoId, coin, time, true);
                result.add(dto);
            }
        } finally {
            closeConnection();
        }
        return result;
    }
}
