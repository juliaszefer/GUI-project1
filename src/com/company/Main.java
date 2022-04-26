package com.company;
import java.util.ArrayList;
import java.util.List;
public class Main {

    public static void main(String[] args) {
        List<PozycjaMenu> menu = new ArrayList<>();
        PozycjaMenu p1 = new PozycjaMenu(1, "x", "y", 20.25);
        PozycjaMenu p2 = new PozycjaMenu(2, "d", "fy", 12);
        PozycjaMenu p3 = new PozycjaMenu(3, "f", "gt", 45);

        //Dodawanie do menu
        menu.add(p1);
        menu.add(p2);
        menu.add(p3);

        // Wypisanie menu
        for(PozycjaMenu poz : menu){
            System.out.println(poz.name);
        }

        System.out.println();

        Klient klient = new KlientStacjonarny("x", "y", 1);
        Zamowienie zamowienie = new Zamowienie(klient);
        List<Zamowienie> zamowienia = new ArrayList<>();
        zamowienia.add(zamowienie);
    }
}
