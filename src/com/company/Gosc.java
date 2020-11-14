package com.company;

import java.util.*;

public class Gosc {

    public List<Integer> getTopingsList() {
        return topingsList;
    }
    public List<String> getLikedMusicNameList(){
        return musicNameList;
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public void setNameAndTime(String x,Integer y) {
//        Map<String,Integer> i = new HashMap<>();
        nameAndTime.put(x,y);
    }
    public int getWagaMax() {
        return wagaMax;
    }

    public void setWagaMax(int wagaMax) {
        List<Integer> sortedList = getTopingsList();
        Collections.sort(sortedList);
        wagaMax = sortedList.get(0);
        this.wagaMax = wagaMax;

    }
    public int getWagaMin() {
        return wagaMin;
    }

    public void setWagaMin(int wagaMin) {
        List<Integer> sortedList = getTopingsList();
        Collections.sort(sortedList);
        wagaMin = sortedList.get(sortedList.size());
        this.wagaMin = wagaMin;
    }
    public int getSuma() {
        return suma;
    }

    public void setSuma(int suma) {
        this.suma = suma;
    }

    private int id;
    private int wagaMax;
    private int wagaMin;
    private int suma;
    private  List<Integer> topingsList = new ArrayList<Integer>();
    private  List<String> musicNameList = new ArrayList<String>();
    private Map<String,Integer> nameAndTime = new HashMap<>();

    //    public String toString() {
//        return "Id: " + getId() + " Name:" + getName() + " TopingsList: " + getTopingsList()
//                + " LikedMusicList: " + getLikedMusicNameList();
//    }
}
