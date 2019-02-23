package com.serializacja;

public enum PoziomUmiejętnościProgramowania {
    Żaden(0), Słaby(20), Umiarkowany(40), Dobry(70), Doskonały(100);
    PoziomUmiejętnościProgramowania() {}
    PoziomUmiejętnościProgramowania(int poziom) {
        this.poziom = poziom;
    }
    int poziom;
    int getPoziom() {
        return poziom;
    }
}
