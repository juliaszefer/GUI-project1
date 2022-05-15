package com.company;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Zamowienie {
    public static List<Zamowienie> zamowienia = new ArrayList<>();
    // statyczna -> zawsze ta sama, nie nalezy do obiektu, nalezy do klasy
    int numerZamowienia;
    Klient klient;
    boolean czyGotowe;
    LocalDateTime data;
    ArrayList<PozycjaMenu> pozycje = new ArrayList<>();

    public Zamowienie(Klient klient){
        czyGotowe = false;
        this.klient = klient;
        data = LocalDateTime.now();
        if(zamowienia.size() != 0) {
            Zamowienie ostatnieZamowienie = zamowienia.get(zamowienia.size() -1);
            if(ostatnieZamowienie.data.getDayOfMonth() == data.getDayOfMonth()){
                numerZamowienia = ostatnieZamowienie.numerZamowienia + 1;
            } else {
                numerZamowienia = 1;
            }
        } else {
            numerZamowienia = 1;
        }
        zamowienia.add(this);
    }

    public void dodajPozycje(PozycjaMenu pozycja){
        pozycje.add(pozycja);
    }


}
