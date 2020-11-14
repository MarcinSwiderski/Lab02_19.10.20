package com.company;

public class Main {

    public static void main(String[] args) {
        DataReader dataReader = new DataReader();
        dataReader.dataReaderGosci("listaGosci");
        dataReader.dataReaderUtworow("listaUtworow");
        dataReader.Execute();

    }
}
