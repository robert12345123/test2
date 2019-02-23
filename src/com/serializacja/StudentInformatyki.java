package com.serializacja;
import com.google.gson.annotations.Expose;

public class StudentInformatyki extends Student {
    @Expose
    private PoziomUmiejętnościProgramowania poziom;
    public StudentInformatyki(String imię, String nazwisko, String dataUrodzenia, int rokStudiów, String kierunekStudiów, PoziomUmiejętnościProgramowania poziom) {
        super(imię, nazwisko, dataUrodzenia, rokStudiów, kierunekStudiów);
        this.poziom = poziom;
        typ = "StudentInformatyki";
    }
    public StudentInformatyki(String imię, String nazwisko, String dataUrodzenia, Adres adres, int rokStudiów, String kierunekStudiów, PoziomUmiejętnościProgramowania poziom) {
        super(imię, nazwisko, dataUrodzenia, adres, rokStudiów, kierunekStudiów);
        this.poziom = poziom;
        typ = "StudentInformatyki";
    }

    @Override
    public String toString() {
        return super.toString() + "; poziom programowania: " + poziom;
    }
}
