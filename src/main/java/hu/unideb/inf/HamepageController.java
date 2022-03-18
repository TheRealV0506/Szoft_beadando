package hu.unideb.inf;

import hu.unideb.inf.model.Model;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

public class HamepageController {


    void HP(Stage stage) throws Exception {
        FXMLLoader loader = new FXMLLoader(MainApp.class.getResource("/fxml/Homepage.fxml"));
        System.out.println(loader.hashCode());
        Scene HomePageScene = new Scene(loader.load());
        ((HamepageController)loader.getController()).setModel(new Model());
        stage.setTitle("Bejelentkezés");
        stage.setScene(HomePageScene);
        stage.show();
    }

    public void setModel(Model model) {
    }
}
