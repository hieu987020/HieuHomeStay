/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hieunt.daos;

import hieunt.db.MyConnection;
import hieunt.dtos.ServiceDTO;
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
public class ServiceDAO implements Serializable {

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

    public List<ServiceDTO> listAllService() throws Exception {
        List<ServiceDTO> result = new ArrayList<>();
        ServiceDTO dto = null;
        int id = 0;
        String name = null;
        float price = 0;
        String des = null;
        String source = null;
        boolean isDeleted = false;
        try {
            conn = MyConnection.getMyConnection();
            String sql = "Select ID, Name, Price, Des, Source, isDeleted From Services";
            preStm = conn.prepareStatement(sql);
            rs = preStm.executeQuery();
            while (rs.next()) {
                id = rs.getInt("ID");
                name = rs.getString("Name");
                price = rs.getFloat("Price");
                des = rs.getString("Des");
                source = rs.getString("Source");
                isDeleted = rs.getBoolean("isDeleted");
                dto = new ServiceDTO(id, name, price, des, source, isDeleted);
                result.add(dto);
            }
        } finally {
            closeConnection();
        }
        return result;
    }

    public boolean insert(ServiceDTO dto) throws Exception {
        boolean check = false;
        try {
            conn = MyConnection.getMyConnection();
            String sql = "Insert Into Services(Name,Price,Des,Source,isDeleted) values(?,?,?,?,?)";
            preStm = conn.prepareStatement(sql);
            preStm.setString(1, dto.getName());
            preStm.setFloat(2, dto.getPrice());
            preStm.setString(3, dto.getDes());
            preStm.setString(4, dto.getSource());
            preStm.setBoolean(5, dto.isDelete());
            check = preStm.executeUpdate() > 0;
        } finally {
            closeConnection();
        }
        return check;
    }

    public ServiceDTO findByPrimaryKey(int id) throws Exception {
        ServiceDTO dto = null;
        String name = null;
        float price = 0;
        String des = null;
        String source = null;
        boolean isDeleted = false;
        try {
            conn = MyConnection.getMyConnection();
            String sql = "Select Name,Price,Des,Source,isDeleted From Services Where ID = ?";
            preStm = conn.prepareStatement(sql);
            preStm.setInt(1, id);
            rs = preStm.executeQuery();
            if (rs.next()) {
                name = rs.getString("Name");
                price = rs.getFloat("Price");
                des = rs.getString("Des");
                source = rs.getString("Source");
                isDeleted = rs.getBoolean("isDeleted");
                dto = new ServiceDTO(id, name, price, des, source, isDeleted);
            }
        } finally {
            closeConnection();
        }
        return dto;
    }

    public boolean update(ServiceDTO dto) throws Exception {
        boolean check = false;
        try {
            conn = MyConnection.getMyConnection();
            String sql = "Update Services Set Name = ?, Price = ?, Des =?, Source = ?, isDeleted = ? Where ID = ?";
            preStm = conn.prepareStatement(sql);
            preStm.setString(1, dto.getName());
            preStm.setFloat(2, dto.getPrice());
            preStm.setString(3, dto.getDes());
            preStm.setString(4, dto.getSource());
            preStm.setBoolean(5, dto.isDelete());
            preStm.setInt(6, dto.getId());
            check = preStm.executeUpdate() > 0;
        } finally {
            closeConnection();
        }
        return check;
    }

    public boolean deleteByUpdate(int id) throws Exception {
        boolean check = false;
        try {
            conn = MyConnection.getMyConnection();
            String sql = "Update Services  Set isDeleted = ? Where ID = ?";
            preStm = conn.prepareStatement(sql);
            preStm.setBoolean(1, true);
            preStm.setInt(2, id);
            check = preStm.executeUpdate() > 0;
        } finally {
            closeConnection();
        }
        return check;
    }

    public List<ServiceDTO> listAllServiceToShow() throws Exception {
        List<ServiceDTO> result = new ArrayList<>();
        ServiceDTO dto = null;
        int id = 0;
        String name = null;
        float price = 0;
        String des = null;
        String source = null;
        try {
            conn = MyConnection.getMyConnection();
            String sql = "Select ID, Name, Price, Des, Source From Services Where isDeleted = 0";
            preStm = conn.prepareStatement(sql);
            rs = preStm.executeQuery();
            while (rs.next()) {
                id = rs.getInt("ID");
                name = rs.getString("Name");
                price = rs.getFloat("Price");
                des = rs.getString("Des");
                source = rs.getString("Source");
                dto = new ServiceDTO(id, name, price, des, source, false);
                result.add(dto);
            }
        } finally {
            closeConnection();
        }
        return result;
    }

    public int findNewID() throws Exception {
        int id = 0;
        try {
            conn = MyConnection.getMyConnection();
            String sql = "Select max(ID) as ID From Services";
            preStm = conn.prepareStatement(sql);
            rs = preStm.executeQuery();
            if (rs.next()) {
                id = rs.getInt("ID");
            }
        } finally {
            closeConnection();
        }
        return id;
    }
}
