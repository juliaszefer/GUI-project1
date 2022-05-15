package com.company;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ZarzadzanieMenu {

    public String walidacjaNazwa(String nazwa){
        java.util.Scanner on = new java.util.Scanner(System.in);
        boolean isWrong = true;
        while (isWrong) {
            System.out.println("Podaj nazwę:");
            String nazwaTmp = on.nextLine();
            System.out.println("Wprowadzona nazwa: " + nazwaTmp);

            Pattern pattern = Pattern.compile("[a-zA-Z\s-]+");
            Matcher matcher = pattern.matcher(nazwaTmp);
            if (matcher.matches()) {
                isWrong = false;
                nazwa = nazwaTmp;
            } else {
                System.out.println("Podano nieprawidłowy format, spróbuj ponownie");
            }
        }
        return nazwa;
    }

    public int walidacjaIlosci(int ilosc){
        java.util.Scanner on = new java.util.Scanner(System.in);
        boolean isWrong = true;
        while (isWrong) {
            System.out.println("Podaj ilosc:");
            String iloscTmp = on.nextLine();
            System.out.println("Wprowadzona ilosc: " + iloscTmp);

            Pattern pattern = Pattern.compile("[0-9]+");
            Matcher matcher = pattern.matcher(iloscTmp);
            if (matcher.matches()) {
                isWrong = false;
                ilosc = Integer.parseInt(iloscTmp);
            } else {
                System.out.println("Podano nieprawidłowy format, spróbuj ponownie");
            }
        }
        return ilosc;
    }

    public String walidacjaOpis(String opis){
        java.util.Scanner on = new java.util.Scanner(System.in);
        boolean isWrong = true;
        while (isWrong) {
            System.out.println("Podaj opis:");
            String opisTmp = on.nextLine();
            System.out.println("Wprowadzony opis: " + opisTmp);

            Pattern pattern = Pattern.compile("[a-zA-Z\s-]+");
            Matcher matcher = pattern.matcher(opisTmp);
            if (matcher.matches()) {
                isWrong = false;
                opis = opisTmp;
            } else {
                System.out.println("Podano nieprawidłowy format, spróbuj ponownie");
            }
        }
        return opis;
    }

    public double walidacjaCena(double cena){
        java.util.Scanner on = new java.util.Scanner(System.in);
        boolean isWrong = true;
        while (isWrong) {
            System.out.println("Podaj cenę:");
            String cenaTmp = on.nextLine();
            System.out.println("Wprowadzona cena: " + cenaTmp);

            try {
                cena = Double.parseDouble(cenaTmp);
                if (cena > 0) {
                    isWrong = false;
                } else {
                    System.out.println("Cena musi być liczbą dodatnią");
                }
            } catch (NumberFormatException e) {
                System.out.println("Podano nieprawidłowy format ceny, spróbuj ponownie");
            }
        }
        return cena;
    }

    public String walidacjaAdres(String adres){
        java.util.Scanner on = new java.util.Scanner(System.in);
        boolean isWrong = true;
        while (isWrong) {
            System.out.println("Podaj adres w formacie -- miasto kod pocztowy, ulica nr domu nr mieszkania :");
            String adresTmp = on.nextLine();
            System.out.println("Wprowadzony adres: " + adresTmp);

            Pattern pattern = Pattern.compile("[a-zA-Z\s,0-9]+");
            Matcher matcher = pattern.matcher(adresTmp);
            if (matcher.matches()) {
                isWrong = false;
                adres = adresTmp;
            } else {
                System.out.println("Podano nieprawidłowy format, spróbuj ponownie");
            }
        }
        return adres;
    }
}
