package com.company;

import java.util.ArrayList;
import java.util.List;

class Row{
    public String toString() {
        return number + ";" + topingsList;
    }
    public int getNumber() {
        return number;
    }
    public void setNumber(int number) {
        this.number = number;
    }
    public List<Integer> getTopingsList() {
        return topingsList;
    }
    public void setTopingsList(List<Integer> topingsList){
        this.topingsList = topingsList;
    }
    private int number;
    private List<Integer> topingsList = new ArrayList<Integer>();

}
