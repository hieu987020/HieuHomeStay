/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hieunt.daos;

import hieunt.db.MyConnection;
import hieunt.dtos.ProductDTO;
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
public class ProductDAO implements Serializable {

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

    public List<ProductDTO> listAllProduct() throws Exception {
        List<ProductDTO> result = new ArrayList<>();
        ProductDTO dto = null;
        int id = 0;
        String name = null;
        int quantity = 0;
        float price = 0;
        int coin = 0;
        String type = null;
        String source = null;
        boolean isDelete = false;
        try {
            conn = MyConnection.getMyConnection();
            String sql = "Select ID,Name,Quantity,Price,Coin,Type,Source,isDeleted From Products";
            preStm = conn.prepareStatement(sql);
            rs = preStm.executeQuery();
            while (rs.next()) {
                id = rs.getInt("ID");
                name = rs.getString("Name");
                quantity = rs.getInt("Quantity");
                price = rs.getFloat("Price");
                coin = rs.getInt("Coin");
                type = rs.getString("Type");
                source = rs.getString("Source");
                isDelete = rs.getBoolean("isDeleted");
                dto = new ProductDTO(id, name, quantity, price, coin, type, source, isDelete);
                result.add(dto);
            }

        } finally {
            closeConnection();
        }
        return result;
    }

    public boolean insert(ProductDTO dto) throws Exception {
        boolean check = false;
        try {
            conn = MyConnection.getMyConnection();
            String sql = "Insert Into Products(Name,Quantity,Price,Coin,Type,Source,isDeleted) values(?,?,?,?,?,?,?)";
            preStm = conn.prepareStatement(sql);
            preStm.setString(1, dto.getName());
            preStm.setInt(2, dto.getQuantity());
            preStm.setFloat(3, dto.getPrice());
            preStm.setInt(4, dto.getCoin());
            preStm.setString(5, dto.getType());
            preStm.setString(6, dto.getSource());
            preStm.setBoolean(7, dto.isDelete());
            check = preStm.executeUpdate() > 0;
        } finally {
            closeConnection();
        }
        return check;
    }

    public ProductDTO findByPrimaryKey(int id) throws Exception {
        ProductDTO dto = null;
        String name = null;
        int quantity = 0;
        float price = 0;
        int coin = 0;
        String type = null;
        String source = null;
        boolean isDelete = false;
        try {
            conn = MyConnection.getMyConnection();
            String sql = "Select Name,Quantity,Price,Coin,Type,Source,isDeleted From Products Where ID = ?";
            preStm = conn.prepareStatement(sql);
            preStm.setInt(1, id);
            rs = preStm.executeQuery();
            if (rs.next()) {
                name = rs.getString("Name");
                quantity = rs.getInt("Quantity");
                price = rs.getFloat("Price");
                coin = rs.getInt("Coin");
                type = rs.getString("Type");
                source = rs.getString("Source");
                isDelete = rs.getBoolean("isDeleted");
                dto = new ProductDTO(id, name, quantity, price, coin, type, source, isDelete);
            }
        } finally {
            closeConnection();
        }
        return dto;
    }

    public boolean update(ProductDTO dto) throws Exception {
        boolean check = false;
        try {
            conn = MyConnection.getMyConnection();
            String sql = "Update Products Set Name = ?, Quantity = ?, Price = ?, Coin = ?,Type = ?,Source = ?, isDeleted = ? Where ID = ?";
            preStm = conn.prepareStatement(sql);
            preStm.setString(1, dto.getName());
            preStm.setInt(2, dto.getQuantity());
            preStm.setFloat(3, dto.getPrice());
            preStm.setInt(4, dto.getCoin());
            preStm.setString(5, dto.getType());
            preStm.setString(6, dto.getSource());
            preStm.setBoolean(7, dto.isDelete());
            preStm.setInt(8, dto.getId());
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
            String sql = "Update Products Set isDeleted = ? Where ID = ?";
            preStm = conn.prepareStatement(sql);
            preStm.setBoolean(1, true);
            preStm.setInt(2, id);
            check = preStm.executeUpdate() > 0;
        } finally {
            closeConnection();
        }
        return check;
    }

    public List<ProductDTO> listAllProductToShow() throws Exception {
        List<ProductDTO> result = new ArrayList<>();
        ProductDTO dto = null;
        int id = 0;
        String name = null;
        int quantity = 0;
        float price = 0;
        int coin = 0;
        String type = null;
        String source = null;
        boolean isDelete = false;
        try {
            conn = MyConnection.getMyConnection();
            String sql = "Select ID,Name,Quantity,Price,Coin,Type,Source From Products Where isDeleted = 0";
            preStm = conn.prepareStatement(sql);
            rs = preStm.executeQuery();
            while (rs.next()) {
                id = rs.getInt("ID");
                name = rs.getString("Name");
                quantity = rs.getInt("Quantity");
                price = rs.getFloat("Price");
                coin = rs.getInt("Coin");
                type = rs.getString("Type");
                source = rs.getString("Source");
                dto = new ProductDTO(id, name, quantity, price, coin, type, source, false);
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
            String sql = "Select max(ID) as ID From Products";
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

    public List<ProductDTO> searchLikeByName(String search) throws Exception {
        List<ProductDTO> result = new ArrayList<>();
        ProductDTO dto = null;
        int id = 0;
        String name = null;
        int quantity = 0;
        float price = 0;
        int coin = 0;
        String type = null;
        String source = null;
        boolean isDelete = false;
        try {
            conn = MyConnection.getMyConnection();
            String sql = "Select ID, Name, Quantity, Price, Coin, Type, Source, isDeleted From Products Where Name Like ?";
            preStm = conn.prepareCall(sql);
            preStm.setString(1, "%" + search + "%");
            rs = preStm.executeQuery();
            while (rs.next()) {
                id = rs.getInt("ID");
                name = rs.getString("Name");
                quantity = rs.getInt("Quantity");
                price = rs.getFloat("Price");
                coin = rs.getInt("Coin");
                type = rs.getString("Type");
                source = rs.getString("Source");
                isDelete = rs.getBoolean("isDeleted");
                dto = new ProductDTO(id, name, quantity, price, coin, type, source, isDelete);
                result.add(dto);
            }
        } finally {
            closeConnection();
        }
        return result;
    }
}
