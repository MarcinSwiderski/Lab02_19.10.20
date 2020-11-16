package com.company;


import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class DataReader {
    public List<Utwor> utwory = new LinkedList<Utwor>();
    public List<Gosc> goscie = new LinkedList<Gosc>();

    public void dataReaderUtworow(String fileName) {
        try (Scanner s = new Scanner(new File(fileName))) {
            s.nextLine();
            if (fileName == "listaUtworow") {
                s.useDelimiter(";|\\r?\\n|\\r|\\|");
                while (s.hasNext()) {
                    Utwor r = new Utwor();
                    r.setId(s.nextInt());
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
                while (lineScanner.hasNext()) {
                    String[] splitedData = lineScanner.next().split(",");
                    r.getLikedMusicNameList().add(splitedData[0]);
                    r.getTopingsList().add(Integer.valueOf(splitedData[1]));
                }
                goscie.add(r);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            System.out.print("File not found!");
        }

}}

