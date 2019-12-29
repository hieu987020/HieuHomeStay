/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hieunt.daos;

import hieunt.db.MyConnection;
import hieunt.dtos.AccountDTO;
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
public class AccountDAO implements Serializable {

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

    public int checkLogin(String username, String password) throws Exception {
        int role = 0;
        try {
            conn = MyConnection.getMyConnection();
            String sql = "Select RoleID From Accounts Where Username = ? and Password = ?";
            preStm = conn.prepareStatement(sql);
            preStm.setString(1, username);
            preStm.setString(2, password);
            rs = preStm.executeQuery();
            if (rs.next()) {
                role = rs.getInt("RoleID");
            }
        } finally {
            closeConnection();
        }
        return role;
    }

    public boolean register(String username, String password) throws Exception {
        boolean check = false;
        try {
            conn = MyConnection.getMyConnection();
            String sql = "Insert Into Accounts(Username,Password,RoleID) values(?,?,?)";
            preStm = conn.prepareStatement(sql);
            preStm.setString(1, username);
            preStm.setString(2, password);
            preStm.setInt(3, 3);
            check = preStm.executeUpdate() > 0;
        } finally {
            closeConnection();
        }
        return check;
    }

    public boolean updateInfoID(String username, int infoId) throws Exception {
        boolean check = false;
        try {
            conn = MyConnection.getMyConnection();
            String sql = "Update Accounts Set InfoID = ? Where Username = ?";
            preStm = conn.prepareStatement(sql);
            preStm.setInt(1, infoId);
            preStm.setString(2, username);
            check = preStm.executeUpdate() > 0;
        } finally {
            closeConnection();
        }
        return check;
    }

    public List<AccountDTO> listStaff() throws Exception {
        List<AccountDTO> result = new ArrayList<>();
        AccountDTO dto = null;
        String username = null;
        int id = 0;
        try {
            conn = MyConnection.getMyConnection();
            String sql = "Select Username, InfoID From Accounts Where RoleID = 2";
            preStm = conn.prepareStatement(sql);
            rs = preStm.executeQuery();
            while (rs.next()) {
                username = rs.getString("Username");
                id = rs.getInt("InfoID");
                dto = new AccountDTO(username, 2, id);
                result.add(dto);
            }
        } finally {
            closeConnection();
        }
        return result;
    }

    public List<AccountDTO> listCustomer() throws Exception {
        List<AccountDTO> result = new ArrayList<>();
        AccountDTO dto = null;
        String username = null;
        int id = 0;
        try {
            conn = MyConnection.getMyConnection();
            String sql = "Select Username, InfoID From Accounts Where RoleID = 3";
            preStm = conn.prepareStatement(sql);
            rs = preStm.executeQuery();
            while (rs.next()) {
                username = rs.getString("Username");
                id = rs.getInt("InfoID");
                dto = new AccountDTO(username, 3, id);
                result.add(dto);
            }
        } finally {
            closeConnection();
        }
        return result;
    }

    public boolean changeRole(String username) throws Exception {
        boolean check = false;
        try {
            conn = MyConnection.getMyConnection();
            String sql = "Update Accounts Set RoleID = 2 Where Username = ?";
            preStm = conn.prepareStatement(sql);
            preStm.setString(1, username);
            check = preStm.executeUpdate() > 0;
        } finally {
            closeConnection();
        }
        return check;
    }

    public int findInfoID(String username) throws Exception {
        int infoId = 0;
        try {
            conn = MyConnection.getMyConnection();
            String sql = "Select InfoID From Accounts Where Username = ?";
            preStm = conn.prepareStatement(sql);
            preStm.setString(1, username);
            rs = preStm.executeQuery();
            if (rs.next()) {
                infoId = rs.getInt("InfoID");
            }

        } finally {
            closeConnection();
        }
        return infoId;
    }
}
