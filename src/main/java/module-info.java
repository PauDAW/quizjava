module com.mycompany.proyecto1_app {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.base;

    opens com.mycompany.proyecto1_app to javafx.fxml;
    exports com.mycompany.proyecto1_app;
}
