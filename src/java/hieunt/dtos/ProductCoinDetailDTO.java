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
public class ProductCoinDetailDTO implements Serializable {
    private int id, proID, billCoinID, quantity, coin;

    public ProductCoinDetailDTO() {
    }

    public ProductCoinDetailDTO(int id, int proID, int billCoinID, int quantity, int coin) {
        this.id = id;
        this.proID = proID;
        this.billCoinID = billCoinID;
        this.quantity = quantity;
        this.coin = coin;
    }

    public ProductCoinDetailDTO(int proID, int billCoinID, int quantity, int coin) {
        this.proID = proID;
        this.billCoinID = billCoinID;
        this.quantity = quantity;
        this.coin = coin;
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

    public int getBillCoinID() {
        return billCoinID;
    }

    public void setBillCoinID(int billCoinID) {
        this.billCoinID = billCoinID;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getCoin() {
        return coin;
    }

    public void setCoin(int coin) {
        this.coin = coin;
    }
    
}
