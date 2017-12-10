package com.sda.ui;

import com.sda.controller.ZarzadzanieBiblioteka;
import com.sda.model.Biblioteka;
import com.sda.model.Gatunek;
import com.sda.model.Ksiazka;
import com.sda.narzedzia.KopiaZapasowa;

public class UI {
  public static void main(String[] args) {
    Biblioteka biblioteka = new Biblioteka();

    Ksiazka ksiazka = new Ksiazka();
    ksiazka.setTytul("Pan Tadeusz");
    ksiazka.setLiczbaStron(500);
    ksiazka.setGatunek(Gatunek.HORROR);
    ksiazka.setRokWydania(2007);

    ZarzadzanieBiblioteka.dodajKsiazkeDoBiblioteki(ksiazka, biblioteka);
    System.out.println(ZarzadzanieBiblioteka.zwrocTytulyKsiazek(biblioteka));

//    KopiaZapasowa.zapiszBibliotekeDoPliku(biblioteka);

    Biblioteka kopia = KopiaZapasowa.odczytajBibliotekeZPliku();

    System.out.println(ZarzadzanieBiblioteka.zwrocTytulyKsiazek(kopia));

  }
}
