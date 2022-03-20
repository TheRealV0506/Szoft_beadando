package hu.unideb.inf.model;

import java.time.LocalDate;

public class Model {
    private User user;

    public Model() {
        this.user = new User("Nagy József", "Kissné Erzsébet", "Debrecen", LocalDate.of(1991,12,03), "password", 1000);
    }

    public User getUser() {
        return user;
    }
}
