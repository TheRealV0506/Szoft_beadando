package hu.unideb.inf;

import hu.unideb.inf.model.Model;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class MainApp extends Application {

    @Override
    public void start(Stage stage) throws Exception {
        HibernateConnector.persistData();
        //Platform.setImplicitExit(false);
        FXMLLoader loader = new FXMLLoader(MainApp.class.getResource("/fxml/Login.fxml"));
        Scene loginScene = new Scene(loader.load());
        ((LoginController)loader.getController()).setModel(new Model());
        stage.setTitle("Bejelentkezés");
        stage.setScene(loginScene);
        stage.show();
    }

    public void changeScene(String fxmlstring, ActionEvent event) throws IOException
    {
        Parent home = (Parent) FXMLLoader.load(getClass().getResource(fxmlstring));
        Scene scene = new Scene(home);
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }

}
