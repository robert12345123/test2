package com.sklep;
import com.google.gson.Gson;
import com.kolekcja.Towar;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Klasa SuperSklep sluzy do tworzenia sklepu na potrzeby programu obslugujacego osoby
 * @author Dariusz Ceglarek
 * @version 1.0
 * @since 2019-02-02
 */
public class SuperSklep {
    private String nazwa;
    private double utarg;
    private List<Towar> towaryWSklepie;

    /**
     * Konstruktor bezparaetrowy nadajacy nazwe sklepowi
     */
    public SuperSklep() {
        nazwa = "supersklep";
        utarg = 0;
        towaryWSklepie = new ArrayList<>();
    }

    /**
     * Konstruktor umozliwiajacy nadawanie nazwy sklepowi
     * @param nazwa nazwa sklepu
     */
    public SuperSklep(String nazwa) {
        this.nazwa = nazwa;
        utarg = 0;
        towaryWSklepie = new ArrayList<>();
    }
    public double dodajUtarg(double kwota) {
        utarg += kwota;
        return utarg;
    }

    /**
     * Metoda pobiera nazwe sklepu @link Supersklep#utarg
     * @return nazwa sklepu
     */
    public String getNazwaSklepu() {
        return nazwa;
    }
    public void załadujTowary() {
        Towar t1 = new Towar("buty zamszowe 42", 156.78);
        Towar t2 = new Towar("buty robocze 40", 77.00);
        towaryWSklepie.add(t1);
        towaryWSklepie.add(t2);
    }
    public List<Towar> getListaTowarow() {
        List<Towar> nowa = new ArrayList<>();
        for(Towar towar: towaryWSklepie) {
            Towar nowy = new Towar(towar.nazwa, towar.cena);
            nowa.add(nowy);
        }
        return nowa;
    }
    public void wczytajTowary() {
        towaryWSklepie = new ArrayList<>();
        String plik = nazwa + ".txt";
        System.out.println("Czytam towary z pliku: <<" + plik + "<<");
        boolean koniec = false;
        do {
            File file = new File(plik);
            if (!file.exists())
                System.out.println("Nie ma pliku: " + plik);
            try {
                Scanner skan = new Scanner(file);
                while (skan.hasNextLine()) {
                    String linia = skan.nextLine();
                    if (!linia.contains(";"))
                        continue;
                    String[] wyrazy = linia.split(";");
                    double cena = Double.parseDouble(wyrazy[1]);
                    Towar nowy = new Towar(wyrazy[0], cena);
                    towaryWSklepie.add(nowy);
                }
                skan.close();
                koniec = true;
            } catch (FileNotFoundException ex) {
                System.out.println(ex.getMessage());
                System.out.print("Podaj nazwę pliku: ");
                Scanner zkonsoli = new Scanner(System.in);
                plik = zkonsoli.nextLine();
                zkonsoli.close();
                if (plik.equals("koniec"))
                    koniec = true;
                continue;
            } catch (Exception exc) {
                System.out.println("Błąd czytania: " + exc.getMessage());
            }
        } while (!koniec);
    }
    public void wyświetlTowaryWSklepie() {
        for(Towar towar : towaryWSklepie)
            System.out.println("W sklepie: " + towar.toString());
    }
    public void zapiszTowaryJSON() {
        Gson gson = new Gson();
        String efekt = gson.toJson(towaryWSklepie);
        File file = new File(nazwa + ".json");
        try {
            PrintStream fp = new PrintStream(file);
            fp.println(efekt);
            fp.close();
        } catch (FileNotFoundException fe) {
            System.out.println(fe.getMessage());
        }
    }
}
