package hu.unideb.inf.model;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

import java.time.LocalDate;

public class Tag {
    private StringProperty name = new SimpleStringProperty();
    private StringProperty mothername = new SimpleStringProperty();
    private StringProperty placeofbirth = new SimpleStringProperty();
    private LocalDate dateOfBirth;

    public Tag(String name, String mothername, String placeofbirth, LocalDate dateOfBirth) {
        this.name.setValue(name);
        this.mothername.setValue(mothername);
        this.placeofbirth.setValue(placeofbirth);
        this.dateOfBirth = dateOfBirth;
    }

    @Override
    public String toString() {
        return "Felhasználó " +
                "neve: " + name + '\'' +
                ", édesanyja neve: " + mothername +
                ", születési hely: " + placeofbirth +
                ", születési dátum: " + dateOfBirth;
    }

    public String getName() {
        return name.getValue();
    }

    public void setName(String name) {
        this.name.setValue(name);
    }

    public StringProperty nameProperty(){
        return name;
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
