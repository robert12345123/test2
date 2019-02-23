package com.zachowanie;
import java.util.ArrayList;

public class Oszczędny implements IZachowanieWSklepie {
    public double kupuj(double kwotaDoWydania, ArrayList<Towar> towary) {
        double wydano = 0;
        Towar wybranyTowar = towary.get(0);
        for(Towar towar : towary) {
            if (towar.cena < wybranyTowar.cena)
                wybranyTowar = towar;
        }
        if (wybranyTowar.cena <= kwotaDoWydania) {
            wydano = wybranyTowar.cena;
            System.out.println("Kupiono: " + wybranyTowar.nazwa);
        }
        return wydano;
    }
}