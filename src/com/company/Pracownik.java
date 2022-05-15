package com.company;

import java.util.ArrayList;
import java.util.List;

public abstract class Pracownik {
    static List<Pracownik> pracownicy = new ArrayList<>();
    int id;
    String name;
    String surname;
    String numerTelefonu;
    double pensja;

    public Pracownik(String name, String surname, String numerTelefonu, double pensja){
        this.id = pracownicy.size();
        this.name = name;
        this.surname = surname;
        this.numerTelefonu = numerTelefonu;
        this.pensja = pensja;
        pracownicy.add(this);
    }

    public static void wypiszPracownikow() {
        for (Pracownik pracownik : pracownicy) {
            System.out.println(pracownik.id + ". " + pracownik.name + " " + pracownik.surname + ", numer telefonu: " + pracownik.numerTelefonu + ", pensja: " + pracownik.pensja);
        }
    }
}