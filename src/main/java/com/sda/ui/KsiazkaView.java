package com.sda.ui;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class KsiazkaView {
  private StringProperty id;
  private StringProperty tytul;
  private StringProperty autor;
  private StringProperty status;

  public KsiazkaView(String id, String tytul, String autor, String status) {
    this.id = new SimpleStringProperty(id);
    this.tytul = new SimpleStringProperty(tytul);
    this.autor = new SimpleStringProperty(autor);
    this.status = new SimpleStringProperty(status);
  }

  public String getId() {
    return id.get();
  }

  public StringProperty idProperty() {
    return id;
  }

  public String getTytul() {
    return tytul.get();
  }

  public StringProperty tytulProperty() {
    return tytul;
  }

  public String getAutor() {
    return autor.get();
  }

  public StringProperty autorProperty() {
    return autor;
  }

  public String getStatus() {
    return status.get();
  }

  public StringProperty statusProperty() {
    return status;
  }
}
