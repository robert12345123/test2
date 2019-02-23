package com.treeset;

import com.kolekcja.Adres;
import com.kolekcja.Osoba;
import com.kolekcja.Student;

import java.util.ArrayList;
import java.util.TreeSet;

public class Main {
    public static void main(String[] args) {
        ArrayList<Osoba> listaOsób = new ArrayList<Osoba>();
        Osoba osoba1 = new Osoba("Jan", "Kowalski", "1980-11-02", new Adres("Poznań", "ul. Szklista 12", "60-111"));
        Osoba osoba2 = new Osoba("Anna", "Zamojska", "1988-03-02");
        Osoba osoba3 = new Osoba("Janina", "Kot", "1986-04-02");
        Osoba osoba3a = new Osoba("Zenon", "Kot", "1980-07-09");
        Osoba osoba4 = new Osoba("Antoni", "Robak", "1997-12-02");
        Osoba osoba5 = new Osoba("Weronika", "Kocińska", "2001-07-14");
        Osoba osoba6 = new Osoba("Zenon", "Abacki", "1978-02-23");
        Student student1 = new Student("Wanda", "Nowicka", "1999-08-11", 2, "socjologia");
        listaOsób.add(osoba1);
        listaOsób.add(osoba2);
        listaOsób.add(osoba3);
        listaOsób.add(osoba3a);
        listaOsób.add(osoba4);
        listaOsób.add(osoba5);
        listaOsób.add(osoba6);
        listaOsób.add(student1);
        TreeSet<Osoba> treeset = new TreeSet<>(new NazwiskoComparator());
        treeset.addAll(listaOsób);
        for(Osoba o : treeset)
            System.out.println(o.toString());
    }
}
