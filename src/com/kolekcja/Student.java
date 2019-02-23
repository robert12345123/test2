package com.kolekcja;

public final class Student extends Osoba {
    private int rokStudiów;
    private String kierunekStudiów;
    public Student(String imię, String nazwisko, String dataUrodzenia, int rokStudiów, String kierunekStudiów) {
        super(imię, nazwisko, dataUrodzenia);
        this.kierunekStudiów = kierunekStudiów;
        this.rokStudiów = rokStudiów;
    }
    public Student(String imię, String nazwisko, String dataUrodzenia, Adres adres, int rokStudiów, String kierunekStudiów) {
        super(imię, nazwisko, dataUrodzenia, adres);
        this.kierunekStudiów = kierunekStudiów;
        this.rokStudiów = rokStudiów;
    }
    public String toString() {
        return this.getImię() + ";" + this.getNazwisko() + ";" + this.getDataUrodzenia() + ";" + this.getKierunekStudiów();
    }

    public int getRokStudiów() {
        return rokStudiów;
    }

    public String getKierunekStudiów() {
        return kierunekStudiów;
    }
}
