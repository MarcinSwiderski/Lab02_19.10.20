package com.company;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        DataReader dataReader = new DataReader();
        dataReader.dataReaderUtworow("listaUtworow");
        dataReader.dataReaderGosci("listaGosci");
//        dataReader.Execute();

        Permutations p = new Permutations();
        p.recursive(dataReader.utwory.size(), dataReader.utwory);

        p.writeToConsole();

    }
}
