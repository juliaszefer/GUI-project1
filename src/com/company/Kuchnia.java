package com.company;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Kuchnia {
    private static final int defaultTime = 30000;
    static int dziennyUtarg = 0;
    static ArrayList<Kucharz> kucharze = new ArrayList<>();
    private static LinkedList<Zamowienie> zamowienia = new LinkedList<>();

    public Kuchnia(List<Kucharz> kucharze){
        zamowienia = new LinkedList<>();
    }

    public static void przygotujNastepneZamowienie(){
        java.util.Scanner in = new java.util.Scanner(System.in);
        if(zamowienia.size() < 1){
            System.out.println("Nie pozostało żadne zamówienie do wykonania");
            return;
        }
        int time = defaultTime-(kucharze.size()*100);
        int counter = 0;
        Zamowienie next = zamowienia.get(0);
        for(PozycjaMenu poz : next.pozycje){
            try{
                Thread.sleep(time);
                System.out.println("Przygotowano " + poz.name);
            }catch (Exception e){
                System.out.println("Wykonywanie zamówienia zostało przerwane");
            }
            counter += time;
        }
        if(counter > 15000){
            System.out.println("Czas oczekiwania na zamówienie przekroczył 15 min, czy chcesz czekać dalej?");
            System.out.println("Tak - 1\nNie - 2");
            int decyzja = in.nextInt();
            if(decyzja == 1){
                System.out.println("Twoje zamówienie zostanie wykonane jako następne, otrzymasz przy tym 20% zniżki");
                next.sumCena = next.sumCena - 0.2*next.sumCena;
                System.out.println("Nowa cena: " + next.sumCena);
            }else{
                zamowienia.remove(next);
                System.out.println("Twoje zamówienie zostało anulowane");
            }
        }
        System.out.println("Całe zamówienie zostało przygotowane");
        zamowienia.remove(next);
        dziennyUtarg += next.sumCena;
        next.czyGotowe = true;
        if(next.getClass().getSimpleName() == "KlientOnline"){
            Dostawca asd = (Dostawca) Dostawca.dostawcy.stream().filter((d) -> d.czyWolny ==true);
            asd.dostarczZamowienie(next);
        }else if(next.getClass().getSimpleName() == "KlientStacjonarny"){
            Kelner kelner = (Kelner) Kelner.kelnerzy.stream().filter((d) -> d.czyWolny==true);
            kelner.dostarczZamowienie(next);
        }

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
