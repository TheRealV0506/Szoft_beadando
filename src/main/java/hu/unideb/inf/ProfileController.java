package hu.unideb.inf;

import entity.UsersEntity;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.TextInputDialog;
import javafx.scene.layout.VBox;
import javafx.stage.Popup;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.Date;
import java.util.Optional;
import java.util.ResourceBundle;

import static hu.unideb.inf.MainApp.stage;

public class ProfileController implements Initializable {

    Utilities u = new Utilities();
    @FXML
    private Label FullName;
    @FXML
    private Label Username;
    @FXML
    private Label Email;
    @FXML
    private Label DateOfBirth;
    @FXML
    private Label Balance;


    @FXML
    void handleBack(ActionEvent event) throws IOException
    {
        u.changeScene("/fxml/Homepage.fxml", event);
    }

    @FXML
    void handleChangePassword(ActionEvent event) throws IOException
    {
        TextInputDialog input = new TextInputDialog();
        input.setTitle("Jelszó változtatás");
        input.getDialogPane().setContentText("Új jelszó: ");
        Optional<String> result = input.showAndWait();
        TextField password = input.getEditor();
        if (password.getText() == null || password.getText().toString().length() == 0)
            Utilities.throwNotification("Sikertelen jelszó változtatás", "Érvénytelen jelszó!", Alert.AlertType.ERROR);
        LoginController.currentUser.setPword(password.getText().toString());
        HibernateConnector.updateUser(LoginController.currentUser);
        Utilities.throwNotification("Jelszó megváltozott", "Sikeres jelszó változtatás.", Alert.AlertType.INFORMATION);
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        FullName.setText(LoginController.currentUser.getFullName());
        Username.setText(LoginController.currentUser.getUsername());
        Email.setText(LoginController.currentUser.getEmail());
        DateOfBirth.setText(LoginController.currentUser.getDateOfBirth().toString());
        Balance.setText(LoginController.currentUser.getBalance().toString());
    }
}
