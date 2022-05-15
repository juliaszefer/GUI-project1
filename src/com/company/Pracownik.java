package com.company;

public abstract class Pracownik {
    int id;
    String name;
    String surname;
    String numerTelefonu;
    double pensja;

    public Pracownik(int id, String name, String surname, String numerTelefonu, double pensja){
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.numerTelefonu = numerTelefonu;
        this.pensja = pensja;
    }

}