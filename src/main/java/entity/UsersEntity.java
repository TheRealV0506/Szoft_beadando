package entity;

import jakarta.persistence.*;

import java.sql.Date;
import java.time.LocalDate;
import java.util.Objects;

@Entity
@Table(name = "users", schema = "CasinoUsers")
public class UsersEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private int id;
    @Basic
    @Column(name = "fullName")
    private String fullName;
    @Basic
    @Column(name = "username")
    private String username;
    @Basic
    @Column(name = "pword")
    private String pword;
    @Basic
    @Column(name = "email")
    private String email;
    @Basic
    @Column(name = "balance")
    private Integer balance;
    @Basic
    @Column(name = "dateOfBirth")
    private Date dateOfBirth;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPword() {
        return pword;
    }

    public void setPword(String pword) {
        this.pword = pword;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getBalance() {
        return balance;
    }

    public void setBalance(Integer balance) {
        this.balance = balance;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }
/*
    public UsersEntity(String username, String fullName, String email, LocalDate dateOfBirth, String password, Integer balance) {
        this.setUsername(username);
        this.setFullName(fullName);
        this.setEmail(email);
        this.setDateOfBirth(Date.valueOf(dateOfBirth));
        this.setPword(password);
        this.setBalance(balance);
    }

    public UsersEntity(String username, String fullName, String email, LocalDate dateOfBirth, String password) {
        this.setUsername(username);
        this.setFullName(fullName);
        this.setEmail(email);
        this.setDateOfBirth(Date.valueOf(dateOfBirth));
        this.setPword(password);
        this.setBalance(10000);
    }
    public UsersEntity(String username, String fullName, String email, String password) {
        this.setUsername(username);
        this.setFullName(fullName);
        this.setEmail(email);
        this.setDateOfBirth(Date.valueOf(LocalDate.now()));
        this.setPword(password);
        this.setBalance(10000);
    }*/
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UsersEntity that = (UsersEntity) o;
        return id == that.id && Objects.equals(fullName, that.fullName) && Objects.equals(username, that.username) && Objects.equals(pword, that.pword) && Objects.equals(email, that.email) && Objects.equals(balance, that.balance) && Objects.equals(dateOfBirth, that.dateOfBirth);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, fullName, username, pword, email, balance, dateOfBirth);
    }
}
