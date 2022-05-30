package com.company;

import java.io.Serializable;

public class PozycjaMenu implements Serializable {
    public static final long serialVersionUID = 550158088619555917L;
    int id;
    String name;
    String opis;
    double cena;
    int ilosc;
    boolean czyDostepny;

    // TODO: dodaj w zaleznosci czy dostepna
    public PozycjaMenu(int id, String name, String opis, double cena, int ilosc) {
        this.id = id;
        this.name = name;
        this.opis = opis;
        this.cena = cena;
        this.ilosc = ilosc;
        if (ilosc > 0) {
            czyDostepny = true;
        } else {
            czyDostepny = false;
        }
    }

    public boolean zuzyjProdukt() {
        if (ilosc <= 0) {
            return false;
        }
        ilosc -= ilosc;
        if(ilosc == 0){
            czyDostepny = false;
        }
        return true;
    }


    public String taoString() {
        return id + " - " + name + ", opis: " + opis + ", cena: " + cena;
    }
}
