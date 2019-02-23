package com.serializacja;

import com.google.gson.annotations.Expose;

public class Student extends Osoba {
    @Expose
    private int rokStudiów;
    @Expose
    private String kierunekStudiów;
    public Student(String imię, String nazwisko, String dataUrodzenia, int rokStudiów, String kierunekStudiów) {
        super(imię, nazwisko, dataUrodzenia);
        this.kierunekStudiów = kierunekStudiów;
        this.rokStudiów = rokStudiów;
        typ = "Student";
    }
    public Student(String imię, String nazwisko, String dataUrodzenia, Adres adres, int rokStudiów, String kierunekStudiów) {
        super(imię, nazwisko, dataUrodzenia, adres);
        this.kierunekStudiów = kierunekStudiów;
        this.rokStudiów = rokStudiów;
        typ = "Student";
    }
    public Student() {
        super();
        this.kierunekStudiów = kierunekStudiów;
        this.rokStudiów = rokStudiów;
        typ = "Student";
    }
    public String toString() {
        return typ + ": " + this.getImię() + ";" + this.getNazwisko() + ";" + this.getDataUrodzenia() + ";" + this.getKierunekStudiów();
    }

    public int getRokStudiów() {
        return rokStudiów;
    }

    public String getKierunekStudiów() {
        return kierunekStudiów;
    }
}
