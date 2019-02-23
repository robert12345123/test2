package com.kolekcja;

import java.util.ArrayList;

public class Rozrzutny implements IZachowanieWSklepie {
    public double kupuj(double kwotaDoWydania, Sklep sklep) {
        ArrayList<Towar> listaTowarów =  sklep.getTowary();
        double wydano = 0;
        System.out.print("(rozrzutnie): ");
        int nr = 0;
        for(Towar towar : listaTowarów) {
            if (towar.cena <= kwotaDoWydania) {
                wydano += towar.cena;
                kwotaDoWydania -= towar.cena;
                if (nr++ == 0)
                  System.out.print(towar.nazwa);
                else
                  System.out.print(", " + towar.nazwa);
            }
        }
        System.out.println();
        if (wydano > 0)
            sklep.dodajDoUtargu(wydano);
        else
            System.out.print("brak zakupu");
        return wydano;
    }
}
