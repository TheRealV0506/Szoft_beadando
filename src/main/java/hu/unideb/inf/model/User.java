package hu.unideb.inf.model;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

import java.time.LocalDate;

public class User {
    final private StringProperty username = new SimpleStringProperty();
    final private StringProperty fullName = new SimpleStringProperty();
    final private StringProperty email = new SimpleStringProperty();
    final private StringProperty password = new SimpleStringProperty();
    final private IntegerProperty balance = new SimpleIntegerProperty();
    private LocalDate dateOfBirth;

    public User(String username, String fullName, String email, LocalDate dateOfBirth, String password, Integer balance) {
        this.username.setValue(username);
        this.fullName.setValue(fullName);
        this.email.setValue(email);
        this.dateOfBirth = dateOfBirth;
        this.password.setValue(password);
        this.balance.setValue(balance);
    }

    @Override
    public String toString() {
        return "Felhasználó " +
                "neve: " + fullName + '\'' +
                ", username: " + username +
                ", email: " + email +
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

    public String getPassword() { return password.getValue(); }
    public void setPassword(String password) { this.password.setValue(password); }
    public StringProperty passwordProperty() { return password; }

    public String getFullName() { return fullName.getValue(); }
    public void setFullName(String fullName) { this.fullName.setValue(fullName); }
    public StringProperty FullNameProperty() { return fullName; }

    public String getEmail() { return email.getValue(); }
    public void setEmail(String email) { this.email.setValue(email); }
    public StringProperty emailProperty(){ return email; }

    public Integer getBalance() { return balance.getValue(); }
    public void setBalance(Integer balance) { this.balance.setValue(balance); }
    public IntegerProperty balanceProperty(){ return balance; }

    public LocalDate getDateOfBirth() { return dateOfBirth; }
    public void setDateOfBirth(LocalDate dateOfBirth) { this.dateOfBirth = dateOfBirth; }
}
