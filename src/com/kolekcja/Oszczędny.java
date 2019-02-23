package com.kolekcja;
import java.util.ArrayList;

public class Oszczędny implements IZachowanieWSklepie {
        public double kupuj(double kwotaDoWydania, Sklep sklep) {
            ArrayList<Towar> listaTowarów =  sklep.getTowary();
            double wydano = 0;
            Towar wybranyTowar = listaTowarów.get(0);
            System.out.print("(oszczędnie): ");
            for(Towar towar : listaTowarów) {
                if (towar.cena < wybranyTowar.cena)
                    wybranyTowar = towar;
            }
            if (wybranyTowar.cena <= kwotaDoWydania) {
                wydano = wybranyTowar.cena;
                System.out.print(wybranyTowar.nazwa + " ");
            }
            if (wydano > 0)
                sklep.dodajDoUtargu(wydano);
            else
                System.out.print("brak zakupu");
            return wydano;
        }
    }
