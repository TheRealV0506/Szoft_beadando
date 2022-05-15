package hu.unideb.inf;

import entity.UsersEntity;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.DatePicker;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

import java.io.IOException;
import java.sql.Date;

public class RegistrationController
{
    @FXML
    private TextField fullName;

    @FXML
    private TextField username;

    @FXML
    private TextField email;

    @FXML
    private PasswordField password;

    @FXML
    private DatePicker birthDate;

    Utilities u = new Utilities();

    @FXML
    private void handleToLogin(ActionEvent event) throws IOException
    {
        u.changeScene("/fxml/Login.fxml", event);
    }

    @FXML
    private void handleRegistrationPressed(ActionEvent event) throws IOException
    {
        if (!fullName.getText().equals("") && !username.getText().equals("") && !email.getText().equals("") && !password.getText().equals("") && birthDate.getValue() != null)
        {
            for (UsersEntity u : MainApp.users)
                if (u.getUsername().equals(username.getText()))
                {
                    Utilities.throwNotification("Sikertelen regisztráció!", "Ezzel a felhasználónévvel már van regisztálva felhasználó!", Alert.AlertType.ERROR);
                    return;
                }

            UsersEntity user = new UsersEntity();
            user.setFullName(fullName.getText());
            user.setUsername(username.getText());
            user.setEmail(email.getText());
            user.setPword(password.getText());
            user.setDateOfBirth(Date.valueOf(birthDate.getValue()));
            user.setBalance(10000);
            LoginController.currentUser = user;
            MainApp.users.add(LoginController.currentUser);
            HibernateConnector.persistData(user);
            u.changeScene("/fxml/Homepage.fxml", event);
            //h.passUser(user);
        }
        else
        {
            Utilities.throwNotification("Sikertelen regisztráció!", "Minden mező kitöltése kötelező!", Alert.AlertType.ERROR);
        }
    }
}
