package com.kolekcja;

import java.util.ArrayList;

public class Snob implements IZachowanieWSklepie {
    public double kupuj(double kwotaDoWydania, Sklep sklep) {
        double wydano = 0;
        ArrayList<Towar> listaTowarów =  sklep.getTowary();
        System.out.print("(snobistycznie): ");
        Towar wybranyTowar = listaTowarów.get(0);
        for(Towar towar : listaTowarów) {
            if (towar.cena > wybranyTowar.cena) {
                wybranyTowar = towar;
            }
        }
        if (wybranyTowar.cena <= kwotaDoWydania) {
            wydano =  wybranyTowar.cena;
            System.out.print(wybranyTowar.nazwa + " ");
        }
        if (wydano > 0)
            sklep.dodajDoUtargu(wydano);
        else
            System.out.print("brak zakupu");
        return wydano;
    }
}
