package hu.unideb.inf.model;

import java.time.LocalDate;

public class Model {
    private Tag tag;

    public Model() {
        this.tag = new Tag("Nagy József", "Kissné Erzsébet", "Debrecen", LocalDate.of(1991,12,03));
    }

    public Tag getTag() {
        return tag;
    }
}
