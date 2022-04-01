package hu.unideb.inf;

import entity.UsersEntity;
import hu.unideb.inf.model.User;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.DatePicker;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

import javax.swing.*;
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

    MainApp m = new MainApp();
    HomepageController h = new HomepageController();

    @FXML
    private void handleToLogin(ActionEvent event) throws IOException
    {
        m.changeScene("/fxml/Login.fxml", event);
    }

    @FXML
    private void handleRegistrationPressed(ActionEvent event) throws IOException
    {
        if (!fullName.getText().equals("") && !username.getText().equals("") && !email.getText().equals("") && !password.getText().equals("") && birthDate.getValue() != null)
        {
            UsersEntity user = new UsersEntity();
            user.setFullName(fullName.getText());
            user.setUsername(username.getText());
            user.setEmail(email.getText());
            user.setPword(password.getText());
            user.setDateOfBirth(Date.valueOf(birthDate.getValue()));
            user.setBalance(10000);
            HibernateConnector.persistData(user);
            m.changeScene("/fxml/Homepage.fxml", event);
            h.passUser(user);
        }
        else
        {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText("Sikertelen regisztráció!");
            alert.setContentText("Minden mező kitöltése kötelező!");
            alert.showAndWait();
        }
    }
}
