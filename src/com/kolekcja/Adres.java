package com.kolekcja;

public class Adres {
    private String miasto;
    private String ulica;
    private String kodPocztowy;
    public Adres() {
        miasto = "";
        ulica = "";
        kodPocztowy = "";
    }
    public Adres(String miasto, String ulica, String kod) {
        this.miasto = miasto;
        this.ulica = ulica;
        this.kodPocztowy = kod;
    }
    @Override
    public String toString() {
        return miasto + " " + ulica + " " + kodPocztowy;
    }
}