package hu.unideb.inf;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.Random;
import java.util.ResourceBundle;

public class DiceController implements Initializable {
    Utilities u = new Utilities();
    Random random = new Random();

    @FXML
    private ImageView diceImage;
    @FXML
    private Button rollButton;
    @FXML
    private ToggleGroup choice;
    @FXML
    private TextField betsize;
    @FXML
    private Label balance;
    @FXML
    private RadioButton b1, b2, b3, b4, b5, b6;

    int selectedNumber = 0;
    int r;

    @FXML
    void handleRoll(ActionEvent event) {

        if (selectedNumber != 0 && betsize.getText().length() != 0) {
            rollButton.setDisable(true);
            Thread thread = new Thread() {
                public void run() {
                    try {
                        for (int i = 0; i < 15; i++) {
                            r = (random.nextInt(6) + 1);
                            URL url = this.getClass().getClassLoader().getResource("images/dice/dice" + r + ".png");
                            File file = new File(url.getPath());
                            diceImage.setImage(new Image(file.toURI().toString()));
                            Thread.sleep(50);
                        }
                        rollButton.setDisable(false);
                        if(selectedNumber == r)
                        {
                            Platform.runLater(() -> {
                                LoginController.currentUser.setBalance(LoginController.currentUser.getBalance() + (Integer.parseInt(betsize.getText().toString()) * 6));
                                balance.setText(Integer.toString(LoginController.currentUser.getBalance()) + "Ft");
                            });
                        }
                    } catch (InterruptedException e) {
                    }
                }
            };
            thread.start();
        }
        try {
            LoginController.currentUser.setBalance(Integer.parseInt(balance.getText().toString().replace("Ft", ""))
                    - Integer.parseInt(betsize.getText().toString()));
            balance.setText(Integer.toString(LoginController.currentUser.getBalance()) + "Ft");
        }
        catch (NumberFormatException e)
        {
            System.out.println("Nincs megadva tet.");
        }
    }

    @FXML
    void handleBack(ActionEvent event) throws IOException
    {
        u.changeScene("/fxml/Homepage.fxml", event);
    }

    @FXML
    void getSelected(ActionEvent event)
    {
        if(b1.isSelected())
            selectedNumber = 1;
        if(b2.isSelected())
            selectedNumber = 2;
        if(b3.isSelected())
            selectedNumber = 3;
        if(b4.isSelected())
            selectedNumber = 4;
        if(b5.isSelected())
            selectedNumber = 5;
        if(b6.isSelected())
            selectedNumber = 6;
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        balance.setText(LoginController.currentUser.getBalance().toString() + "Ft");
    }
}
