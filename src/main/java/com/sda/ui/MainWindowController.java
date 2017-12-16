package com.sda.ui;

import com.sda.model.Ksiazka;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.util.Callback;

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
    KsiazkaView k1 = new KsiazkaView("1", "Pan Tadeusz", "Adam Mickiewicz", "Dostępna");
    KsiazkaView k2 = new KsiazkaView("2", "Pan Tadeusz v2", "Adam Mickiewicz", "Wypożyczona");
    KsiazkaView k3 = new KsiazkaView("3", "Pan Tadeusz v3", "Adam Mickiewicz", "Wypożyczona");
    KsiazkaView k4 = new KsiazkaView("4", "Pan Tadeusz v4", "Adam Mickiewicz", "Dostępna");
    List<KsiazkaView> ksiazki = Stream.of(k1, k2, k3, k4).collect(Collectors.toList());
    ObservableList<KsiazkaView> ksiazkiView = FXCollections.observableArrayList(ksiazki);
    ksiazkiTableView.setItems(ksiazkiView);
  }



}
