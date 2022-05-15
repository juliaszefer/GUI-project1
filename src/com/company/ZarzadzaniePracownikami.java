package com.company;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ZarzadzaniePracownikami {

    public String dodajImie(String name){
        java.util.Scanner in = new java.util.Scanner(System.in);
        boolean isWrong = true;
        while (isWrong) {
            System.out.println("Podaj imię:");
            String nazwaTmp = in.nextLine();
            System.out.println("Wprowadzone imię: " + nazwaTmp);

            Pattern pattern = Pattern.compile("[a-zA-Z]+");
            Matcher matcher = pattern.matcher(nazwaTmp);
            if (matcher.matches()) {
                isWrong = false;
                name = nazwaTmp;
            } else {
                System.out.println("Podano nieprawidłowy format, spróbuj ponownie");
            }
        }
        return name;
    }

    public String dodajNazwisko(String nazwisko){
        java.util.Scanner in = new java.util.Scanner(System.in);
        boolean isWrong = true;
        while (isWrong) {
            System.out.println("Podaj nazwisko:");
            String nazwaTmp = in.nextLine();
            System.out.println("Wprowadzone nazwisko: " + nazwaTmp);

            Pattern pattern = Pattern.compile("[a-zA-Z]+");
            Matcher matcher = pattern.matcher(nazwaTmp);
            if (matcher.matches()) {
                isWrong = false;
                nazwisko = nazwaTmp;
            } else {
                System.out.println("Podano nieprawidłowy format, spróbuj ponownie");
            }
        }
        return nazwisko;
    }

    public String dodajNrTel(String nrtel){
        java.util.Scanner in = new java.util.Scanner(System.in);
        boolean isWrong = true;
        while (isWrong) {
            System.out.println("Podaj nr tel:");
            String nazwaTmp = in.nextLine();
            System.out.println("Wprowadzony nr tel: " + nazwaTmp);

            Pattern pattern = Pattern.compile("[0-9]{9}");
            Matcher matcher = pattern.matcher(nazwaTmp);
            if (matcher.matches()) {
                isWrong = false;
                nrtel = nazwaTmp;
            } else {
                System.out.println("Podano nieprawidłowy format, spróbuj ponownie");
            }
        }
        return nrtel;
    }

    public double dodajPensje(double pensja){
        java.util.Scanner in = new java.util.Scanner(System.in);
        boolean isWrong = true;
        while (isWrong) {
            System.out.println("Podaj pensję:");
            String cenaTmp = in.nextLine();
            System.out.println("Wprowadzona pensja: " + cenaTmp);

            try {
                pensja = Double.parseDouble(cenaTmp);
                if (pensja > 0) {
                    isWrong = false;
                } else {
                    System.out.println("Pensja musi być liczbą dodatnią");
                }
            } catch (NumberFormatException e) {
                System.out.println("Podano nieprawidłowy format ceny, spróbuj ponownie");
            }
        }
        return pensja;
    }

    public void zwolnienie(List<Pracownik> pracownicy){
        java.util.Scanner in = new java.util.Scanner(System.in);
        boolean idxExists = false;
        while (!idxExists) {
            System.out.println("podaj dwukrotnie id pracownika, którego chcesz zwolnić: ");
            int doZwolnienia = in.nextInt();

            //sprawdzenie czy istnieje taki indeks
            if (doZwolnienia < 0 || doZwolnienia > pracownicy.size()) {
                System.out.println("nie ma takiego indeksu");
            } else {
                pracownicy.removeIf(poz -> poz.id == doZwolnienia);
                System.out.println("Pracownik nr: " + doZwolnienia + " został zwolniony");
                idxExists = true;
            }
        }
    }
    public void zwolnienieKucharza(List<Kucharz> kucharze){
        java.util.Scanner in = new java.util.Scanner(System.in);
        boolean idxExists = false;
        while (!idxExists) {
            int doZwolnienia = in.nextInt();
                kucharze.removeIf(poz -> poz.id == doZwolnienia);
                System.out.println("pracownicy po zwolnieniu: ");
                idxExists = true;
//            }
        }
    }
    public void zwolnienieDostawca(List<Dostawca> dostawcy){
        java.util.Scanner in = new java.util.Scanner(System.in);
        boolean idxExists = false;
        while (!idxExists) {
            int doZwolnienia = in.nextInt();
                dostawcy.removeIf(poz -> poz.id == doZwolnienia);
                System.out.println("pracownicy po zwolnieniu: ");
                idxExists = true;
        }
    }
    public void zwolnienieKelnera(List<Kelner> kelnerzy){
        java.util.Scanner in = new java.util.Scanner(System.in);
        boolean idxExists = false;
        while (!idxExists) {
            int doZwolnienia = in.nextInt();
                kelnerzy.removeIf(poz -> poz.id == doZwolnienia);
                System.out.println("pracownicy po zwolnieniu: ");
                idxExists = true;
        }
    }

}
