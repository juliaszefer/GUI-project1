package com.company;

public abstract class Klient {
    String imie;
    String nazwisko;

    public Klient(String name, String nazwisko) {
        this.imie = name;
        this.nazwisko = nazwisko;
    }
}
