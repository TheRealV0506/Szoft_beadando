package hu.unideb.inf;

import entity.MailboxEntity;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;

import java.io.IOException;
import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;

public class HomepageController implements Initializable{

    Utilities u = new Utilities();

    @FXML
    private Button logout;
    @FXML
    private Label username;
    @FXML
    private Label balance;

    @FXML
    void handleLogout(ActionEvent event) throws IOException
    {
        u.changeScene("/fxml/Login.fxml", event);
    }
    @FXML
    void handleProfile(ActionEvent event) throws IOException
    {
        u.changeScene("/fxml/Profile.fxml", event);
    }
    @FXML
    void handleDice(ActionEvent event) throws IOException
    {
        u.changeScene("/fxml/Dice.fxml", event);
    }
    @FXML
    void handleProfileDeletion(ActionEvent event) throws IOException
    {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setHeaderText("Profil törlés");
        alert.setContentText("Biztosan törölni akarja a profilját?");
        Optional<ButtonType> result = alert.showAndWait();
        if (result.get() == ButtonType.OK)
        {
            HibernateConnector.deleteUser();
            u.changeScene("/fxml/Login.fxml", event);
        }
    }
    @FXML
    void handleMailbox(ActionEvent event) throws IOException
    {
        if (!LoginController.currentMailbox.isEmpty())
        {
            StringBuilder sb = new StringBuilder();
            for (MailboxEntity m : LoginController.currentMailbox)
            {
                sb.append(m.getSender());
                sb.append(": ");
                sb.append(m.getMessages());
                sb.append("\n");
            }
            MainApp.currentMailboxString = sb.toString();
        }
        else
        {
            MainApp.currentMailboxString = "Nincs üzenet.";
        }
        u.changeScene("/fxml/Mailbox.fxml", event);

    }
    @FXML
    void handleDeposit(ActionEvent event) throws IOException
    {
        u.changeScene("/fxml/Deposit.fxml", event);
    }
    @FXML
    void handleWithdraw(ActionEvent event) throws IOException
    {
        u.changeScene("/fxml/Withdraw.fxml", event);
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        username.setText(LoginController.currentUser.getUsername());
        balance.setText(LoginController.currentUser.getBalance().toString() + "Ft");
    }
}
