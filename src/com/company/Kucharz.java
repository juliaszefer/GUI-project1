package com.company;

import java.util.List;

public class Kucharz extends Pracownik{
    public Kucharz(String name, String surname, String numerTelefonu, double pensja) {
        super(name, surname, numerTelefonu, pensja);
        Main.kucharze.add(this);
    }

}
