package com.company;

import java.util.ArrayList;
import java.util.List;

class Row {

    private int id;
    private String name;
    private List<Integer> topingsList = new ArrayList<Integer>();
    private List<String> musicNameList = new ArrayList<String>();

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setId(int number) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Integer> getTopingsList() {
        return topingsList;
    }
    public List<String> getLikedMusicNameList(){
        return musicNameList;
    }

    public void setTopingsList(List<Integer> topingsList) {
        this.topingsList = topingsList;
    }


    public String toString() {
        return "Id: " + getId() + "Name:" + getName() + "TopingsList: " + getTopingsList()
                + "LikedMusicList: " + getLikedMusicNameList();
    }
}
