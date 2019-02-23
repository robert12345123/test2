package com.zachowanie;

import java.util.ArrayList;

public class Main {
    public static ArrayList<Osoba> listaOsob = new ArrayList<Osoba>();
    public static ArrayList<Towar> towaryWSklepie = new ArrayList<Towar>();
    public static void main(String[] args) {
        // osoby ...
        Towar t1 = new Towar("spodnie Levis", 234.56);
        Towar t2 = new Towar("telefon Galaxy S99", 1134.56);
        Towar t3 = new Towar("sok jabłko-mięta", 2.5);
        Towar t4 = new Towar("gramofon", 250.9);
        Towar t5 = new Towar("stół", 550.9);
        towaryWSklepie.add(t1);
        towaryWSklepie.add(t2);
        towaryWSklepie.add(t3);
        towaryWSklepie.add(t4);
        towaryWSklepie.add(t5);
        Osoba osoba1 = new Osoba("Jan", "Kowalski", "1980-11-02", new Adres("Poznań", "ul. Szklista 12", "60-111"));
        Osoba osoba2 = new Osoba("Anna", "Zamojska", "1988-03-02");
        Osoba osoba3 = new Osoba("Janina", "Kot", "1988-04-02");
        Osoba osoba4 = new Osoba("Antoni", "Robak", "1995-12-02");
        osoba1.setPieniądze(1200);
        osoba2.setPieniądze(1900);
        osoba3.setPieniądze(3500);
        osoba4.setPieniądze(10);
        osoba1.setZachowanie(new Trzpiot());
        osoba2.setZachowanie(new Snob());
        osoba3.setZachowanie(new Rozrzutny());
        listaOsob.add(osoba1);
        listaOsob.add(osoba2);
        listaOsob.add(osoba3);
        listaOsob.add(osoba4);
        System.out.println("Symulacja zachowania w sklepie:");
        for(Osoba osoba : listaOsob) {
            double wydano = osoba.kupuj(osoba.getPieniądze(), towaryWSklepie);
            osoba.zapłać(wydano);
        }
        System.out.println(osoba1.getImię());
        boolean czyUdałoSię = osoba1.setNazwisko("Mickiewcz!");
        if (!czyUdałoSię)
            System.out.println("Nie udało się zmienić nazwiska");
        for(Osoba osX : listaOsob)
            System.out.println(osX.toString());
        for(int i = 0; i < listaOsob.size(); i++)
            System.out.println(listaOsob.get(i).toString());
    }
}
