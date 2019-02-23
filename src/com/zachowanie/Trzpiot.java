package com.zachowanie;

import java.util.ArrayList;

public class Trzpiot  implements  IZachowanieWSklepie {
    public double kupuj(double kwotaDoWydania, ArrayList<Towar> towary) {
        double wydano = 0;
        int numer = (int)(Math.random()*towary.size());
        if (towary.get(numer).cena >= kwotaDoWydania) {
            wydano += towary.get(numer).cena;
            System.out.println("Kupiono: " + towary.get(numer).nazwa);
        }
        return wydano;
    }
}
