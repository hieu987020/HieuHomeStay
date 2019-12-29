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
public class BillDTO implements Serializable {
    private int id, infoID, staffID;
    private String dateFrom, dateTo;
    private float sumBefore, discount, sumAfter;
    private String time;
    private boolean approved;

    public BillDTO() {
    }

    public BillDTO(int id, int infoID, int staffID, String dateFrom, String dateTo, float sumBefore, float discount, float sumAfter, String time, boolean approved) {
        this.id = id;
        this.infoID = infoID;
        this.staffID = staffID;
        this.dateFrom = dateFrom;
        this.dateTo = dateTo;
        this.sumBefore = sumBefore;
        this.discount = discount;
        this.sumAfter = sumAfter;
        this.time = time;
        this.approved = approved;
    }

    public BillDTO(int id, int staffID, float sumBefore, float discount, float sumAfter, String time) {
        this.id = id;
        this.staffID = staffID;
        this.sumBefore = sumBefore;
        this.discount = discount;
        this.sumAfter = sumAfter;
        this.time = time;
    }

    public BillDTO(int infoID, String dateFrom, String dateTo, boolean approved) {
        this.infoID = infoID;
        this.dateFrom = dateFrom;
        this.dateTo = dateTo;
        this.approved = approved;
    }

    public BillDTO(int id, String time, boolean approved) {
        this.id = id;
        this.time = time;
        this.approved = approved;
    }
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getInfoID() {
        return infoID;
    }

    public void setInfoID(int infoID) {
        this.infoID = infoID;
    }

    public int getStaffID() {
        return staffID;
    }

    public void setStaffID(int staffID) {
        this.staffID = staffID;
    }

    public String getDateFrom() {
        return dateFrom;
    }

    public void setDateFrom(String dateFrom) {
        this.dateFrom = dateFrom;
    }

    public String getDateTo() {
        return dateTo;
    }

    public void setDateTo(String dateTo) {
        this.dateTo = dateTo;
    }

    public float getSumBefore() {
        return sumBefore;
    }

    public void setSumBefore(float sumBefore) {
        this.sumBefore = sumBefore;
    }

    public float getDiscount() {
        return discount;
    }

    public void setDiscount(float discount) {
        this.discount = discount;
    }

    public float getSumAfter() {
        return sumAfter;
    }

    public void setSumAfter(float sumAfter) {
        this.sumAfter = sumAfter;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public boolean isApproved() {
        return approved;
    }

    public void setApproved(boolean approved) {
        this.approved = approved;
    }
    
}
