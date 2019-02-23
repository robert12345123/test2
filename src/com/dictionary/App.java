package com.dictionary;

import java.io.*;
import java.util.*;

public class App {
    public static void main(String[] args) {
        HashMap<String, List<String>> słownik = new HashMap<>();
        List<String> znaczenia = new ArrayList<String>();
        słownik = wczytajSłownik();
        for (Map.Entry<String, List<String>> wpis : słownik.entrySet()) {
            System.out.print("Słowo: " + wpis.getKey() + ": ");
            for (String ang : wpis.getValue())
                System.out.print(ang + ", ");
            System.out.println();
        }
        System.out.println("Słownik ma " + słownik.size() + " słów");
        // testowanie słownika
        List<String> wyrazyPolskie = słownik.get("arbeitszeit");
        for (String wyraz : wyrazyPolskie)
            System.out.println(wyraz);
        System.out.println("\n=====Odwrócenie słownika =====");
        TreeMap<String, List<String>> nowy = odwróćSłownik(słownik);
        for (Map.Entry<String, List<String>> wpis : nowy.entrySet()) {
            System.out.print("Słowo: " + wpis.getKey() + ": ");
            for (String ang : wpis.getValue())
                System.out.print(ang + ", ");
            System.out.println();
        }
    }

    /**
     * Odwrócenie słownika (np. z niemiecko-polskiego zamienia na polsko-niemiecki)
     *
     * @return
     */
    private static HashMap<String, List<String>> wczytajSłownik() {
        HashMap<String, List<String>> słownik = new HashMap<String, List<String>>();
        String plik = "niempol.txt";
        File file = new File(plik);
        try {
            file = new File(plik).getAbsoluteFile();
            FileReader fr = new FileReader(plik);
            BufferedReader inh = new BufferedReader(fr);
            String linia;
            try {
                while ((linia = inh.readLine()) != null) {
                    String[] wyrazy = linia.split(";");
                    List<String> lista = new ArrayList<String>();
                    if (wyrazy.length == 1) continue;
                    if (wyrazy[1].contains(",")) {
                        String[] znaczenia = wyrazy[1].split(",");
                        for (String wyraz : znaczenia)
                            lista.add(wyraz);
                    } else
                        lista.add(wyrazy[1]);
                    słownik.put(wyrazy[0], lista);
                }
                inh.close();
            } catch (IOException ios) {
                System.out.println(ios.getMessage());
            }
            return słownik;
        } catch (FileNotFoundException ex) {
            System.out.println("Nie ma pliku");
            return słownik;
        }
    }
    public static TreeMap<String, List<String>> odwróćSłownik(HashMap<String, List<String>> słownik) {
        TreeMap<String, List<String>> nowy = new TreeMap<>();
        for (Map.Entry<String, List<String>> wpis : słownik.entrySet()) {
            String słowo = wpis.getKey();
            for (String ang : wpis.getValue())
                if (nowy.containsKey(ang)) {
                    List<String> lista = nowy.get(ang);
                    lista.add(słowo);
                    nowy.put(ang, lista);
                } else {
                    List<String> lista = new ArrayList<String>();
                    lista.add(słowo);
                    nowy.put(ang, lista);
                }
        }
        return nowy;
    }
}