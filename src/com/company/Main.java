package com.company;

public class Main {

    public static void main(String[] args) {
//       datareader = new DataReader().DataReaderGosci("listaGosci");
        DataReader dataReader = new DataReader();
//        dataReader.DataReaderGoscie("listaGosci");
        dataReader.DataReaderUtworow("listaUtworow");
        dataReader.Execute();

    }
}
