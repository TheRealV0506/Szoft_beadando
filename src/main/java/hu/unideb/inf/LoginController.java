package hu.unideb.inf;

<<<<<<< Updated upstream
import hu.unideb.inf.model.Model;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
=======
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.PasswordField;
>>>>>>> Stashed changes
import javafx.scene.control.TextField;

import java.io.IOException;

public class LoginController {
    private Model model;

<<<<<<< Updated upstream
    public void setModel(Model model) {
        this.model = model;
    }

=======
>>>>>>> Stashed changes
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

<<<<<<< Updated upstream
    @FXML
    private Label balanceLabel;

    private void refreshUI() {
        motherLabel.setText("" + model.getTag().getMotherName());
        placeLabel.setText("" + model.getTag().getPlaceofbirth());
        birthDayLabel.setText(model.getTag().getDateOfBirth().toString());
    }
=======
    MainApp m = new MainApp();
>>>>>>> Stashed changes

    @FXML
    void handleLoadButtonPushed(ActionEvent event) {
        nameLabel.textProperty().bind(model.getTag().usernameProperty());
        refreshUI();
    }
    @FXML
    void handleLoginPressed(ActionEvent event) throws IOException {
        if(username.getText().toString().equals("admin") && password.getText().toString().equals("admin"))
        {
<<<<<<< Updated upstream
            MainApp m = new MainApp();
            m.changeScene("/fxml/Homepage.fxml");
=======
            m.changeScene("/fxml/Homepage.fxml", event);
>>>>>>> Stashed changes
        }
        else
        {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("ERROR!");
            alert.setHeaderText("Sikertelen bejelentkezés!");
            alert.setContentText("Buzik nem jöhetnek be!");
            alert.showAndWait();
        }
    }
<<<<<<< Updated upstream
=======

    @FXML
    private void handleToRegistration(ActionEvent event) throws IOException
    {
        m.changeScene("/fxml/Registration.fxml", event);
    }

>>>>>>> Stashed changes
}
