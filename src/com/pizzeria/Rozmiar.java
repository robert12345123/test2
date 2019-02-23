package com.pizzeria;

public enum Rozmiar {
    S(30),M(40),L(50);
    int size;
    Rozmiar(int size) {
        this.size = size;
    }
    int getSize() {
        return size;
    }
}
