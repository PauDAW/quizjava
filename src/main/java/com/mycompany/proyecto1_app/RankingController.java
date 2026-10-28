package com.mycompany.proyecto1_app;

import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import java.util.List;

public class RankingController {

    @FXML private TableView<jugador> tablaRanking;
    @FXML private TableColumn<jugador, Integer> colTop;
    @FXML private TableColumn<jugador, String> colUsuario;
    @FXML private TableColumn<jugador, Integer> colAciertos;
    @FXML private TableColumn<jugador, Integer> colFallos;
    @FXML private TableColumn<jugador, String> colNota;

    @FXML
    public void initialize() {
        colTop.setCellValueFactory(new PropertyValueFactory<>("top"));
        colUsuario.setCellValueFactory(new PropertyValueFactory<>("usuario"));
        colAciertos.setCellValueFactory(new PropertyValueFactory<>("aciertos"));
        colFallos.setCellValueFactory(new PropertyValueFactory<>("fallos"));
        colNota.setCellValueFactory(new PropertyValueFactory<>("nota"));
        mostrarDatos();
    }

    private void mostrarDatos() {
        GestorArchivos gestor = new GestorArchivos();
        List<jugador> listaReal = gestor.cargarRanking();
        ObservableList<jugador> datos = FXCollections.observableArrayList(listaReal);
        tablaRanking.setItems(datos);
    }

    @FXML
    private void accionBorrarRanking(ActionEvent event) {
        GestorArchivos gestor = new GestorArchivos();
        gestor.borrarRanking();
        mostrarDatos();
    }

    @FXML
private void accionVolver(ActionEvent event) {
    try {
        javafx.stage.Stage stage = (javafx.stage.Stage) tablaRanking.getScene().getWindow();
        javafx.scene.Parent root = javafx.fxml.FXMLLoader.load(
            App.class.getResource("/com/mycompany/proyecto1_app/menu.fxml")
        );
        stage.setScene(new javafx.scene.Scene(root));
        stage.show();
    } catch (Exception e) {
        e.printStackTrace();
    }
}

@FXML
private void accionSalir(ActionEvent event) {
    System.exit(0);
}
}

