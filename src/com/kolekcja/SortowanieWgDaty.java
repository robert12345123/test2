package com.kolekcja;

import java.util.Comparator;

public class SortowanieWgDaty implements Comparator<Osoba>{
    public int compare(Osoba o1, Osoba o2) {
        return o1.getDataUrodzenia().compareTo(o2.getDataUrodzenia());
    }
}
