package com.company;

import java.util.List;

public class Kucharz extends Pracownik{
    public Kucharz(int id, String name, String surname, String numerTelefonu, double pensja) {
        super(id, name, surname, numerTelefonu, pensja);
    }

    public void dodajKucharza(Kucharz kucharz, List<Pracownik> pracownicy){
        pracownicy.add(kucharz);
    }
}
