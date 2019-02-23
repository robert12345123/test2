package com.zachowanie;

import java.util.ArrayList;

public class Rozrzutny implements IZachowanieWSklepie {
    public double kupuj(double kwotaDoWydania, ArrayList<Towar> towary) {
        double wydano = 0;
        System.out.print("Rozrzutny kupuje: ");
        for(Towar towar : towary) {
            if (towar.cena <= kwotaDoWydania) {
                wydano += towar.cena;
                kwotaDoWydania -= towar.cena;
                System.out.print(towar.nazwa + " ");
            }
        }
        System.out.println();
        return wydano;
    }
}
