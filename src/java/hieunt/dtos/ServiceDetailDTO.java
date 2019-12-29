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
public class ServiceDetailDTO implements Serializable {

    private int id, serID, billID;
    private float price;

    public ServiceDetailDTO() {
    }

    public ServiceDetailDTO(int id, int serID, int billID, float price) {
        this.id = id;
        this.serID = serID;
        this.billID = billID;
        this.price = price;
    }

    public ServiceDetailDTO(int serID, int billID, float price) {
        this.serID = serID;
        this.billID = billID;
        this.price = price;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getSerID() {
        return serID;
    }

    public void setSerID(int serID) {
        this.serID = serID;
    }

    public int getBillID() {
        return billID;
    }

    public void setBillID(int billID) {
        this.billID = billID;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

}
