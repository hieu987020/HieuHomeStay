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
public class ProductDetailDTO implements Serializable {
    private int id, proID, billID, quantity;
    private float price;

    public ProductDetailDTO() {
    }

    public ProductDetailDTO(int id, int proID, int billID, int quantity, float price) {
        this.id = id;
        this.proID = proID;
        this.billID = billID;
        this.quantity = quantity;
        this.price = price;
    }

    public ProductDetailDTO(int proID, int billID, int quantity, float price) {
        this.proID = proID;
        this.billID = billID;
        this.quantity = quantity;
        this.price = price;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getProID() {
        return proID;
    }

    public void setProID(int proID) {
        this.proID = proID;
    }

    public int getBillID() {
        return billID;
    }

    public void setBillID(int billID) {
        this.billID = billID;
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
    
    
    
}
