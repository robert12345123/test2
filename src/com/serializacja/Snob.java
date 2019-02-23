package com.serializacja;

import org.simpleframework.xml.Root;

import java.util.ArrayList;
@Root(name = "Snob")
public class Snob implements IZachowanieWSklepie {
    public Snob() {}
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
