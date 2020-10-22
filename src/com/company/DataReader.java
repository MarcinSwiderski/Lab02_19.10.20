package com.company;


import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class DataReader {

    public DataReader(String fileName){
        List<Row> r1 = new LinkedList<Row>();
        try(Scanner s = new Scanner(new File(fileName))) {
            s.nextLine();
            s.useDelimiter(";|\\r?\\n|\\r");
            while (s.hasNext()) {
                Row r = new Row();
                r.setNumber(s.nextInt());
                r.setName(s.next());
                String[] listaDodatkow = s.next().split(",");
                for(String str : listaDodatkow) {
                    r.getTopingsList().add(Integer.parseInt(str.trim()));
                }
                r1.add(r);
            }
        }
        catch (FileNotFoundException e ) {
            e.printStackTrace();
            System.out.print("EEE");
        }
        for(int i=0; i<r1.size(); i++)
        {
            System.out.println(r1.get(i));
        }

    }
}
