package com.serializacja;
import com.sklep.*;
import java.util.ArrayList;

/**
 * @author Dariusz Ceglarek
 * @version 1.0
 * @since 2019-01-28
 */
public class Main {
    public static ArrayList<Towar> towaryWSklepie = new ArrayList<Towar>();
    public static void main(String[] args) {
        SuperSklep sklepX = new SuperSklep("Żabka na rogu");
        sklepX.wczytajTowary();
        sklepX.wyświetlTowaryWSklepie();
        double ileWydano = sklepX.dodajUtarg(300);
        System.out.println("W sklepie " + sklepX.getNazwaSklepu() +  " utarg = " + ileWydano);
        //
	// kolekcja osób
        KolekcjaOsob kolekcjaOsób = new KolekcjaOsob();
        kolekcjaOsób.załaduj();
        kolekcjaOsób.zapiszXML();
        System.out.println("Wczytanie JSON");
        //Zapisanie kolekcji w JSON
        kolekcjaOsób.zapiszJSON();
        //Wczytanie kolekcji z JSON
        kolekcjaOsób.wczytajJSON();
        Sklep sklepWielobranżowy = new Sklep("Biedronka++");
        Sklep sklepArmani = new Sklep("Armani");
        sklepArmani.wyświetlTowaryWSklepie();
        sklepArmani.zapiszTowaryJSON();
        /**
         * dodanie nowego towaru do listy towarów w sklepie
         */
        Towar bluzka = new Towar("bluzka jedwabna w grochy", 345.12);
        sklepArmani.dodajTowar(bluzka);
        /**
         * wyświetlenie listy towarów w sklepie
         */
        sklepWielobranżowy.wyświetlTowaryWSklepie();
        // wpuszczamy kolekcję osób do sklepu Biedronka++
        kolekcjaOsób.symulujZachowanieWSklepie(sklepWielobranżowy);
        double kwota = sklepWielobranżowy.getUtarg();
        System.out.println("W sklepie " + sklepWielobranżowy.getNazwaSklepu() + " utarg = " + String.format("%.2f", kwota));
        //a teraz robią zakupy w sklepie Armani
        kolekcjaOsób.symulujZachowanieWSklepie(sklepArmani);
        /**
         * obliczenie i wyświetlenie utargu w sklepie
         */
        kwota = sklepArmani.getUtarg();
        System.out.println("W sklepie " + sklepArmani.getNazwaSklepu() + " utarg = " + String.format("%.2f", kwota));
        sklepArmani.zapisz();
    }
}
