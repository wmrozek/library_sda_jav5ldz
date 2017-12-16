package com.sda.narzedzia;

import com.sda.model.Autor;
import com.sda.model.Biblioteka;
import com.sda.model.Ksiazka;
import com.sda.model.Uzytkownik;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.List;

public class KopiaZapasowa {

  public static void zapiszBibliotekeDoPliku(Biblioteka biblioteka) {
    zapiszKsiazki(biblioteka);


  }

  private static void zapiszKsiazki(Biblioteka biblioteka) {
    File file = new File("./ksiazki.txt");
    StringWriter sw = new StringWriter();
    for (Ksiazka ksiazka : biblioteka.getKsiazki()) {
      sw.append("id:" + ksiazka.getId() + ",");
      sw.append("tytul:" + ksiazka.getTytul() + ",");
      sw.append("\n");
    }
    FileWriter fw = null;
    try {
      fw = new FileWriter(file);
      fw.write(sw.toString());
      fw.close();
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  private static void zapiszUzytkownikow(Biblioteka biblioteka) {
    File file = new File("./uzytkownicy.txt");
    StringWriter sw = new StringWriter();
    for (Uzytkownik uzytkownik : biblioteka.getUzytkownicy()) {
      sw.append("id:" + uzytkownik.getId() + ",");
      sw.append("imie:" + uzytkownik.getImie() + ",");
      sw.append("\n");
    }
    FileWriter fw = null;
    try {
      fw = new FileWriter(file);
      fw.write(sw.toString());
      fw.close();
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  public static Biblioteka odczytajBibliotekeZPliku() {
    List<Ksiazka> ksiazki = getKsiazki();

    Biblioteka biblioteka = new Biblioteka();
    biblioteka.odzyskajZKopii(ksiazki, new ArrayList<>(), new ArrayList<>());
    return biblioteka;
  }

  private static List<Ksiazka> getKsiazki() {
    File file = new File("./ksiazki.txt");
    List<Ksiazka> ksiazki = new ArrayList<>();
    try {
      BufferedReader reader = new BufferedReader(new FileReader(file));
      String line = reader.readLine();
      while(line != null){
        String[] pola = line.split(",");
        Ksiazka ksiazka = new Ksiazka();
        Autor autor = new Autor();
        ksiazka.setAutor(autor);
        for (String pole : pola){
          String[] nazwaWartosc = pole.split(":");
          switch (nazwaWartosc[0]){
            case "id":
              ksiazka.setId(Integer.parseInt(nazwaWartosc[1]));
              break;
            case "tytul":
              ksiazka.setTytul(nazwaWartosc[1]);
              break;
            case "autor.imie":
              autor.setImie(nazwaWartosc[1]);
              break;
            case "autor.nazwisko":
              autor.setNazwisko(nazwaWartosc[1]);
              break;
          }
        }
        ksiazki.add(ksiazka);
        line = reader.readLine();
      }
    } catch (FileNotFoundException e) {
      e.printStackTrace();
    } catch (IOException e) {
      e.printStackTrace();
    }
    return ksiazki;
  }
}
