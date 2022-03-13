package hu.unideb.inf;

import hu.unideb.inf.model.Model;
import javafx.application.Application;
import static javafx.application.Application.launch;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.stage.Stage;

import java.io.IOException;

public class MainApp extends Application {

    public static Stage stage;

    @Override
    public void start(Stage stage) throws Exception {
        FXMLLoader loader = new FXMLLoader(MainApp.class.getResource("/fxml/Login.fxml"));
        Scene loginScene = new Scene(loader.load());
        ((FXMLSceneController)loader.getController()).setModel(new Model());
        stage.setTitle("Bejelentkezés :(");
        stage.setScene(loginScene);
        stage.show();
    }

    @FXML
    static boolean login(String uname, String pw)
    {
        FXMLLoader loader = new FXMLLoader(MainApp.class.getResource("/fxml/Homepage.fxml"));
        try {
            Scene loggedIn = new Scene(loader.load());
            if(uname == "admin" && pw == "admin")
            {
                stage.setScene(loggedIn);
                stage.show();
                System.out.println("loggedin");
            }
        } catch (IOException e) {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("ERROR!");
            alert.setHeaderText("Sikertelen bejelentkezés!");
            alert.setContentText("Kérésed sajnos átmenetileg nem végrehajtható!");
            alert.showAndWait();
        }

        return true;
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
