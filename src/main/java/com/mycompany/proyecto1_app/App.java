package com.mycompany.proyecto1_app;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class App extends Application {

    private static Scene scene;

    @Override
    public void start(Stage stage) throws IOException {
        
        scene = new Scene(loadFXML("menu"), 640, 480);
        stage.setScene(scene);
        stage.show();
    }

    public static void setRoot(String fxml) throws IOException {
        scene.setRoot(loadFXML(fxml));
    }

    private static Parent loadFXML(String fxml) throws IOException {
    String ruta = "/com/mycompany/proyecto1_app/" + fxml + ".fxml";
    java.net.URL url = App.class.getResource(ruta);
    if (url == null) {
        throw new IOException("No se encuentra el archivo FXML: " + ruta);
    }
    FXMLLoader fxmlLoader = new FXMLLoader(url);
    return fxmlLoader.load();
}

    public static void main(String[] args) {
        launch();
    }
    
    public static void navegarA(String fxml, javafx.scene.Node nodo) throws IOException {
    javafx.stage.Stage stage = (javafx.stage.Stage) nodo.getScene().getWindow();
    javafx.scene.Parent root = javafx.fxml.FXMLLoader.load(
        App.class.getResource("/com/mycompany/proyecto1_app/" + fxml + ".fxml")
    );
    stage.setScene(new javafx.scene.Scene(root));
    stage.show();
}

}