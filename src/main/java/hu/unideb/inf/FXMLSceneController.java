package hu.unideb.inf;

import hu.unideb.inf.model.Model;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.io.IOException;

public class FXMLSceneController {
    private Model model;

    public void setModel(Model model) {
        this.model = model;
    }

    @FXML
    private TextField username;

    @FXML
    private TextField password;

    @FXML
    private Label birthDayLabel;

    @FXML
    private Label motherLabel;

    @FXML
    private Label placeLabel;

    @FXML
    private Label nameLabel;

    @FXML
    private Label balanceLabel;

    private void refreshUI() {
        motherLabel.setText("" + model.getTag().getMotherName());
        placeLabel.setText("" + model.getTag().getPlaceofbirth());
        birthDayLabel.setText(model.getTag().getDateOfBirth().toString());
    }

    @FXML
    void handleLoadButtonPushed(ActionEvent event) {
        nameLabel.textProperty().bind(model.getTag().usernameProperty());
        refreshUI();
    }
    @FXML
    void handleLoginPressed(ActionEvent event)
    {
        MainApp.login(username.getText(), password.getText());
    }
}
