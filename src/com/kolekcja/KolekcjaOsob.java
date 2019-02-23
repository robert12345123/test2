package com.kolekcja;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class KolekcjaOsob {
    private List<Osoba> listaOsób;
    public KolekcjaOsob() {
        listaOsób = new ArrayList<Osoba>();
    }
    public void załaduj() {
        Osoba osoba1 = new Osoba("Jan", "Kowalski", "1980-11-02", new Adres("Poznań", "ul. Szklista 12", "60-111"));
        Osoba osoba2 = new Osoba("Anna", "Zamojska", "1988-03-02");
        Osoba osoba3 = new Osoba("Janina", "Kot", "1986-04-02");
        Osoba osoba4 = new Osoba("Antoni", "Robak", "1997-12-02");
        Osoba osoba5 = new Osoba("Weronika", "Kocińska", "2001-07-14");
        Osoba osoba6 = new Osoba("Zenon", "Abacki", "1978-02-23");
        Student student1 = new Student("Wanda", "Nowicka", "1999-08-11", 2, "socjologia");
        osoba1.setPieniądze(2200);
        osoba2.setPieniądze(1900);
        osoba3.setPieniądze(3500);
        osoba4.setPieniądze(10);
        osoba5.setPieniądze(2300);
        osoba6.setPieniądze(950);
        osoba1.setZachowanie(new Trzpiot());
        osoba2.setZachowanie(new Snob());
        osoba3.setZachowanie(new Rozrzutny());
        osoba5.setZachowanie(new Snob());
        osoba6.setZachowanie(new Oszczędny());
        listaOsób.add(osoba1);
        listaOsób.add(osoba2);
        listaOsób.add(osoba3);
        listaOsób.add(osoba4);
        listaOsób.add(osoba5);
        listaOsób.add(osoba6);
        listaOsób.add(student1);
        Collections.sort(listaOsób);
        for(Osoba os : listaOsób) {
            System.out.println(os.toString());
            if (os instanceof  Student) {
                Student studen = (Student) os;
                studen.getKierunekStudiów();
            }
        }
    }
    public void symulujZachowanieWSklepie(Sklep sklep) {
        System.out.println("=== Symulacja zachowania w sklepie: " + sklep.getNazwaSklepu() + " ===");
        for(Osoba osoba : listaOsób) {
            double wydano = osoba.kupuj(osoba.getPieniądze(), sklep);
            osoba.zapłać(wydano);
        }
    }
}
