package hu.unideb.inf;

import com.mysql.cj.log.Log;
import entity.MailboxEntity;
import entity.UsersEntity;
import hu.unideb.inf.model.User;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;

import java.io.IOException;
import java.net.URL;
import java.sql.Date;
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
/*
    @FXML
    public void passUser(UsersEntity in) {
        this.user = new User(in.getUsername(), in.getFullName(), in.getEmail(), in.getDateOfBirth().toLocalDate(), in.getPword(), in.getBalance());
    }*/
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
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        username.setText(LoginController.currentUser.getUsername());
        balance.setText(LoginController.currentUser.getBalance().toString());
    }
}
