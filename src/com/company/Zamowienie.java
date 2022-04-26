package com.company;
import java.util.ArrayList;
import java.util.List;

public class Zamowienie {
    Klient klient;

    public Zamowienie(Klient klient){
        this.klient = klient;
    }

    List<PozycjaMenu> pozycje = new ArrayList<>();

    public void zlozZamowienie(PozycjaMenu pozycja){
        pozycje.add(pozycja);
    }
}
