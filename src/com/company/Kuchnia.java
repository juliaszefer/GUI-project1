package com.company;

import java.util.LinkedList;
import java.util.List;

public class Kuchnia {

    static List<Kucharz> kucharze;
    private static LinkedList<Zamowienie> zamowienia = new LinkedList<>();

    public Kuchnia(List<Kucharz> kucharze){
        Kuchnia.kucharze = kucharze;
        zamowienia = new LinkedList<>();
    }

    public static String getKolejkaZamowien(){
        String res = "";
        for(Zamowienie zamowienie : zamowienia){
            res += "Zamówienie " + zamowienie.numerZamowienia + " dla " + zamowienie.klient.getClass().getSimpleName() + ":\n";
            for(PozycjaMenu pozycjaMenu : zamowienie.pozycje) {
                res += pozycjaMenu.name + ", ";
            }
            res+="\n";
        }
        return res;
    }

    public static void dodajZamowienie(Zamowienie nowe){
        zamowienia.add(nowe);
        zamowienia.sort( (z1, z2) -> {
            if(z1.klient.getClass().getSimpleName().length() <= z2.klient.getClass().getSimpleName().length()){
                return 1;
            }
            return -1;
        });
    }

}
