package com.company;


import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;
import java.util.zip.ZipEntry;

import com.company.Utwor;

import javax.swing.plaf.nimbus.NimbusLookAndFeel;

public class DataReader {
    List<Utwor> utwory = new LinkedList<Utwor>();
    List<Gosc> goscie = new LinkedList<Gosc>();

    public void dataReaderUtworow(String fileName) {
        try (Scanner s = new Scanner(new File(fileName))) {
            s.nextLine();
            if (fileName == "listaUtworow") {
                s.useDelimiter(";|\\r?\\n|\\r|\\|");
                while (s.hasNext()) {
                    Utwor r = new Utwor();
//                    System.out.println(s.next());
                    r.setId(s.nextInt());
//                    System.out.println(r.getId());
                    r.setName(s.next());
                    r.setTopingsList(s.nextInt());
                    utwory.add(r);
                }
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
            System.out.print("File not found!");
        }
    }

    public void dataReaderGosci(String fileName) {
        try (Scanner s = new Scanner(new File(fileName))) {
            s.nextLine();
            s.useDelimiter(";|\\|");
            while (s.hasNextLine()) {
                String line = s.nextLine();
                Scanner lineScanner = new Scanner(line);
                Gosc r = new Gosc();
                lineScanner.useDelimiter(";|\\|");
                r.setId(lineScanner.nextInt());
//                    System.out.println(lineScanner.next());
                while (lineScanner.hasNext()) {
                    String[] splitedData = lineScanner.next().split(",");
                    r.getLikedMusicNameList().add(splitedData[0]);
                    r.getTopingsList().add(Integer.valueOf(splitedData[1]));
//                r.setNameAndTime(splitedData[0], Integer.valueOf(splitedData[1]));
//                    lineScanner.next();
//                    lineScanner.next();
                }
                goscie.add(r);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            System.out.print("File not found!");
        }
        for (int i = 0; i < goscie.size(); i++) {
            List<Integer> sortedList = new ArrayList<>();
            sortedList.addAll(goscie.get(i).getTopingsList());
            Collections.sort(sortedList);
            for (int j = 0; j <sortedList.size() ; j++) {


                        goscie.get(i).setWagaMin(sortedList.get(0));
                        System.out.println(goscie.get(i).getWagaMin() + "  Gosc: " + i + " wagaMAX");
                        goscie.get(i).setWagaMax(sortedList.size());
                        System.out.println(goscie.get(i).getWagaMax() +" wagaMin");
        }}

        for (int i = 0; i < goscie.size(); i++) {
            for (int j = 0; j < goscie.get(i).getLikedMusicNameList().size(); j++) {
//                System.out.println(zadowolenie(goscie.get(i).getLikedMusicNameList().get(j), goscie.get(i)) + " zad");
//                System.out.println(niezadowolenie(goscie.get(i).getLikedMusicNameList().get(j), goscie.get(i)) + " niezad");
            }
        }
    }

    public double zadowolenie(String typMuzyki, Gosc gosc) {
        double wynik=0;
        for (int i = 0; i < gosc.getLikedMusicNameList().size(); i++) {
            if (typMuzyki.equals(gosc.getLikedMusicNameList().get(i))) {
                int x = gosc.getTopingsList().get(i);
                wynik = (x - gosc.getWagaMin()) / (float)gosc.getSuma();
                return wynik;
            }
        }
        wynik = (0 - gosc.getWagaMin()) / (float)gosc.getSuma();


        return wynik;
    }

    public float niezadowolenie(String typMuzyki, Gosc gosc) {
        for (int i = 0; i < gosc.getLikedMusicNameList().size(); i++) {
            if (typMuzyki.equals(gosc.getLikedMusicNameList().get(i))) {
                System.out.println("niezadowolenie");
                int x = gosc.getTopingsList().get(i);
                return (gosc.getWagaMax() - x) / (float)gosc.getSuma();
            }
        }
        return gosc.getWagaMin() / (float)gosc.getSuma();
    }
}
//    public void Execute() {
////        Humor(utwory, goscie);
//    }}

//    public void Humor(List<Utwor> u, List<Gosc> g) {
//        {
////            System.out.println("XD1");
//            for (Utwor x : u) {
////                System.out.println("XD2");
//                for (Gosc v : g) {
////                    System.out.println("X3");
//                    for (int i = 0; i < v.getLikedMusicNameList().size(); i++) {
//                        System.out.println(v.getLikedMusicNameList().get(i) + "=========");
//                        System.out.println(x.getName() + "----------------");
//                        if (x.getName().equals(v.getLikedMusicNameList().get(i))) {
//                            System.out.println(x.getName());
////                            v.getMaxZadowolenie().add((v.getTopingsList().get(i) - v.minimalMultiplayer())/);
////                            System.out.println(v.getMaxZadowolenie().get(i+1));
//
//                        }
//                    }
//                }
//            }
//        }}}



