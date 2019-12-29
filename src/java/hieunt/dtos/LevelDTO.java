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
public class LevelDTO implements Serializable {

    private int id;
    private String name;
    private int des;
    private String condition;

    public LevelDTO() {
    }

    public LevelDTO(int id, String name, int des) {
        this.id = id;
        this.name = name;
        this.des = des;
    }

    public LevelDTO(int id, String name, int des, String condition) {
        this.id = id;
        this.name = name;
        this.des = des;
        this.condition = condition;
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

    public int getDes() {
        return des;
    }

    public void setDes(int des) {
        this.des = des;
    }

    public String getCondition() {
        return condition;
    }

    public void setCondition(String condition) {
        this.condition = condition;
    }

}
