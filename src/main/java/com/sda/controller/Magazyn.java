package com.sda.controller;

import com.sda.model.Biblioteka;
import com.sda.narzedzia.KopiaZapasowa;

public class Magazyn {
  private static Biblioteka biblioteka;

  public static Biblioteka getBiblioteka() {
    return biblioteka;
  }

  public static void initBiblioteka(){
    try{
      biblioteka = KopiaZapasowa.odczytajBibliotekeZPliku();
    }catch (Exception e){
      biblioteka = new Biblioteka();
    }
  }
}
