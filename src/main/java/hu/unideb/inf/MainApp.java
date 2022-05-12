package hu.unideb.inf;

import entity.MailboxEntity;
import entity.UsersEntity;
import hu.unideb.inf.model.User;
import javafx.application.Application;

import javafx.fxml.FXML;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.List;

public class MainApp extends Application {

    public static Stage stage;
    public static List<UsersEntity> users =  HibernateConnector.getUsers();
    public static List<MailboxEntity> mailboxes =  HibernateConnector.getMailboxes();
    public static String currentMailboxString;

    @Override
    public void start(Stage stage) throws Exception {
        FXMLLoader loader = new FXMLLoader(MainApp.class.getResource("/fxml/Login.fxml"));
        Scene loginScene = new Scene(loader.load());
        stage.setTitle("Maxi Kakao Casino");
        stage.setScene(loginScene);
        stage.show();
        ShutDownTask shutDownTask = new ShutDownTask();
        Runtime.getRuntime().addShutdownHook(shutDownTask);
    }



    public static void main(String[] args) {
        launch(args);
    }

    private static class ShutDownTask extends Thread {
        @Override
        public void run()
        {
            HibernateConnector.close();
        }

    }

}
