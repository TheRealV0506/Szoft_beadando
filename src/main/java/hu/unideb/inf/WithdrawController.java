package hu.unideb.inf;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class WithdrawController implements Initializable {
    Utilities u = new Utilities();

    @FXML
    private Label username, balance;

    @FXML
    void handleBack(ActionEvent event) throws IOException
    {
        u.changeScene("/fxml/Homepage.fxml", event);
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        username.setText(LoginController.currentUser.getUsername());
        balance.setText(LoginController.currentUser.getBalance().toString() + "Ft");
    }
}
