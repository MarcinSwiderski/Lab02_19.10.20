package com.company;


import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class DataReader {

    public DataReader(String fileName) {
        List<Row> utwory = new LinkedList<Row>();
        List<Row> goscie = new LinkedList<Row>();
        try (Scanner s = new Scanner(new File(fileName))) {
            s.nextLine();
            if (fileName == "listaUtworow") {
                s.useDelimiter(";|\\r?\\n|\\r");
                while (s.hasNext()) {
                    Row r = new Row();
                    r.setId(s.nextInt());
                    r.setName(s.next());
                    String[] listaDodatkow = s.next().split(",");
                    for (String str : listaDodatkow) {
                        r.getTopingsList().add(Integer.parseInt(str.trim()));
                    }
                    utwory.add(r);
                }
            } else if (fileName == "listaGosci") {
                s.useDelimiter(";|\\|");
                while (s.hasNextLine()) {
                    String line = s.nextLine();
                    Scanner lineScanner = new Scanner(line);
                    Row r = new Row();
                    lineScanner.useDelimiter(";|\\|");
                    r.setId(lineScanner.nextInt());
                    while (lineScanner.hasNext()) {
                        String[] splitedData = lineScanner.next().split(",");
                        r.getLikedMusicNameList().add(splitedData[0]);
                        r.getTopingsList().add(Integer.valueOf(splitedData[1]));
                    }
                    goscie.add(r);
                }
            } else {
                System.out.println("Unknown filename ( unknown data patern )");
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
            System.out.print("File not found!");
        }
        for (int i = 0; i < utwory.size(); i++) {
            System.out.println(goscie.get(i));
        }

    }
}
