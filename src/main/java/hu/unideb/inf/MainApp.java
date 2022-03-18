package hu.unideb.inf;

import hu.unideb.inf.model.Model;
import javafx.application.Application;
import static javafx.application.Application.launch;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.io.IOException;
import java.io.PrintWriter;

public class MainApp extends Application {

    public Stage stage;

    @Override
    public void start(Stage stage) throws Exception {
        Platform.setImplicitExit(false);
        FXMLLoader loader = new FXMLLoader(MainApp.class.getResource("/fxml/Login.fxml"));
        System.out.println(loader.hashCode());
        Scene loginScene = new Scene(loader.load());
        ((LoginController)loader.getController()).setModel(new Model());
        stage.setTitle("Bejelentkezés");
        stage.setScene(loginScene);
        stage.show();
    }


    @FXML
    public void changeScene(String fxmlstring) throws IOException
    {
        FXMLLoader loader = new FXMLLoader(MainApp.class.getResource(fxmlstring));
        Scene homepage = new Scene(loader.load());
        stage.setScene(homepage);
        stage.show();
        stage.getScene().setRoot(loader.load());
    }

    public static void main(String[] args) {
        launch(args);
    }

}
