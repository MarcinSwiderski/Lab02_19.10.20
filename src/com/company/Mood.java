package com.company;

import java.util.List;

public class Mood {
    public Mood(List<Gosc> g, List<Utwor> u, List<List<Utwor>> p){
        for (List<Utwor> k:p) {
            for (int i = 0; i <k.size() ; i++) {
                for (int j = 0; j <g.size(); j++) {
//                    System.out.println(k.get(i).getName());
//                    System.out.println(g.get(1).zadowolenie(k.get(i).getName(), g.get(1)));
                }
            }
        }
    }
}
