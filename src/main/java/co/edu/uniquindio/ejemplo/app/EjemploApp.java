package co.edu.uniquindio.ejemplo.app;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class EjemploApp extends Application {

    @Override
    public void start(Stage stage) throws Exception {

        FXMLLoader loader = new FXMLLoader(EjemploApp.class.getResource("/inicio.fxml"));
        Parent parent = loader.load();

        Scene scene = new Scene(parent);
        stage.setScene(scene);
        stage.setResizable(false);
        stage.setTitle("Ejemplo App");
        stage.show();

    }

    public static void main(String[] args) {
        launch(EjemploApp.class, args);
    }
}
