package com.company;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Humor {
    /**
     * Bada i zapisuje zadowolenie i niezadowolenie, oblicza wagi
     */
    public Humor(List<Gosc> goscie, List<Utwor> utwory) {
        liczenieWag(goscie);
        for (int i = 0; i < goscie.size(); i++) {
            for (int j = 0; j < utwory.size(); j++) {
                System.out.println(zadowolenie(utwory.get(j).getName(), goscie.get(i)) + " zad");
                System.out.println(niezadowolenie(utwory.get(j).getName(), goscie.get(i)) + " niezad");
                System.out.println();
            }
        }

    }



    public void liczenieWag(List<Gosc> goscie) {
        for (int i = 0; i < goscie.size(); i++) {
            List<Integer> sortedList = new ArrayList<>();
            sortedList.addAll(goscie.get(1).getTopingsList());
            Collections.sort(sortedList);
            goscie.get(i).setWagaMin(sortedList.get(0));
            goscie.get(i).setWagaMax(sortedList.get(sortedList.size() - 1));
        }
    }




    public double zadowolenie(String typMuzyki, Gosc gosc) {
        double wynik = 0;
        System.out.println("Id goscia: " + gosc.getId());
        for (int i = 0; i < gosc.getLikedMusicNameList().size(); i++) {
            if (typMuzyki.equals(gosc.getLikedMusicNameList().get(i))) {
                int x = gosc.getTopingsList().get(i);
                wynik = (x - gosc.getWagaMin()) / (float) gosc.getSuma();
                return wynik;
            }
        }
        wynik = (0 - gosc.getWagaMin()) / (float) gosc.getSuma();
        return wynik;
    }

    public float niezadowolenie(String typMuzyki, Gosc gosc) {
        for (int i = 0; i < gosc.getLikedMusicNameList().size(); i++) {
            if (typMuzyki.equals(gosc.getLikedMusicNameList().get(i))) {
                System.out.println("niezadowolenie");
                int x = gosc.getTopingsList().get(i);
                return (gosc.getWagaMax() - x) / (float) gosc.getSuma();
            }
        }
        return gosc.getWagaMin() / (float) gosc.getSuma();
    }
}
