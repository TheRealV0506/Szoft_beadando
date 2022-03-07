package hu.unideb.inf;

import hu.unideb.inf.model.Model;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;

public class FXMLSceneController {
    private Model model;

    public void setModel(Model model) {
        this.model = model;
    }

    @FXML
    private Label birthDayLabel;

    @FXML
    private Label motherLabel;

    @FXML
    private Label placeLabel;

    @FXML
    private Label helloLabel;

    @FXML
    private Label nameLabel;

    @FXML
    void handleChangeName(ActionEvent event) {
        model.getTag().setName("Nagy József");
        model.getTag().setMotherName("Kissné Erzsébet");
        model.getTag().setPlaceofbirth("Debrecen");
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("ERROR!");
        alert.setHeaderText("Nincs több felhasználó!");
        alert.setContentText("Kérésed sajnos átmenetileg nem végrehajtható!");
        alert.showAndWait();
    }

    private void refreshUI() {
        motherLabel.setText("" + model.getTag().getMotherName());
        placeLabel.setText("" + model.getTag().getPlaceofbirth());
        birthDayLabel.setText(model.getTag().getDateOfBirth().toString());
    }

    @FXML
    void handleLoadButtonPushed(ActionEvent event) {
        nameLabel.textProperty().bind(model.getTag().nameProperty());
        refreshUI();
    }

    @FXML
    void handleButtonPushed(){
        System.out.println("Megnyomtal egy gombot! :)");
        if (helloLabel.getText().equals("fekete")) helloLabel.setText("fehér");
        else helloLabel.setText("fekete");
    }
}
