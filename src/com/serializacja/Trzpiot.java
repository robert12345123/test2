package com.serializacja;

import org.simpleframework.xml.Root;

import java.util.ArrayList;
@Root(name = "Oszczedny")
public class Trzpiot  implements  IZachowanieWSklepie {
    public Trzpiot() {}
    public double kupuj(double kwotaDoWydania, Sklep sklep) {
        ArrayList<Towar> listaTowarów =  sklep.getTowary();
        System.out.print("(bylejak): ");
        double wydano = 0;
        int numer = (int)(Math.random()*listaTowarów.size());
        if (listaTowarów.get(numer).cena >= kwotaDoWydania) {
            wydano += listaTowarów.get(numer).cena;
            System.out.print(listaTowarów.get(numer).nazwa + " ");
        }
        if (wydano > 0)
            sklep.dodajDoUtargu(wydano);
        else
            System.out.print("brak zakupu");
        return wydano;
    }
}
