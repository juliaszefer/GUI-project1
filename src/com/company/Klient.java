package com.company;

public abstract class Klient {
    static int no = 1;
    int id;
    String imie;
    String nazwisko;

    public Klient(String name, String nazwisko) {
        id = no++;
        this.imie = name;
        this.nazwisko = nazwisko;
    }
}
