package hu.unideb.inf;

import hu.unideb.inf.model.Model;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class MainApp extends Application {

    @Override
    public void start(Stage stage) throws Exception {
        //Platform.setImplicitExit(false);
        FXMLLoader loader = new FXMLLoader(MainApp.class.getResource("/fxml/Login.fxml"));
        System.out.println(loader.hashCode());
        Scene loginScene = new Scene(loader.load());
        ((LoginController)loader.getController()).setModel(new Model());
        stage.setTitle("Bejelentkezés");
        stage.setScene(loginScene);
        stage.show();
    }


    /*@FXML
    public void changeScene(String fxmlstring) throws IOException
    {
        FXMLLoader loader = new FXMLLoader(MainApp.class.getResource(fxmlstring));
        Scene homepage = new Scene(loader.load());
        stage.setScene(homepage);
        stage.show();
        stage.getScene().setRoot(loader.load());
    }*/

    public static void main(String[] args) {
        launch(args);
    }

}
