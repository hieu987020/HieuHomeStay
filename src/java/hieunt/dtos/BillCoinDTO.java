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
public class BillCoinDTO implements Serializable {

    private int id, infoID, coin;
    private String time;
    boolean isApproved;

    public BillCoinDTO() {
    }

    public BillCoinDTO(int id, int infoID, int coin, String time) {
        this.id = id;
        this.infoID = infoID;
        this.coin = coin;
        this.time = time;
    }

    public BillCoinDTO(int id, int infoID, int coin, String time, boolean isApproved) {
        this.id = id;
        this.infoID = infoID;
        this.coin = coin;
        this.time = time;
        this.isApproved = isApproved;
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

    public int getCoin() {
        return coin;
    }

    public void setCoin(int coin) {
        this.coin = coin;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public boolean isIsApproved() {
        return isApproved;
    }

    public void setIsApproved(boolean isApproved) {
        this.isApproved = isApproved;
    }

}
