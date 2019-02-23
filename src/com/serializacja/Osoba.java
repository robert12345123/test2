package com.serializacja;

import com.google.gson.annotations.Expose;

import java.time.LocalDate;
import java.time.Period;

/**
 * Podstawowa klasa w projekcie
 */
public class Osoba implements IZachowanieWSklepie, Comparable<Osoba> {
    @Expose
    private double pieniądze;
    @Expose
    protected String typ = "Osoba";
    /**
     * Pole typu interfejsu IZachowanieWSklepie
     */
    IZachowanieWSklepie zachowanie = new Oszczędny();
    public double kupuj(double kwota, Sklep sklep) {
        System.out.print(this.getImię() + " kupuje ");
        double wydano = zachowanie.kupuj(kwota, sklep);
        System.out.println();
        if (zachowanie instanceof Rozrzutny) {
            System.out.println("Zmiana zachowania dla: " + this.getImię());
            zachowanie = new Oszczędny();
        }
        return wydano;
    }

    /**
     * Metoda 'zapłać' odejmuje określoną kwotę od pieniędzy posiadanych przez Osobę
     * @param kwota jest kwotą którą dana Osoba wydała w sklepie i którą należy odjąć od posiadanych przez nią pieniędzy
     */
    public void zapłać(double kwota) {
        this.pieniądze -= kwota;
    }
    public void setZachowanie(IZachowanieWSklepie iZachowanieWSklepie) {
        this.zachowanie = iZachowanieWSklepie;
    }
    @Expose
    private String imię;
    @Expose
    private String nazwisko;
    @Expose
    private LocalDate dataUrodzenia;
    @Expose
    private Adres adres;
    public Osoba() {
        setImię("");
        setNazwisko("");
        dataUrodzenia = LocalDate.now();
        typ = "Osoba";
    }
    public Osoba(String imię, String nazwisko, String data) {
        this.setImię(imię);
        this.setNazwisko(nazwisko);
        this.dataUrodzenia = LocalDate.parse(data);
        this.adres = new Adres();
        pieniądze = 0;
        typ = "Osoba";
    }
    public Osoba(String imię, String nazwisko, String data,Adres adres) {
        this(imię, nazwisko, data);
        this.adres = adres;
        pieniądze = 0;
        typ = "Osoba";
    }
    public Osoba(String imię, String nazwisko, String data,Adres adres, double kwota) {
        this(imię, nazwisko, data, adres);
        this.setPieniądze(kwota);
        typ = "Osoba";

    }
@Override
    public String toString() {
        if (this.getAdres() != null)
          return typ + ": " + getImię() + ";" + getNazwisko() + ";" + getDataUrodzenia().toString() + ";" + getAdres().toString()+ ";" + pieniądze + ";";
        else
            return getImię() + ";" + getNazwisko() + ";" + getDataUrodzenia().toString();
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

    /**
     * Podaje wiek osoby w latach
     * @return wiek w latach
     */
    public int getWiek() {
        Period per = Period.between(this.dataUrodzenia, LocalDate.now());
        return per.getYears();
    }
    public String showAdres() {
        return getAdres().toString();
    }
    public Adres getAdres() {
        return adres;
    }

    public double getPieniądze() {
        return pieniądze;
    }

    public void setPieniądze(double pieniądze) {
        this.pieniądze = pieniądze;
    }
    @Override
    public int compareTo( final Osoba os) {
        //return Integer.compare((int)this.pieniądze, (int)os.getPieniądze());
        LocalDate teraz = LocalDate.now();
        Period dur1 = Period.between(this.dataUrodzenia, teraz);
        Period dur2 = Period.between(os.dataUrodzenia, teraz);
        return Integer.compare((int) dur1.getDays(), (int)dur2.getDays());
    }

    public String getNazwisko() {
        return nazwisko;
    }
}
