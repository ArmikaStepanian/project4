package ru.stepanian.project4.entities;

import javax.persistence.*;

/**
 * Created by Stepanian on 23.04.2016.
 */

@Entity
@Table (name = "USERS")
public class User {

    @Column
    private String firstName;

    @Column
    private String lastName;

    @Id
    @Column (name = "USERNAME")
    private String login;

    @Column
    private String email;

    @Column
    private String password;

    @Column
    private Boolean enabled = true;

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Boolean getEnabled() {
        return enabled;
    }

    public void setEnabled(Boolean enabled) {
        this.enabled = enabled;
    }
}
