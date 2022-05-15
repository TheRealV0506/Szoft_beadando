package hu.unideb.inf;

import entity.MailboxEntity;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.TextInputDialog;

import java.io.IOException;
import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;

public class MailboxController implements Initializable {
    Utilities u = new Utilities();
    @FXML
    TextArea messages;

    @FXML
    void handleBack(ActionEvent event) throws IOException
    {
        u.changeScene("/fxml/Homepage.fxml", event);
    }
    @FXML
    void handleNewMessage() {
        MailboxEntity m = new MailboxEntity();
        TextInputDialog input = new TextInputDialog();
        input.setTitle("Új üzenet");
        input.getDialogPane().setContentText("Adja meg a felhasználót: ");
        Optional<String> result = input.showAndWait();
        TextField username = input.getEditor();
        if (username.getText() == null || username.getText().toString().length() == 0 || u.getUserId(username.getText().toString()) == 0) {
            Utilities.throwNotification("Sikertelen üzenetküldés", "Érvénytelen felhasználó!", Alert.AlertType.ERROR);
        }
        else {
            TextInputDialog input1 = new TextInputDialog();
            input1.getDialogPane().setContentText("Adja meg az üzenetet: ");
            result = input1.showAndWait();
            TextField message = input1.getEditor();
            if (message.getText() == null || message.getText().toString().length() == 0) {
                Utilities.throwNotification("Sikertelen üzenetküldés", "Érvénytelen üzenet!", Alert.AlertType.ERROR);
            } else {
                Utilities.throwNotification("Sikeres üzenetküldés", "Üzenet elküldve", Alert.AlertType.INFORMATION);
                m.setUserId(u.getUserId(username.getText().toString()));
                m.setMessages(message.getText().toString());
                m.setSender(LoginController.currentUser.getUsername());
                HibernateConnector.persistMessages(m);
            }
        }
    }

    @Override
    public void initialize(URL location, ResourceBundle resources)
    {
        messages.setText(MainApp.currentMailboxString);
    }
}

