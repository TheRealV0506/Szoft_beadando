package hu.unideb.inf;

import entity.MailboxEntity;
import entity.UsersEntity;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

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
        stage.setResizable(false);
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
            HibernateConnector.updateUser(LoginController.currentUser);
            HibernateConnector.close();
        }

    }

}
