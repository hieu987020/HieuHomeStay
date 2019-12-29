/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hieunt.daos;

import com.sun.org.apache.xml.internal.security.encryption.Serializer;
import hieunt.db.MyConnection;
import hieunt.dtos.RoomDTO;
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
public class RoomDAO implements Serializable {

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

    public List<RoomDTO> listAllRoom() throws Exception {
        List<RoomDTO> result = new ArrayList<>();
        RoomDTO dto = null;
        int id = 0;
        String name = null;
        String des = null;
        float price = 0;
        String source = null;
        boolean isDeleted = false;
        try {
            conn = MyConnection.getMyConnection();
            String sql = "Select ID, Name, Des, Price, Source, isDeleted From Rooms";
            preStm = conn.prepareStatement(sql);
            rs = preStm.executeQuery();
            while (rs.next()) {
                id = rs.getInt("ID");
                name = rs.getString("Name");
                des = rs.getString("Des");
                price = rs.getFloat("Price");
                source = rs.getString("Source");
                isDeleted = rs.getBoolean("isDeleted");
                dto = new RoomDTO(id, name, des, price, false, source, isDeleted);
                result.add(dto);
            }
        } finally {
            closeConnection();
        }
        return result;
    }

    public boolean insert(RoomDTO dto) throws Exception {
        boolean check = false;
        try {
            conn = MyConnection.getMyConnection();
            String sql = "Insert Into Rooms(Name,Des,Price,isBooked,Source,isDeleted) values(?,?,?,?,?,?)";
            preStm = conn.prepareStatement(sql);
            preStm.setString(1, dto.getName());
            preStm.setString(2, dto.getDes());
            preStm.setFloat(3, dto.getPrice());
            preStm.setBoolean(4, dto.isBook());
            preStm.setString(5, dto.getSource());
            preStm.setString(5, dto.getSource());
            preStm.setBoolean(6, dto.isDelete());
            check = preStm.executeUpdate() > 0;
        } finally {
            closeConnection();
        }
        return check;
    }

    public RoomDTO findByPrimaryKey(int id) throws Exception {
        RoomDTO dto = null;
        String name = null;
        String des = null;
        float price = 0;
        String source = null;
        boolean delete = false;
        try {
            conn = MyConnection.getMyConnection();
            String sql = "Select Name,Des,Price,Source,isDeleted From Rooms Where ID = ?";
            preStm = conn.prepareStatement(sql);
            preStm.setInt(1, id);
            rs = preStm.executeQuery();
            if (rs.next()) {
                name = rs.getString("Name");
                des = rs.getString("Des");
                price = rs.getFloat("Price");
                source = rs.getString("Source");
                delete = rs.getBoolean("isDeleted");
                dto = new RoomDTO(id, name, des, price, false, source, delete);
            }
        } finally {
            closeConnection();
        }
        return dto;
    }

    public boolean update(RoomDTO dto) throws Exception {
        boolean check = false;
        try {
            conn = MyConnection.getMyConnection();
            String sql = "Update Rooms Set Name = ?, Des = ?, Price = ?,  Source = ?, isDeleted = ? Where ID = ?";
            preStm = conn.prepareStatement(sql);
            preStm.setString(1, dto.getName());
            preStm.setString(2, dto.getDes());
            preStm.setFloat(3, dto.getPrice());
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
            String sql = "Update Rooms Set isDeleted = ? Where ID = ?";
            preStm = conn.prepareStatement(sql);
            preStm.setBoolean(1, true);
            preStm.setInt(2, id);
            check = preStm.executeUpdate() > 0;
        } finally {
            closeConnection();
        }
        return check;
    }

    public List<RoomDTO> listAllRoomToShow() throws Exception {
        List<RoomDTO> result = new ArrayList<>();
        RoomDTO dto = null;
        int id = 0;
        String name = null;
        String des = null;
        float price = 0;
        String source = null;
        boolean isBooked = false;
        try {
            conn = MyConnection.getMyConnection();
            String sql = "Select ID, Name, Des, Price, Source, isBooked From Rooms Where isDeleted = 0";
            preStm = conn.prepareStatement(sql);
            rs = preStm.executeQuery();
            while (rs.next()) {
                id = rs.getInt("ID");
                name = rs.getString("Name");
                des = rs.getString("Des");
                price = rs.getFloat("Price");
                source = rs.getString("Source");
                isBooked = rs.getBoolean("isBooked");
                dto = new RoomDTO(id, name, des, price, isBooked, source, false);
                result.add(dto);
            }
        } finally {
            closeConnection();
        }
        return result;
    }

    public boolean checkRoom(int id) throws Exception {
        boolean check = true;
        boolean isBooked = false;
        boolean isDeleted = false;
        try {
            conn = MyConnection.getMyConnection();
            String sql = "Select isDeleted From Rooms Where ID = ?";
            preStm = conn.prepareStatement(sql);
            preStm.setInt(1, id);
            rs = preStm.executeQuery();
            if (rs.next()) {
                isBooked = rs.getBoolean("isDeleted");
            }
            if (isDeleted == true) {
                check = false;
            }
        } finally {
            closeConnection();
        }
        return check;
    }

    public RoomDTO findByPrimaryKeyNoCondition(int id) throws Exception {
        RoomDTO dto = null;
        String name = null;
        String des = null;
        float price = 0;
        String source = null;
        boolean isDeleted = false;
        boolean isBooked = false;
        try {
            conn = MyConnection.getMyConnection();
            String sql = "Select Name,Des,Price,Source,isDeleted,isBooked From Rooms Where ID = ?";
            preStm = conn.prepareStatement(sql);
            preStm.setInt(1, id);
            rs = preStm.executeQuery();
            if (rs.next()) {
                name = rs.getString("Name");
                des = rs.getString("Des");
                price = rs.getFloat("Price");
                source = rs.getString("Source");
                isDeleted = rs.getBoolean("isDeleted");
                isBooked = rs.getBoolean("isBooked");
                dto = new RoomDTO(id, name, des, price, isBooked, source, isDeleted);
            }
        } finally {
            closeConnection();
        }
        return dto;
    }

    public boolean updateBookTrue(int id) throws Exception {
        boolean check = false;
        try {
            conn = MyConnection.getMyConnection();
            String sql = "Update Rooms Set isBooked = ? Where ID = ?";
            preStm = conn.prepareStatement(sql);
            preStm.setBoolean(1, true);
            preStm.setInt(2, id);
            check = preStm.executeUpdate() > 0;
        } finally {
            closeConnection();
        }
        return check;
    }

    public int findNewID() throws Exception {
        int id = 0;
        try {
            conn = MyConnection.getMyConnection();
            String sql = "Select max(ID) as ID From Rooms";
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

    public List<RoomDTO> SearchLikeByName(String search) throws Exception {
        List<RoomDTO> result = new ArrayList<>();
        RoomDTO dto = null;
        int id = 0;
        String name = null;
        String des = null;
        float price = 0;
        String source = null;
        boolean isDeleted = false;
        boolean isBooked = false;
        try {
            conn = MyConnection.getMyConnection();
            String sql = "Select ID, Name, Des, Price, isBooked, Source, isDeleted From Rooms Where Name Like ?";
            preStm = conn.prepareStatement(sql);
            preStm.setString(1, "%" + search + "%");
            rs = preStm.executeQuery();
            while (rs.next()) {
                id = rs.getInt("ID");
                name = rs.getString("Name");
                des = rs.getString("Des");
                price = rs.getFloat("Price");
                source = rs.getString("Source");
                isDeleted = rs.getBoolean("isDeleted");
                isBooked = rs.getBoolean("isBooked");
                dto = new RoomDTO(id, name, des, price, isBooked, source, isDeleted);
                result.add(dto);
            }
        } finally {
            closeConnection();
        }
        return result;
    }
}
