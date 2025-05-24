package com.comarch.szkolenia.car.rent;

import java.io.*;

public class Pliki {
    public static void main(String[] args) {
        /*try {
            // Tworzymy obiekt BufferedWriter, który będzie używać FileWriter
            BufferedWriter writer = new BufferedWriter(new FileWriter("plik.txt", true));

            writer.newLine();
            // Zapisujemy tekst do pliku
            writer.write("cos innego");

            // Zamykanie BufferedWriter po zapisaniu
            writer.close();
            System.out.println("Dane zapisane do pliku.");
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Nie dziala plik !!");
        }*/

        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader("plik2.txt"));

            String line;
            while ((line = bufferedReader.readLine()) != null) {
                System.out.println(line);
            }

            bufferedReader.close();
        } catch (IOException e) {
            System.out.println("Nie dziala plik !!");
        }
    }
}
