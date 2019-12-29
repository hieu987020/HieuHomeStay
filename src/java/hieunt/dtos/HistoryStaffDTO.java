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
public class HistoryStaffDTO implements Serializable {

    private int id, infoID;
    private String des, time;

    public HistoryStaffDTO() {
    }

    public HistoryStaffDTO(int infoID, String des, String time) {
        this.infoID = infoID;
        this.des = des;
        this.time = time;
    }
    
    public void setId(int id) {
        this.id = id;
    }

    public void setInfoID(int infoID) {
        this.infoID = infoID;
    }

    public void setDes(String des) {
        this.des = des;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public int getId() {
        return id;
    }

    public int getInfoID() {
        return infoID;
    }

    public String getDes() {
        return des;
    }

    public String getTime() {
        return time;
    }

}
