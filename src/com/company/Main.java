package com.company;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        DataReader dataReader = new DataReader();
        dataReader.dataReaderUtworow("listaUtworow");
        dataReader.dataReaderGosci("listaGosci");
//        dataReader.Execute();
//        Permutations p = new Permutations(dataReader.utwory);
//        p.recursive(dataReader.utwory.size());
//        p.writeToConsole();
//        Mood x = new Mood(dataReader.goscie, dataReader.utwory, p.permutation);
        Gosc g = new Gosc();

    }
}
