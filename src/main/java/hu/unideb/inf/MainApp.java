package hu.unideb.inf;

import hu.unideb.inf.model.Model;
import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;


public class MainApp extends Application {

    @Override
    public void start(Stage stage) throws Exception {
        FXMLLoader loader = new FXMLLoader(MainApp.class.getResource("/fxml/Login.fxml"));
        Scene loginScene = new Scene(loader.load());
        loader = new FXMLLoader(MainApp.class.getResource("/fxml/Login.fxml"));
        Scene loggedIn = new Scene(loader.load());
        ((FXMLSceneController)loader.getController()).setModel(new Model());
        stage.setTitle("Bejelentkezés :(");
        stage.setScene(loginScene);
        stage.show();
        /*Parent root = FXMLLoader.load(getClass().getResource("/fxml/Scene.fxml"));
        
        Scene loginScene = new Scene(root);
        loginScene.getStylesheets().add("/styles/Styles.css");
        
        stage.setTitle("JavaFX and Maven");
        stage.setScene(loginScene);
        stage.show();*/
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
