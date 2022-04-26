package com.company;

public class KlientOnline extends Klient{

    boolean czyDostawa;
    String adres;

    public KlientOnline(String imie, String nazwisko, boolean czyDostawa, String adres){
        super(imie, nazwisko);
        this.czyDostawa = czyDostawa;
        this.adres = adres;
    }
}
