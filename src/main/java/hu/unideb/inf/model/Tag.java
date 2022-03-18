package hu.unideb.inf.model;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

import java.time.LocalDate;

public class Tag {
    private StringProperty username = new SimpleStringProperty();
    private StringProperty mothername = new SimpleStringProperty();
    private StringProperty placeofbirth = new SimpleStringProperty();
    private StringProperty password = new SimpleStringProperty();
    private LocalDate dateOfBirth;

    public Tag(String username, String mothername, String placeofbirth, LocalDate dateOfBirth, String password) {
        this.username.setValue(username);
        this.mothername.setValue(mothername);
        this.placeofbirth.setValue(placeofbirth);
        this.dateOfBirth = dateOfBirth;
        this.password.setValue(password);
    }

    @Override
    public String toString() {
        return "Felhasználó " +
                "neve: " + username + '\'' +
                ", édesanyja neve: " + mothername +
                ", születési hely: " + placeofbirth +
                ", születési dátum: " + dateOfBirth;
    }

    public String getUsername() {
        return username.getValue();
    }

    public void setUsername(String username) {
        this.username.setValue(username);
    }

    public StringProperty usernameProperty(){
        return username;
    }

    public String getMotherName() {
        return mothername.getValue();
    }

    public void setMotherName(String mothername) {
        this.mothername.setValue(mothername);
    }

    public StringProperty MothernameProperty(){
        return mothername;
    }

    public String getPlaceofbirth() {
        return placeofbirth.getValue();
    }

    public void setPlaceofbirth(String placeofbirth) {
        this.placeofbirth.setValue(placeofbirth);
    }

    public StringProperty PlaceofbirthProperty(){
        return placeofbirth;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }
}
