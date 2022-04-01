package hu.unideb.inf;

import entity.UsersEntity;
import hu.unideb.inf.model.User;
import javafx.beans.property.StringProperty;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

import java.io.IOException;
import java.sql.Date;

public class HomepageController {

    @FXML
    public User user;

    @FXML
    private Label username;
    @FXML
    private Label balance;

    @FXML
    public void passUser(UsersEntity in) {
        this.user = new User(in.getUsername(), in.getFullName(), in.getEmail(), in.getDateOfBirth().toLocalDate(), in.getPword(), in.getBalance());
        setLabels();
    }
    @FXML
    public void setLabels()
    {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/Homepage.fxml"));
        loader.setController(this);
        username.setText(user.getUsername());
        balance.setText(user.getBalance().toString());

    }

}
