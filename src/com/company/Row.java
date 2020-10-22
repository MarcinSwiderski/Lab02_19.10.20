package com.company;

import java.util.ArrayList;
import java.util.List;

class Row {
    public String toString() {
        return getNumber() + ";" + getName() + ";" + getTopingsList();
    }

    public int getNumber() {
        return number;
    }

    public String getName() {
        return name;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Integer> getTopingsList() {
        return topingsList;
    }

    public void setTopingsList(List<Integer> topingsList) {
        this.topingsList = topingsList;
    }

    private int number;
    private String name;
    private List<Integer> topingsList = new ArrayList<Integer>();

}
