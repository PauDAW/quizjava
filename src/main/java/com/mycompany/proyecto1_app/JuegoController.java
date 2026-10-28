package com.mycompany.proyecto1_app;

import javafx.fxml.FXML;
import javafx.scene.control.*;

public class JuegoController {

    @FXML private Label lblPregunta;
    @FXML private Label lblPuntuacion;
    @FXML private ProgressBar progressBar;
    @FXML private Label lblEnunciado;
    @FXML private RadioButton op1;
    @FXML private RadioButton op2;
    @FXML private RadioButton op3;
    @FXML private RadioButton op4;
    @FXML private Button btnComprobar;
    @FXML private Button btnSiguiente;
    @FXML private Button btnSalir;

    private Quiz quiz;
    private ToggleGroup grupo;
    
    
    private int numeroPreguntaActual = 1; 
    
    public void initialize() 
    {
        grupo = new ToggleGroup();
        op1.setToggleGroup(grupo);
        op2.setToggleGroup(grupo);
        op3.setToggleGroup(grupo);
        op4.setToggleGroup(grupo);

        quiz = new Quiz();
        GestorArchivos gestor = new GestorArchivos();
        quiz.setlistaPreguntas(gestor.cargarPreguntas("preguntas.txt"));

        mostrarPregunta();
    }
    
    private void mostrarPregunta() 
    {
        Pregunta preguntaActual = quiz.getPreguntaActual();
        
        
        lblPregunta.setText("Pregunta " + numeroPreguntaActual + " de 15");
        
        
        lblPuntuacion.setText("Puntuación: " + quiz.getaciertos() + " / 15");
        
        double progreso = (double) numeroPreguntaActual / 15.0;
        progressBar.setProgress(progreso);
        
        lblEnunciado.setText(preguntaActual.getenunciado());
        
        op1.setText(preguntaActual.getopcion1());
        op2.setText(preguntaActual.getopcion2());
        op3.setText(preguntaActual.getopcion3());
        op4.setText(preguntaActual.getopcion4());
        
        grupo.selectToggle(null);
        
        btnSiguiente.setDisable(true);
    }
    
    @FXML
    private void clickComprobar() 
    {
        RadioButton seleccionado = (RadioButton) grupo.getSelectedToggle();

        if (seleccionado == null) 
        {
            lblPuntuacion.setText("Por favor, selecciona una respuesta.");
            return; 
        }

        String respuestaDelUsuario = seleccionado.getText();
        Pregunta preguntaActual = quiz.getPreguntaActual();
                
        if(preguntaActual.esCorrecta(respuestaDelUsuario))
        {
            quiz.correcto(); 
            lblPuntuacion.setText("¡Acertaste! Enhorabuena."); 
        }
        else
        {
            quiz.fallos();
            lblPuntuacion.setText("¡Fallaste! Inténtalo en la siguiente.");
        }
        
        
        btnSiguiente.setDisable(false);
    }
    
    @FXML
    private void clickSiguiente() 
    {
        quiz.siguientePregunta();

        if (quiz.mas()) 
        {
            numeroPreguntaActual++; 
            mostrarPregunta();      
        } 
        else 
        {
            try 
            {
                
                javafx.fxml.FXMLLoader loader = new javafx.fxml.FXMLLoader(
                    App.class.getResource("/com/mycompany/proyecto1_app/puntuaciones.fxml")
                );
                javafx.scene.Parent root = loader.load();

                ResultadoController controladorDestino = loader.getController();
                controladorDestino.cargarDatos(quiz.getaciertos(), quiz.geterrores());

                javafx.stage.Stage stageActual = (javafx.stage.Stage) btnSiguiente.getScene().getWindow();
                stageActual.setScene(new javafx.scene.Scene(root));
                stageActual.show();
            } 
            catch (java.io.IOException e) 
            {
                e.printStackTrace();
            }
        }
    }
    
    @FXML
    private void clickSalir() 
    {
        System.exit(0); 
    }
    
    private boolean yaGuardado = false; 

    
    public void guardarResultado(String usuario, int aciertos, int fallos, String nota) {
        if (!yaGuardado) { 
            GestorArchivos gestor = new GestorArchivos();
            gestor.guardarPuntuacion(usuario, aciertos, fallos, nota);
            yaGuardado = true; 
            System.out.println("Resultado guardado correctamente.");
        } else {
            System.out.println("Ya se ha guardado una puntuación en esta sesión.");
        }
    }
}