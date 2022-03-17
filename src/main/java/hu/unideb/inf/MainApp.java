package hu.unideb.inf;

import hu.unideb.inf.model.Model;
import javafx.application.Application;
import static javafx.application.Application.launch;

import javafx.fxml.FXML;
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
        ((LoginController)loader.getController()).setModel(new Model());
        stage.setTitle("Bejelentkezés :(");
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

    /**
     * The main() method is ignored in correctly deployed JavaFX application.
     * main() serves only as fallback in case the application can not be
     * launched through deployment artifacts, e.g., in IDEs with limited FX
     * support. NetBeans ignores main().
     *
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }

}
