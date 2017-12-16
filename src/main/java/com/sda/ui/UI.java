package com.sda.ui;

import com.sda.controller.Magazyn;
import com.sda.controller.ZarzadzanieBiblioteka;
import com.sda.model.Biblioteka;
import com.sda.model.Gatunek;
import com.sda.model.Ksiazka;
import com.sda.narzedzia.KopiaZapasowa;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class UI extends Application{

  public static void main(String[] args) {
    launch(args);
  }

  @Override public void start(Stage primaryStage) {
    Magazyn.initBiblioteka();
    Parent root = null;
    try {
      FXMLLoader loader = new FXMLLoader(getClass().getResource("/MainWindow.fxml"));
      root = loader.load(); //root = FXMLLoader.load(getClass().getResource("/MainWindow.fxml");
      Scene scene = new Scene(root);
      MainWindowController controller = loader.getController();
      controller.initTableView();
      controller.loadValues();
      primaryStage.setScene(scene);
      primaryStage.show();
    } catch (IOException e) {
      e.printStackTrace();
    }
  }


//  public static void main(String[] args) {
//    Biblioteka biblioteka = new Biblioteka();
  //
  //    Ksiazka ksiazka = new Ksiazka();
  //    ksiazka.setTytul("Pan Tadeusz");
  //    ksiazka.setLiczbaStron(500);
  //    ksiazka.setGatunek(Gatunek.HORROR);
  //    ksiazka.setRokWydania(2007);
  //
  //    ZarzadzanieBiblioteka.dodajKsiazkeDoBiblioteki(ksiazka, biblioteka);
  //    System.out.println(ZarzadzanieBiblioteka.zwrocTytulyKsiazek(biblioteka));
  //
  ////    KopiaZapasowa.zapiszBibliotekeDoPliku(biblioteka);
  //
  //    Biblioteka kopia = KopiaZapasowa.odczytajBibliotekeZPliku();
  //
  //    System.out.println(ZarzadzanieBiblioteka.zwrocTytulyKsiazek(kopia));
//
//  }
}
