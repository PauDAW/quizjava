package com.mycompany.proyecto1_app;

import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class ResultadoController {

    @FXML private Label lblAciertos;
    @FXML private Label lblFallos;
    @FXML private TextField txtNombre;
    @FXML private Button btnGuardar;
    @FXML private Label lblMensaje;

    private int aciertosFinales;
    private int fallosFinales;

    public void cargarDatos(int aciertos, int errores) {
        this.aciertosFinales = aciertos;
        this.fallosFinales = errores;
        lblAciertos.setText("ACIERTOS: " + aciertos);
        lblFallos.setText("FALLOS: " + errores);
    }

    @FXML
private void accionGuardarRanking(ActionEvent event) {
    String nombre = txtNombre.getText();
    if (nombre == null || nombre.trim().isEmpty()) {
        return;
    }
    String nota = (aciertosFinales > fallosFinales) ? "APTO" : "NO APTO";
    
    GestorArchivos gestor = new GestorArchivos();
    gestor.guardarPuntuacionSinRepetir(nombre, aciertosFinales, fallosFinales, nota);
    
    try {
        App.navegarA("ranking", btnGuardar);
    } catch (Exception e) {
        e.printStackTrace();
    }
}

    @FXML
private void accionVolver(ActionEvent event) {
    try { App.navegarA("menu", btnGuardar); } catch (Exception e) { e.printStackTrace(); }
}

@FXML
private void accionReintentar(ActionEvent event) {
    try { App.navegarA("juego", btnGuardar); } catch (Exception e) { e.printStackTrace(); }
}
}