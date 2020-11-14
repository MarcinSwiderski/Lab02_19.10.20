package com.company;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        DataReader dataReader = new DataReader();
        dataReader.dataReaderUtworow("listaUtworow");
        dataReader.dataReaderGosci("listaGosci");
//        dataReader.Execute();

        Permutations p = new Permutations(dataReader.utwory);
        p.recursive(dataReader.utwory.size());

        for (int i = 0; i < p.rows; i++) {
            for (int j = 0; j < p.columns; j++) {
                System.out.print(p.twoDimensoionalElementsTab[i][j] + " ");
            }
            System.out.println();
        }

    }
}
