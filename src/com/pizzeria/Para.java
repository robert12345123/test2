package com.pizzeria;

public class Para<T1,T2> {
    T1 pierwszy;
    T2 drugi;
    public Para(T1 p, T2 d) {
        pierwszy = p;
        drugi = d;
    }
    public Para get() {
        Para nowa = new Para(this.pierwszy, this.drugi);
        return nowa;
    }
}
