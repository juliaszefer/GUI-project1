package com.company;

import java.util.List;

public class Dostawca extends Pracownik{

    private int czasDostawy = 120;
    public Dostawca(String name, String surname, String numerTelefonu, double pensja) {
        super(name, surname, numerTelefonu, pensja);
        Main.dostawcy.add(this);
    }

}
