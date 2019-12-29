/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hieunt.dtos;

import java.io.Serializable;

/**
 *
 * @author hieu
 */
public class ProductDTO implements Serializable {

    private int id;
    private String name;
    private int quantity;
    private float price;
    private int coin;
    private String type;
    private String source;
    private boolean delete;

    public ProductDTO() {
    }

    public ProductDTO(int id, String name, int quantity, float price, int coin, String type, String source) {
        this.id = id;
        this.name = name;
        this.quantity = quantity;
        this.price = price;
        this.coin = coin;
        this.type = type;
        this.source = source;
    }

    public ProductDTO(String name, int quantity, float price, int coin, String type, String source, boolean delete) {
        this.name = name;
        this.quantity = quantity;
        this.price = price;
        this.coin = coin;
        this.type = type;
        this.source = source;
        this.delete = delete;
    }

    public ProductDTO(int id, String name, int quantity, float price, int coin, String type, String source, boolean delete) {
        this.id = id;
        this.name = name;
        this.quantity = quantity;
        this.price = price;
        this.coin = coin;
        this.type = type;
        this.source = source;
        this.delete = delete;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public int getCoin() {
        return coin;
    }

    public void setCoin(int coin) {
        this.coin = coin;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public boolean isDelete() {
        return delete;
    }

    public void setDelete(boolean delete) {
        this.delete = delete;
    }

}
