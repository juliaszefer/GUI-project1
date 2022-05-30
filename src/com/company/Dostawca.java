package com.company;

import java.util.ArrayList;
import java.util.List;

public class Dostawca extends Pracownik{

    static ArrayList<Zamowienie> zamowieniaDoDostarczenia = new ArrayList<>();
    static List<Dostawca> dostawcy = new ArrayList<>();

    private int czasDostawy = 1200;
    boolean czyWolny;
    //TODO: zwieksz do 120000
    public Dostawca(String name, String surname, String numerTelefonu, double pensja) {
        super(name, surname, numerTelefonu, pensja);
        czyWolny = true;
        Main.dostawcy.add(this);
    }

    public void dostarczZamowienie(Zamowienie zamowienie){
        System.out.println("Dostarczam zamówienie");
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
