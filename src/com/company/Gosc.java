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
    public int getWagaMax() {
        return wagaMax;
    }

    public void setWagaMax(int wagaMax) {
        this.wagaMax = wagaMax;

    }
    public int getWagaMin() {
        return wagaMin;
    }

    public void setWagaMin(int wagaMin) {
        this.wagaMin = wagaMin;
    }
    public int getSuma() {
        return suma;
    }

    private  List<Integer> topingsList = new ArrayList<Integer>();

    public List<String> getMusicNameList() {
        return musicNameList;
    }

    public void setMusicNameList(List<String> musicNameList) {
        this.musicNameList = musicNameList;
    }

    private  List<String> musicNameList = new ArrayList<String>();
    private Map<String,Integer> nameAndTime = new HashMap<>();
    private int id;
    private int wagaMax;
    private int wagaMin;
    private int suma = 100;
    //    public String toString() {
//        return "Id: " + getId() + " Name:" + getName() + " TopingsList: " + getTopingsList()
//                + " LikedMusicList: " + getLikedMusicNameList();
//    }
}
