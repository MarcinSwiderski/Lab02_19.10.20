package com.company;

import java.util.*;

public class Gosc {
    private int id;
    private  List<Integer> topingsList = new ArrayList<Integer>();
    private  List<String> musicNameList = new ArrayList<String>();
    private Map<String,Integer> nameAndTime = new HashMap<>();
    private  List<Integer> maxZadowolenie = new ArrayList<Integer>();
    private  List<Integer> minZadowolenie = new ArrayList<Integer>();
    private  List<Integer> maxNiezadowolenie = new ArrayList<Integer>();
    private  List<Integer> minNiezadowolenie = new ArrayList<Integer>();

    public int minimalMultiplayer(){
        List<Integer> sortedList = getTopingsList();
        Collections.sort(sortedList);
        return sortedList.get(0);
    }
    public List<Integer> getTopingsList() {
        return topingsList;
    }
    public List<String> getLikedMusicNameList(){
        return musicNameList;
    }
    public List<Integer> getMaxZadowolenie() {
        return maxZadowolenie;
    }
    public List<Integer> getMinZadowolenie() {
        return minZadowolenie;
    }
    public List<Integer> getMaxNiezadowolenie() {
        return maxNiezadowolenie;
    }
    public List<Integer> getMinNiezadowolenie() {
        return minNiezadowolenie;
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
//    public String toString() {
//        return "Id: " + getId() + " Name:" + getName() + " TopingsList: " + getTopingsList()
//                + " LikedMusicList: " + getLikedMusicNameList();
//    }

}
