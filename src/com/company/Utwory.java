package com.company;

import java.util.ArrayList;
import java.util.List;

public class Utwory {
    private int id;
    private String name;
    private List<Integer> topingsList = new ArrayList<Integer>();

    public List<Integer> getTopingsList() {
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
