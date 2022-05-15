package com.company;

import java.util.List;

public class Kelner extends Pracownik{
    public Kelner(int id, String name, String surname, String numerTelefonu, double pensja) {
        super(id, name, surname, numerTelefonu, pensja);
    }

    public void dodajKelnera(Kelner kelner, List<Pracownik> pracownicy){
        pracownicy.add(kelner);
    }
}
