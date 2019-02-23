package com.serializacja;

public class Pracownik extends Osoba{
    private double pensja;
    public Pracownik() {
        super();
        this.typ = "Pracownik";
    }
    public Pracownik(String imię, String nazwisko, String data,Adres adres, double kwota, double pensja) {
        super(imię, nazwisko, data, adres, kwota);
        this.pensja = pensja;
        this.typ = "Pracownik";
    }
    @Override
    public String toString() {
        if (this.getAdres() != null)
            return typ + ": " + getImię() + ";" + getNazwisko() + ";" + getDataUrodzenia().toString() + ";" + getAdres().toString() + ";" + pensja + ";";
        else
            return getImię() + ";" + getNazwisko() + ";" + getDataUrodzenia().toString() + " , " + pensja;
    }
}
