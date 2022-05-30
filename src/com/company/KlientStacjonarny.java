package com.company;

public class KlientStacjonarny extends Klient{

    int nrStolika;

    public KlientStacjonarny(String name, String nazwisko, int nrStolika){
        super(name, nazwisko);
        this.nrStolika = nrStolika;
    }
}
