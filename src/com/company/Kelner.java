package com.company;

import java.util.ArrayList;
import java.util.List;

public class Kelner extends Pracownik{
    public Kelner(String name, String surname, String numerTelefonu, double pensja) {
        super(name, surname, numerTelefonu, pensja);
        czyWolny = true;
        Main.kelnerzy.add(this);
    }

    static ArrayList<Zamowienie> zamowieniaDoDostarczenia = new ArrayList<>();
    static ArrayList<Kelner> kelnerzy = new ArrayList<>();

    private int czasDostawy = 12000;
    boolean czyWolny;

    public void dostarczZamowienie(Zamowienie zamowienie){
        System.out.println("Dostarczam zamówienie do stolika");
        try {
            Thread.sleep(czasDostawy);
            System.out.println("Zamówienie zostało dostarczone");
            zamowienie.czyDostarczono = true;
            zamowieniaDoDostarczenia.remove(zamowienie);
        }catch (Exception e){
            System.out.println("Dostarczanie zamówienia zostało przerwane");
        }

    }

}
