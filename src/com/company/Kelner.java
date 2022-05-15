package com.company;

import java.util.List;

public class Kelner extends Pracownik{
    public Kelner(String name, String surname, String numerTelefonu, double pensja) {
        super(name, surname, numerTelefonu, pensja);
        Main.kelnerzy.add(this);
    }

}
