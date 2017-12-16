package com.sda.ui;

import com.sda.controller.Magazyn;
import com.sda.model.Biblioteka;
import com.sda.model.Ksiazka;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.util.Callback;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class MainWindowController {

  @FXML private TableView<KsiazkaView> ksiazkiTableView;
  @FXML private TableColumn<KsiazkaView, String> idColumn;
  @FXML private TableColumn<KsiazkaView, String> tytulColumn;

  @FXML private TableColumn<KsiazkaView, String> autorColumn;

  @FXML private TableColumn<KsiazkaView, String> statusColumn;

  public void initTableView() {
    idColumn.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<KsiazkaView, String>, ObservableValue<String>>() {
      public ObservableValue<String> call(TableColumn.CellDataFeatures<KsiazkaView, String> p) {
        return p.getValue().idProperty();
      }
    });
    tytulColumn.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<KsiazkaView, String>, ObservableValue<String>>() {
      public ObservableValue<String> call(TableColumn.CellDataFeatures<KsiazkaView, String> p) {
        return p.getValue().tytulProperty();
      }
    });
    autorColumn.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<KsiazkaView, String>, ObservableValue<String>>() {
      public ObservableValue<String> call(TableColumn.CellDataFeatures<KsiazkaView, String> p) {
        return p.getValue().autorProperty();
      }
    });
    statusColumn.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<KsiazkaView, String>, ObservableValue<String>>() {
      public ObservableValue<String> call(TableColumn.CellDataFeatures<KsiazkaView, String> p) {
        return p.getValue().statusProperty();
      }
    });
  }

  public void loadValues() {
    List<Ksiazka> ksiazkiModel = Magazyn.getBiblioteka().getKsiazki();
    Biblioteka biblioteka = Magazyn.getBiblioteka();
    List<KsiazkaView> ksiazki = new ArrayList<>();
    for (Ksiazka ksiazka : ksiazkiModel){
      String status;
      if (biblioteka.czyKsiazkaJestDostepna(ksiazka)){
        status = "Dostępna";
      }else{
        status = "Wypożyczona";
      }
//      String statusDostepnosci = biblioteka.czyKsiazkaJestDostepna(ksiazka) ? "Dostępna" : "Wypożyczona";
      KsiazkaView k = new KsiazkaView(Integer.toString(ksiazka.getId()), ksiazka.getTytul(), ksiazka.getAutor().toString(), status);
      ksiazki.add(k);
    }


//    KsiazkaView k1 = new KsiazkaView("1", "Pan Tadeusz", "Adam Mickiewicz", "Dostępna");
//    KsiazkaView k2 = new KsiazkaView("2", "Pan Tadeusz v2", "Adam Mickiewicz", "Wypożyczona");
//    KsiazkaView k3 = new KsiazkaView("3", "Pan Tadeusz v3", "Adam Mickiewicz", "Wypożyczona");
//    KsiazkaView k4 = new KsiazkaView("4", "Pan Tadeusz v4", "Adam Mickiewicz", "Dostępna");
//    List<KsiazkaView> ksiazki = Stream.of(k1, k2, k3, k4).collect(Collectors.toList());
    ObservableList<KsiazkaView> ksiazkiView = FXCollections.observableArrayList(ksiazki);
    ksiazkiTableView.setItems(ksiazkiView);
  }

  public void otworzOknoDodawaniaNowejKsiazki(){
    Stage stage = new Stage();
    Parent root = null;
    try {
      FXMLLoader loader = new FXMLLoader(getClass().getResource("/DodajKsiazke.fxml"));
      root = loader.load();
      Scene scene = new Scene(root);
      stage.initModality(Modality.APPLICATION_MODAL);
      stage.setScene(scene);
      stage.show();
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

}
