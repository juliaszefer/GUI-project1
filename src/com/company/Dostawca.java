package com.company;

import java.util.List;

public class Dostawca extends Pracownik{
    public Dostawca(int id, String name, String surname, String numerTelefonu, double pensja) {
        super(id, name, surname, numerTelefonu, pensja);
    }

    public void dodajDostawce(Dostawca dostawca, List<Pracownik> pracownicy){
        pracownicy.add(dostawca);
    }
}
