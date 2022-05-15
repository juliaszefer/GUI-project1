package com.company;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Zamowienie {
    public static List<Zamowienie> zamowienia = new ArrayList<>();
    // statyczna -> zawsze ta sama, nie nalezy do obiektu, nalezy do klasy
    int numerZamowienia;
    Klient klient;
    boolean czyGotowe;
    LocalDate data;
    ArrayList<PozycjaMenu> pozycje = new ArrayList<>();

    public Zamowienie(Klient klient){
        czyGotowe = false;
        LocalDate now = LocalDate.now();
        this.klient = klient;
        data = LocalDate.now();
        if(zamowienia.size() != 0) {
            Zamowienie ostatnieZamowienie = zamowienia.get(zamowienia.size() -1);
            if(ostatnieZamowienie.data.getDayOfMonth() == now.getDayOfMonth()){
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
