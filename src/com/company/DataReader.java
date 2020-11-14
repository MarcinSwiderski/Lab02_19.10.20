package com.company;


import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;
import com.company.Utwor;

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
//        for (int i = 0; i < utwory.size(); i++) {
//            System.out.println(utwory.get(i).getName());
//            System.out.println(utwory.get(i).getTopingsList());
//        }
//        System.out.println(utwory.get(1).getId());
    }

    public void Execute() {
//        Humor(utwory, goscie);
        kazdaZkazda();
    }

    public void Humor(List<Utwor> u, List<Gosc> g) {
        {
//            System.out.println("XD1");
            for (Utwor x : u) {
//                System.out.println("XD2");
                for (Gosc v : g) {
//                    System.out.println("X3");
                    for (int i = 0; i < v.getLikedMusicNameList().size(); i++) {
                        System.out.println(v.getLikedMusicNameList().get(i) + "=========");
                        System.out.println(x.getName() + "----------------");
                        if (x.getName().equals(v.getLikedMusicNameList().get(i))) {
                            System.out.println(x.getName());
//                            v.getMaxZadowolenie().add((v.getTopingsList().get(i) - v.minimalMultiplayer())/);
//                            System.out.println(v.getMaxZadowolenie().get(i+1));
                        }
                    }
                }
            }
        }
    }
    public void kazdaZkazda(){
        Map<String,String> x =new HashMap<>();
        int y=0;
        int z = utwory.size();
        while(z > 0){
            for (int i = 0; i < utwory.size() ; i++) {
                System.out.println(utwory.get(y) + "XDD");
                x.put(utwory.get(y).getName(),utwory.get(i).getName());
            }
            y++;
            z--;
        }
        x.forEach((key, value) -> System.out.println(key + ":" + value));
    }
}
