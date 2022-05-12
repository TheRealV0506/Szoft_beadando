package hu.unideb.inf;

import entity.MailboxEntity;
import entity.UsersEntity;
import hu.unideb.inf.model.User;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class LoginController {

    @FXML
    private TextField username;

    @FXML
    private PasswordField password;

    Utilities u = new Utilities();
    public static UsersEntity currentUser;
    public static List<MailboxEntity> currentMailbox = new ArrayList<MailboxEntity>();

    @FXML
    void handleLoginPressed(ActionEvent event) throws IOException {
        MainApp.users = HibernateConnector.getUsers();
        MainApp.mailboxes = HibernateConnector.getMailboxes();
        for (UsersEntity user : MainApp.users)
            if (username.getText().toString().equals(user.getUsername()) && password.getText().toString().equals(user.getPword()))
            {
                currentUser = user;
                for (MailboxEntity mailbox : MainApp.mailboxes)
                    if (mailbox.getUserId() == currentUser.getId())
                        currentMailbox.add(mailbox);
                u.changeScene("/fxml/Homepage.fxml", event);
                return;
            }

        Utilities.throwNotification("Sikertelen bejelentkezés!", "Hibás felhasználónév vagy jelszó!", Alert.AlertType.ERROR);
    }

    @FXML
    private void handleToRegistration(ActionEvent event) throws IOException
    {
        u.changeScene("/fxml/Registration.fxml", event);
    }
}
