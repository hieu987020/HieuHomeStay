/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hieunt.dtos;

import java.io.Serializable;
import java.util.HashMap;

/**
 *
 * @author hieu
 */
public class CartObj implements Serializable {

    private float total;
    private HashMap<Integer, Float> cart;

    public void addToCart(int id, float price) throws Exception {
        int quantity = 1;
        this.cart.put(id, price);
    }

    public void removeCart(int id) throws Exception {
        if (this.cart.containsKey(id)) {
            this.cart.remove(id);
        }
    }
    
    public void removeAll() throws Exception {
        this.cart.clear();
    }
    
    public CartObj() {
        this.cart = new HashMap<>();
    }

    public HashMap<Integer, Float> getCart() {
        return cart;
    }

    public float getTotal() {
        total = 0;
        for (float price : this.cart.values()) {
            total += price;
        }             
        return total;
    }
    
    
    public void setTotal(float total) {
        this.total = total;
    }

}
