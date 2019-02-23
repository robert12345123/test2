package com.zachowanie;

import java.time.LocalDate;
import java.util.ArrayList;

public class Osoba implements IZachowanieWSklepie {
    private double pieniądze;
    IZachowanieWSklepie zachowanie = new Oszczędny();
    public double kupuj(double kwota, ArrayList<Towar> towary) {
        System.out.println(this.getImię() + " kupuje");
        double wydano = zachowanie.kupuj(kwota, towary);
        return wydano;
    }
    public void zapłać(double kwota) {
        this.pieniądze -= kwota;
    }
    public void setZachowanie(IZachowanieWSklepie iZachowanieWSklepie) {
        this.zachowanie = iZachowanieWSklepie;
    }
    private String imię;
    private String nazwisko;
    private LocalDate dataUrodzenia;
    private Adres adres;
    public Osoba() {
        setImię("");
        nazwisko ="";
        dataUrodzenia = LocalDate.now();
    }
    public Osoba(String imię, String nazwisko, String data) {
        this.setImię(imię);
        this.nazwisko = nazwisko;
        this.dataUrodzenia = LocalDate.parse(data);
        this.adres = new Adres();
        pieniądze = 0;
    }
    public Osoba(String imię, String nazwisko, String data,Adres adres) {
        this(imię, nazwisko, data);
        this.adres = adres;
        pieniądze = 0;
    }
    public Osoba(String imię, String nazwisko, String data,Adres adres, double kwota) {
        this(imię, nazwisko, data, adres);
        this.setPieniądze(kwota);

    }
@Override
    public String toString() {
        return getImię() + "." + nazwisko + " data ur.: " + getDataUrodzenia().toString() + " " + adres.toString();
  }
  public String getImię() {
        return imię;
  }
  public boolean setNazwisko(String noweNazwisko) {
        if (noweNazwisko.length() < 3 || noweNazwisko.length() > 50)
            return false;
        String[] znaki = new String[] {"0", "1", "2", "3", "4", "@", "!"};
        for (String znak : znaki)
        if (noweNazwisko.contains(znak))
            return false;
        this.nazwisko = noweNazwisko;
        return true;
  }

    public void setImię(String imię) {
        this.imię = imię;
    }

    public LocalDate getDataUrodzenia() {
        return dataUrodzenia;
    }
    public String showAdres() {
        return adres.toString();
    }
    private Adres getAdres() {
        return adres;
    }

    public double getPieniądze() {
        return pieniądze;
    }

    public void setPieniądze(double pieniądze) {
        this.pieniądze = pieniądze;
    }
}
