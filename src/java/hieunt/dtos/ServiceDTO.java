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
public class ServiceDTO implements Serializable {

    private int id;
    private String name;
    private float price;
    private String des;
    private String source;
    private boolean delete;

    public ServiceDTO() {
    }

    public ServiceDTO(String name, float price, String des, String source, boolean delete) {
        this.name = name;
        this.price = price;
        this.des = des;
        this.source = source;
        this.delete = delete;
    }

    public ServiceDTO(int id, String name, float price, String des, String source) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.des = des;
        this.source = source;
    }

    public ServiceDTO(int id, String name, float price, String des, String source, boolean delete) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.des = des;
        this.source = source;
        this.delete = delete;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public String getDes() {
        return des;
    }

    public void setDes(String des) {
        this.des = des;
    }

    public boolean isDelete() {
        return delete;
    }

    public void setDelete(boolean delete) {
        this.delete = delete;
    }

}
