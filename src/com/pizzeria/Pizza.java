package com.pizzeria;

public class Pizza {
    private String nazwaPizzy;
    private Rozmiar rozmiarPizzy;
    public Pizza(String nazwa, Rozmiar rozmiar) {
        this.nazwaPizzy = nazwa;
        this.rozmiarPizzy = rozmiar;
    }

    public Rozmiar getRozmiarPizzy() {
        return rozmiarPizzy;
    }
    public int getSrednicaPizzy() {
        return rozmiarPizzy.getSize();
    }
}
