package hu.unideb.inf;

import javafx.application.Application;

import javafx.fxml.FXML;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.stage.Stage;

import java.io.IOException;

public class MainApp extends Application {

    public static Stage stage;

    @Override
    public void start(Stage stage) throws Exception {
        FXMLLoader loader = new FXMLLoader(MainApp.class.getResource("/fxml/Login.fxml"));
        System.out.println(loader.hashCode());
        Scene loginScene = new Scene(loader.load());
        stage.setTitle("Maxi Kakao Casino");
        stage.setScene(loginScene);
        stage.show();
    }

    @FXML
    public void changeScene(String fxmlstring) throws IOException
    {
        FXMLLoader loader = new FXMLLoader(getClass().getResource(fxmlstring));
        //Scene homepage = new Scene(loader.load());
        //stage.setScene(homepage);
        //stage.show();
        stage.getScene().setRoot(loader.load());
    }

    public static void main(String[] args) {
        launch(args);
    }

}
