package com.serializacja;

import org.simpleframework.xml.Root;

import java.util.ArrayList;
@Root(name = "Rozrzutny")
public class Rozrzutny implements IZachowanieWSklepie {
    public Rozrzutny() {}
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
