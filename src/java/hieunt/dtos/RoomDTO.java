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
public class RoomDTO implements Serializable {

    private int id;
    private String name, des;
    private float price;
    private boolean book;
    private String source;
    private boolean delete;

    public RoomDTO() {
    }

    public RoomDTO(int id, String name, String des, float price, boolean book, String source) {
        this.id = id;
        this.name = name;
        this.des = des;
        this.price = price;
        this.book = book;
        this.source = source;
    }

    public RoomDTO(String name, String des, float price, boolean book, String source, boolean delete) {
        this.name = name;
        this.des = des;
        this.price = price;
        this.book = book;
        this.source = source;
        this.delete = delete;
    }


    public RoomDTO(int id, String name, String des, float price, boolean book, String source, boolean delete) {
        this.id = id;
        this.name = name;
        this.des = des;
        this.price = price;
        this.book = book;
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

    public String getDes() {
        return des;
    }

    public void setDes(String des) {
        this.des = des;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public boolean isBook() {
        return book;
    }

    public void setBook(boolean book) {
        this.book = book;
    }

    public boolean isDelete() {
        return delete;
    }

    public void setDelete(boolean delete) {
        this.delete = delete;
    }

}
