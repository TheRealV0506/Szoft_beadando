package hu.unideb.inf;

import com.sun.javafx.charts.Legend;
import hu.unideb.inf.model.Model;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.io.IOException;

public class LoginController {

    //public static Stage home;

    @FXML
    private TextField username;

    @FXML
    private PasswordField password;


    @FXML
    public void handleLoginPressed(ActionEvent event) throws IOException {
        if(username.getText().equals("admin") && password.getText().equals("admin"))
        {
            MainApp m = new MainApp();
            m.changeScene("/fxml/Homepage.fxml", event);
        }
        else
        {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("ERROR!");
            alert.setHeaderText("Sikertelen bejelentkezés!");
            alert.setContentText("Hibás felhasználónév vagy jelszó!");
            alert.showAndWait();
        }
    }

    public void setModel(Model model) {
    }
}
