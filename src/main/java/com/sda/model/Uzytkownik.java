package com.sda.model;

public class Uzytkownik {
  private int id;
  private String imie;
  private String nazwisko;
  private String pesel;
  private Plec plec;


  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getImie() {
    return imie;
  }

  public void setImie(String imie) {
    this.imie = imie;
  }

  public String getNazwisko() {
    return nazwisko;
  }

  public void setNazwisko(String nazwisko) {
    this.nazwisko = nazwisko;
  }

  public String getPesel() {
    return pesel;
  }

  public void setPesel(String pesel) {
    this.pesel = pesel;
  }

  public Plec getPlec() {
    return plec;
  }

  public void setPlec(Plec plec) {
    this.plec = plec;
  }
}
