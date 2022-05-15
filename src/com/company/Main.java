package com.company;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {

    static String menuFilePath = "./data/menu.txt";

    public static void showList(List<PozycjaMenu> menu) {
        System.out.println("=====================");
        for (PozycjaMenu poz : menu) {
            System.out.println(poz.id + ". " + poz.name + " - " + poz.opis + " - " + poz.cena);
        }
    }

    public static void wypiszPracownikow(List<Pracownik> pracownicy) {
        for (Pracownik pracownik : pracownicy) {
            System.out.println(pracownik.id + ". " + pracownik.name + " " + pracownik.surname + ", numer telefonu: " + pracownik.numerTelefonu + ", pensja: " + pracownik.pensja);
        }
    }

    public static void updateMenu(ArrayList<PozycjaMenu> menu){
        try (FileOutputStream fout = new FileOutputStream(menuFilePath)) {
            ObjectOutputStream ous = new ObjectOutputStream(fout);
            ous.writeObject(menu);
        } catch (IOException e) {
            System.out.println("Wystąpił błąd podczas uaktualniania menu");
        }
    }

    public static ArrayList<PozycjaMenu> readMenu(){
        try {
            FileInputStream fis = new FileInputStream(menuFilePath);
            ObjectInputStream ois = new ObjectInputStream(fis);
            ArrayList<PozycjaMenu> menuFile = (ArrayList<PozycjaMenu>) ois.readObject();
            return menuFile;
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Wystąpił błąd podczas odczytu menu");
            return new ArrayList<>();
        }
    }

    public static ArrayList<PozycjaMenu> mockMenu() {
        ArrayList<PozycjaMenu> menu = new ArrayList<>();
        File file = new File(menuFilePath);

        if (!(file.exists() && !file.isDirectory())) {
            PozycjaMenu p1 = new PozycjaMenu(1, "Kurczak chrupiący", "kurczak w chrupiącej panierce podawany z ryżem oraz sałatką", 22.99, 5);
            PozycjaMenu p2 = new PozycjaMenu(2, "Phad Thai z kurczakiem", "smażony makaron ryżowy z kurczakiem podawany z ryżem oraz sosem słodko-pikantnym", 24.99, 7);
            PozycjaMenu p3 = new PozycjaMenu(3, "Sajgonki", "sajgonki z wieprzowiną oraz sałatką", 10.99, 12);
            PozycjaMenu p4 = new PozycjaMenu(4, "Krewetki królewskie", "krewetki królewskie podawane w sosie maślano-czosnkowym", 31.99, 9);
            PozycjaMenu p5 = new PozycjaMenu(5, "Zupa pho", "łagodna zupa z dodatkiem wołowiny i makaronu ryżowego", 15.99, 2);
            PozycjaMenu p6 = new PozycjaMenu(6, "Curry z wołowiną", "ryż ze świeżymi warzywami, wołowiną i curry", 25.99, 4);
            PozycjaMenu p7 = new PozycjaMenu(7, "woda", "niegazowana woda źródlana", 4.99, 20);
            PozycjaMenu p8 = new PozycjaMenu(8, "coca-cola", "słodki gazowany napój", 6.99, 22);
            PozycjaMenu p9 = new PozycjaMenu(9, "ice-tea", "słodki niegazowany napój", 6.99, 23);

            //Dodawanie do menu

            menu.add(p1);
            menu.add(p2);
            menu.add(p3);
            menu.add(p4);
            menu.add(p5);
            menu.add(p6);
            menu.add(p7);
            menu.add(p8);
            menu.add(p9);

            // zapis do pliku

            updateMenu(menu);
        }

        menu = readMenu();

        return menu;
    }


    public static void main(String[] args) {


        java.util.Scanner in = new java.util.Scanner(System.in);

        //-----------------------------------------------------------------------

        ArrayList<PozycjaMenu> menu = mockMenu();

        List<Pracownik> pracownicy = new ArrayList<>();

        Kucharz kucharz1 = new Kucharz(1, "Marek", "Kowalski", "509867122", 3500);
        Kucharz kucharz2 = new Kucharz(2, "Jacek", "Góral", "603765402", 4000);
        Kucharz kucharz3 = new Kucharz(3, "Maria", "Posiecka", "745823099", 4200);

        Dostawca dostawca = new Dostawca(4, "Monika", "Pierwsza", "123456789", 2600);

        Kelner kelner = new Kelner(5, "Kamil", "Drugi", "987654321", 2900);


        kucharz1.dodajKucharza(kucharz1, pracownicy);
        kucharz2.dodajKucharza(kucharz2, pracownicy);
        kucharz3.dodajKucharza(kucharz3, pracownicy);
        dostawca.dodajDostawce(dostawca, pracownicy);
        kelner.dodajKelnera(kelner, pracownicy);

        List<Kucharz> kucharze = new ArrayList<>();
        kucharze.add(kucharz1);
        kucharze.add(kucharz2);
        kucharze.add(kucharz3);

        Kuchnia kuchnia = new Kuchnia(kucharze);

        List<Dostawca> dostawcy = new ArrayList<>();
        dostawcy.add(dostawca);

        List<Kelner> kelnerzy = new ArrayList<>();
        kelnerzy.add(kelner);

        //-----------------------------------------------------------------------


        // odczyt z pliku
//        try{
//            FileInputStream fis = new FileInputStream(menuFilePath);
//            ObjectInputStream ois = new ObjectInputStream(fis);
//            ArrayList<PozycjaMenu> menuFile = (ArrayList<PozycjaMenu>)ois.readObject();
//            menuFile.forEach(System.out::println);
//        }catch (IOException | ClassNotFoundException e){
//            e.printStackTrace();
//        }

        //-----------------------------------------------------------------------


        while (true) {
            System.out.println("Witamy w restauracji s24690");
            System.out.println("Jesteś klientem (1) czy pracownikiem (2)?");
            int idKlient = 1;
            int idPracownik = 2;
            int podajId = in.nextInt();
            int password = 246902022;
            if (podajId == idKlient) {
                //--------------Strona klienta---------------------------------------------------------
                System.out.println("menu:");
                int nrStolika = 0;
                // Wypisanie menu
                menu = readMenu();
                showList(menu);
                System.out.println("\nCzy chcesz dokonać zamówienia online (1) czy stacjonarnie (2)?");
                int jakieZamowienie = in.nextInt();
                String imie = "";
                String nazwisko = "";
                ZarzadzaniePracownikami zarzadzaniePracownikami = new ZarzadzaniePracownikami();
                imie = zarzadzaniePracownikami.dodajImie(imie);
                nazwisko = zarzadzaniePracownikami.dodajNazwisko(nazwisko);

                if (jakieZamowienie == 1) {
                    String adres = "";
                    ZarzadzanieMenu zarzadzanieMenu = new ZarzadzanieMenu();
                    adres = zarzadzanieMenu.walidacjaAdres(adres);
                    Klient klientOnline = new KlientOnline(imie, nazwisko, true, adres);
                    Zamowienie zamowienie = new Zamowienie(klientOnline);
                    System.out.println("Ile pozycji z menu chciałbyś zamówić?");
                    int iloscPoyzcji = in.nextInt();
                    for (int i = 0; i < iloscPoyzcji; i++) {
                        System.out.println("Podaj id pozycji, która chciałbyś zamówić:");
                        int idPozycji = in.nextInt();
                        for (PozycjaMenu poz : menu) {
                            if (poz.id == idPozycji) {
                                zamowienie.zlozZamowienie(poz);
                            }
                        }
                    }
                } else if (jakieZamowienie == 2) {
                    nrStolika += nrStolika;
                    Klient klientStacjonarny = new KlientStacjonarny(imie, nazwisko, nrStolika);
                }

            } else if (podajId == idPracownik) {
                //----------------Strona pracownika-------------------------------------------------------

                System.out.println("Wpisz hasło do systemu");
                int podajHaslo = in.nextInt();

                if (podajHaslo == password) {
                    System.out.println("Co chciałbyś zrobić?");
                    System.out.println("Zarządzanie menu - 1\nZarządzanie pracownikami - 2");
                    int zarzadzanie = in.nextInt();
                    if (zarzadzanie == 1) {
                        System.out.println("Co chciałbyś zrobić?");
                        System.out.println("Dodanie pozycji do menu - 1\nUsunięcie pozycji z menu - 2\nEdycja pozycji z menu - 3");
                        int coChceszZrobic = in.nextInt();
                        ZarzadzanieMenu zarzadzanieMenu = new ZarzadzanieMenu();
                        if (coChceszZrobic == 1) {

                            System.out.println("menu przed dodaniem nowej pozycji: ");
                            showList(menu);

                            // Dodanie pozycji do menu

                            //walidacja nazwy
                            String nazwa = "";
                            nazwa = zarzadzanieMenu.walidacjaNazwa(nazwa);

                            //walidacja opisu
                            String opis = "";
                            opis = zarzadzanieMenu.walidacjaOpis(opis);

                            //walidacja ceny
                            double cena = 0;
                            cena = zarzadzanieMenu.walidacjaCena(cena);

                            //walidacja ilosci
                            int ilosc = 0;
                            ilosc = zarzadzanieMenu.walidacjaIlosci(ilosc);

                            PozycjaMenu nowaPozycja = new PozycjaMenu(menu.size() + 1, nazwa, opis, cena, ilosc);
                            menu.add(nowaPozycja);

                            System.out.println("menu po dodaniu nowej pozycji:");
                            showList(menu);
                        } else if (coChceszZrobic == 2) {
                            // Usunięcie pozycji z menu
                            System.out.println("menu przed usunięciem: ");
                            showList(menu);
                            boolean idxExists = false;
                            while (!idxExists) {
                                System.out.println("podaj id pozycji z menu, którą chcesz usunąć: ");
                                int doUsuniecia = in.nextInt();

                                //sprawdzenie czy istnieje taki indeks
                                if (doUsuniecia < 0 || doUsuniecia > menu.size()) {
                                    System.out.println("nie ma takiego indeksu");
                                } else {
                                    menu.removeIf(poz -> poz.id == doUsuniecia);
                                    System.out.println("pozycja nr: " + doUsuniecia + " została usunięta");
                                    System.out.println("menu po usunięciu: ");
                                    showList(menu);
                                    idxExists = true;
                                }
                            }

                        } else if (coChceszZrobic == 3) {
                            System.out.println("menu przed edycja:");
                            showList(menu);
                            // Edycja pozycji z menu
                            boolean idxExists = false;
                            //sprawdzenie czy index istnieje
                            while (!idxExists) {
                                System.out.println("podaj id pozycji z menu, którą chcesz edytować: ");
                                int doEdycji = in.nextInt();
                                if (doEdycji < 0 || doEdycji > menu.size()) {
                                    System.out.println("nie ma takiego indeksu");
                                } else {
                                    menu.removeIf(poz -> poz.id == doEdycji);
                                    java.util.Scanner on = new java.util.Scanner(System.in);

                                    //walidacja nazwy
                                    String nazwa = "";
                                    boolean isWrong2 = true;
                                    nazwa = zarzadzanieMenu.walidacjaNazwa(nazwa);

                                    //walidacja opisu
                                    String opis = "";
                                    opis = zarzadzanieMenu.walidacjaOpis(opis);

                                    //walidacja ilosci
                                    int ilosc = 0;
                                    ilosc = zarzadzanieMenu.walidacjaIlosci(ilosc);

                                    //walidacja ceny
                                    double cena = 0;
                                    cena = zarzadzanieMenu.walidacjaCena(cena);
                                    PozycjaMenu poz = new PozycjaMenu(doEdycji, nazwa, opis, cena, ilosc);
                                    menu.add(doEdycji - 1, poz);
                                    System.out.println("menu po edycji:");
                                    showList(menu);
                                    idxExists = true;
                                }
                            }
                        }
                        updateMenu(menu);

                    } else if (zarzadzanie == 2) {
                        System.out.println("Co chciałbyś zrobić?");
                        System.out.println("Zatrudnienie nowego pracownika - 1\nZwolenienie pracownika - 2");
                        int wyborOpcji = in.nextInt();
                        if (wyborOpcji == 1) {
                            String name = "";
                            String surname = "";
                            String numerTelefonu = "";
                            double pensja = 0;
                            ZarzadzaniePracownikami zarzadzaniePracownikami = new ZarzadzaniePracownikami();
                            name = zarzadzaniePracownikami.dodajImie(name);
                            surname = zarzadzaniePracownikami.dodajNazwisko(surname);
                            numerTelefonu = zarzadzaniePracownikami.dodajNrTel(numerTelefonu);
                            pensja = zarzadzaniePracownikami.dodajPensje(pensja);
                            System.out.println("Kogo chcesz zatrudnić?");
                            System.out.println("Kucharz - 1\nDostawca - 2\nKelner - 3");
                            int wybor = in.nextInt();
                            if (wybor == 1) {
                                Kucharz kucharz = new Kucharz(pracownicy.size(), name, surname, numerTelefonu, pensja);
                                pracownicy.add(kucharz);
                                kucharze.add(kucharz);
                                wypiszPracownikow(pracownicy);
                            } else if (wybor == 2) {
                                Dostawca dostawca1 = new Dostawca(pracownicy.size(), name, surname, numerTelefonu, pensja);
                                pracownicy.add(dostawca1);
                                dostawcy.add(dostawca1);
                                wypiszPracownikow(pracownicy);
                            } else if (wybor == 3) {
                                Kelner kelner1 = new Kelner(pracownicy.size(), name, surname, numerTelefonu, pensja);
                                pracownicy.add(kelner1);
                                kelnerzy.add(kelner1);
                                wypiszPracownikow(pracownicy);
                            } else {
                                System.out.println("Nie wybrano poprawnej opcji");
                            }

                        } else if (wyborOpcji == 2) {
                            ZarzadzaniePracownikami zarzadzaniePracownikami = new ZarzadzaniePracownikami();
                            System.out.println("Kogo chcesz zwolnić?");
                            System.out.println("Kucharz - 1\nDostawca - 2\nKelner - 3");
                            int wybor = in.nextInt();
                            if (wybor == 1) {
                                zarzadzaniePracownikami.zwolnienie(pracownicy);
                                zarzadzaniePracownikami.zwolnienieKucharza(kucharze);
                                wypiszPracownikow(pracownicy);
                            } else if (wybor == 2) {
                                zarzadzaniePracownikami.zwolnienie(pracownicy);
                                zarzadzaniePracownikami.zwolnienieDostawca(dostawcy);
                                wypiszPracownikow(pracownicy);
                            } else if (wybor == 3) {
                                zarzadzaniePracownikami.zwolnienie(pracownicy);
                                zarzadzaniePracownikami.zwolnienieKelnera(kelnerzy);
                                wypiszPracownikow(pracownicy);

                            } else {
                                System.out.println("Nie wybrano poprawnej opcji");
                            }

                            if (kucharze.isEmpty() || dostawcy.isEmpty() || kelnerzy.isEmpty()) {
//                                throw new EmptyArrayList("Uwaga!! Na danym stanowisku nie pozostał żaden pracownik, restauracja nie może dalej pracować");
                            }


                        }
                    } else {
                        System.out.println("Nieprawidłowe hasło, spróbuj ponownie");
                    }
                }

                Klient klient = new KlientStacjonarny("x", "y", 1);
                Zamowienie zamowienie = new Zamowienie(klient);

            }
        }
    }
}
