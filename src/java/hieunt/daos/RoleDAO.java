/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hieunt.daos;

import hieunt.db.MyConnection;
import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author hieu
 */
public class RoleDAO implements Serializable {
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
    public String checkRole(int roleId) throws Exception {
        String role = "failed";
        try {
            conn = MyConnection.getMyConnection();
            String sql = "Select Name From Roles Where ID = ?";
            preStm = conn.prepareStatement(sql);
            preStm.setInt(1, roleId);
            rs = preStm.executeQuery();
            if(rs.next()){
                role = rs.getString("Name");
            }        
        } finally {
            closeConnection();
        }
        return role;
    }
}
