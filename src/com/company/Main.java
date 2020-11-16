package com.company;

import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        DataReader dataReader = new DataReader();
        dataReader.dataReaderUtworow("listaUtworow");
        dataReader.dataReaderGosci("listaGosci");
        Scanner sc = new Scanner(System.in);
        System.out.println("Wpisz czas imprezy!");
        int czasImprezy = sc.nextInt();
        Permutations p = new Permutations(dataReader.utwory);
        p.recursive(dataReader.utwory.size());
        Mood x = new Mood(dataReader.goscie, dataReader.utwory, p.permutation, czasImprezy);
    }
}
