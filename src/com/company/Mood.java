package com.company;

import javax.net.ssl.SSLContext;
import java.util.*;
import java.util.function.DoubleBinaryOperator;
import java.util.zip.ZipEntry;

public class Mood {

    public Mood(List<Gosc> goscie, List<Utwor> utwory, List<List<Utwor>> listaUtworow, int czasImprezy) {
        liczenieWag(goscie);
        double sumaZadowolenDlaKombinacji = 0;
        double sumaNiezadowolenDlaKombinacji = 0;
        double sumaNiezdowolenGosciWedlugUtworu = 0;
        double sumaZadowolenGosciaWedlugUtworu = 0;
        int czasAktualnejKombinacji = czasImprezy;
        int najkrotszyUtwor = liczenieNajkrotszegoUtworu(listaUtworow.get(0));
        int ileUtworowSieZmiescilo = 0;
        String odpowiedzZadowolenie="";
        String odpowiedzNiezadowolenie="";
        StringBuilder jakieSieZmiescily = new StringBuilder("");
        StringBuilder bufor = new StringBuilder("");



        for (List<Utwor> k : listaUtworow) {
            sumaZadowolenGosciaWedlugUtworu = 0;

            for (int i = 0; i < goscie.size(); i++) {
                czasAktualnejKombinacji = czasImprezy;
                for (int j = 0; j < k.size(); j++) {
                    if (czasAktualnejKombinacji - k.get(j).getTopingsList() >= 0) {
                        jakieSieZmiescily.append(k.get(j).getId() + " ");
                        czasAktualnejKombinacji -= k.get(j).getTopingsList();
                        sumaZadowolenGosciaWedlugUtworu += zadowolenie(k.get(j).getName(), goscie.get(i));
                        sumaNiezdowolenGosciWedlugUtworu += niezadowolenie(k.get(j).getName(), goscie.get(i));
                    } else if (czasAktualnejKombinacji < najkrotszyUtwor)
                        break;
                    if(czasAktualnejKombinacji > najkrotszyUtwor && j == k.size()-1)
                        j=0;
                }

                if(sumaZadowolenDlaKombinacji < sumaZadowolenGosciaWedlugUtworu ){
                    sumaZadowolenDlaKombinacji = sumaZadowolenGosciaWedlugUtworu;
                    odpowiedzZadowolenie = jakieSieZmiescily.toString();
                }

                if(sumaNiezadowolenDlaKombinacji < sumaNiezdowolenGosciWedlugUtworu){
                    sumaNiezadowolenDlaKombinacji = sumaNiezdowolenGosciWedlugUtworu;
                    odpowiedzNiezadowolenie = jakieSieZmiescily.toString();

                }
                jakieSieZmiescily.setLength(0);

            }
        }
        wypisanieWyniku(odpowiedzZadowolenie, odpowiedzNiezadowolenie);
    }
    public void wypisanieWyniku(String odpZadowolenie, String odpNiezadowolenie){
        System.out.println("Kolejność utworow maksymalizująca zadowolenie: " + odpZadowolenie );
        System.out.println("Kolejność utworów maksymalizująca niezadowolenie: " + odpNiezadowolenie);

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

    public int liczenieNajkrotszegoUtworu(List<Utwor> u) {
        int min = u.get(0).getTopingsList();
        for (int i = 0; i < u.size() - 1; i++) {
            if (u.get(i + 1).getTopingsList() < u.get(i).getTopingsList())
                min = u.get(i + 1).getTopingsList();
        }
        return min;
    }

    public float niezadowolenie(String typMuzyki, Gosc gosc) {
        for (int i = 0; i < gosc.getLikedMusicNameList().size(); i++) {
            if (typMuzyki.equals(gosc.getLikedMusicNameList().get(i))) {
                int x = gosc.getTopingsList().get(i);
                return (gosc.getWagaMax() - x) / (float) gosc.getSuma();
            }
        }
        return gosc.getWagaMin() / (float) gosc.getSuma();
    }

}
