package com.company;

import java.util.ArrayList;
import java.util.List;

public class Utwor {
    private int id;
    private String name;
    private int topingsList;

    public void setTopingsList(int topingsList) {
        this.topingsList = topingsList;
    }
    public int getTopingsList() {
        return topingsList;
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
    public void setName(String name){
        this.name = name;
    }
}
