package hu.unideb.inf;

import entity.UsersEntity;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.stage.Stage;

import java.io.IOException;

public class Utilities
{
    public static void throwNotification(String header, String context, Alert.AlertType type)
    {
        Alert alert = new Alert(type);
        alert.setHeaderText(header);
        alert.setContentText(context);
        alert.showAndWait();
    }

    @FXML
    public void changeScene(String fxmlstring, ActionEvent event) throws IOException
    {
        Parent home = (Parent) FXMLLoader.load(getClass().getResource(fxmlstring));
        Scene scene = new Scene(home);
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();
    }

    public int getUserId(String username)
    {
        for (UsersEntity user : MainApp.users)
            if (user.getUsername().equals(username))
                return user.getId();

        return 0;
    }
}

