package com.company;

import java.util.ArrayList;
import java.util.List;

public class Kuchnia {

    List<Kucharz> kucharze;
    ArrayList<Zamowienie> zamowienia;

    public Kuchnia(List<Kucharz> kucharze){
        this.kucharze = kucharze;
        zamowienia = new ArrayList<>();
    }



    public void dodajZamowienie(Zamowienie nowe){
        zamowienia.add(nowe);
        // TODO: sortowanie
    }

}
