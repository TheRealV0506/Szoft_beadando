package hu.unideb.inf;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class DepositController implements Initializable {
    Utilities u = new Utilities();
    @FXML
    private Label username, balance;
    @FXML
    private TextField cardNumber, cardExpiration, cardCCV, amount;

    @FXML
    void handleBack(ActionEvent event) throws IOException
    {
        u.changeScene("/fxml/Homepage.fxml", event);
    }
    @FXML
    void handleDeposit(ActionEvent event) throws IOException
    {
        if (cardNumber.getText().toString().length() != 0 && cardExpiration.getText().toString().length() != 0
                && cardCCV.getText().toString().length() != 0 && amount.getText().toString().length() != 0)
        {
            LoginController.currentUser.setBalance(LoginController.currentUser.getBalance() + Integer.parseInt(amount.getText().toString()));
            Utilities.throwNotification("Sikeres befizetés!", "Az összeg hozzá lett adva a számlához.", Alert.AlertType.INFORMATION);
            u.changeScene("/fxml/Homepage.fxml", event);
        }
        else
        {
            Utilities.throwNotification("Sikertelen befizetés", "Nem megfelelő adatok.", Alert.AlertType.ERROR);
        }
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        username.setText(LoginController.currentUser.getUsername());
        balance.setText(LoginController.currentUser.getBalance().toString() + "Ft");
    }
}
