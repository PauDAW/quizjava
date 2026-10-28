package com.mycompany.proyecto1_app;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.event.ActionEvent;

public class MenuController {

    @FXML private Button btnIniciar;
    @FXML private Button btnPuntuaciones;
    @FXML private Button btnInstrucciones;
    @FXML private Button btnSalir;

    @FXML
    private void accionIniciar(ActionEvent event) {
        try { App.navegarA("juego", btnIniciar); } catch (Exception e) { e.printStackTrace(); }
    }

    @FXML
    private void accionRanking(ActionEvent event) {
        try { App.navegarA("ranking", btnPuntuaciones); } catch (Exception e) { e.printStackTrace(); }
    }

    @FXML
    private void accionSalir(ActionEvent event) {
        System.exit(0);
    }
}