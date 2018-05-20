package edu.hacettepe.DAO;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "COFFEEUSER")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class User implements Serializable {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String username;
    private String password;
    private boolean enabled;
    private String name;
    private String surname;
    private String role;
    private String address;


    public User(int id, String username, String password, String name, String surname, String role, String address) {
        this.setId(id);
        this.setUsername(username);
        this.setPassword(password);
        this.setName(name);
        this.setSurname(surname);
        this.setRole(role);
        this.setAddress(address);
    }

    public User(){}

    public User(String username, String password, String name, String surname, String role) {
        this.setUsername(username);
        this.setPassword(password);
        this.setName(name);
        this.setSurname(surname);
        this.setRole(role);
    }

    public int getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getRole() {return role;}

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public String getAddress() {
        return address;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }
}
