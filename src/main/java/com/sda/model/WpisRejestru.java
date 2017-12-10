package com.sda.model;

import java.time.LocalDate;

public class WpisRejestru {
  private Ksiazka ksiazka;
  private Uzytkownik uzytkownik;
  private LocalDate dataWypozyczenia;
  private LocalDate dataZwrotu;

  public WpisRejestru(Ksiazka ksiazka, Uzytkownik uzytkownik, LocalDate dataWypozyczenia, LocalDate dataZwrotu) {
    this.ksiazka = ksiazka;
    this.uzytkownik = uzytkownik;
    this.dataWypozyczenia = dataWypozyczenia;
    this.dataZwrotu = dataZwrotu;
  }

  public Ksiazka getKsiazka() {
    return ksiazka;
  }

  public void setKsiazka(Ksiazka ksiazka) {
    this.ksiazka = ksiazka;
  }

  public Uzytkownik getUzytkownik() {
    return uzytkownik;
  }

  public void setUzytkownik(Uzytkownik uzytkownik) {
    this.uzytkownik = uzytkownik;
  }

  public LocalDate getDataWypozyczenia() {
    return dataWypozyczenia;
  }

  public void setDataWypozyczenia(LocalDate dataWypozyczenia) {
    this.dataWypozyczenia = dataWypozyczenia;
  }

  public LocalDate getDataZwrotu() {
    return dataZwrotu;
  }

  public void setDataZwrotu(LocalDate dataZwrotu) {
    this.dataZwrotu = dataZwrotu;
  }
}
