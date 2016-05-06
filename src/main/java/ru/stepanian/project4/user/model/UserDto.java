package ru.stepanian.project4.user.model;


import org.springframework.stereotype.Component;
import ru.stepanian.project4.user.validation.PasswordMatches;
import ru.stepanian.project4.user.validation.ValidEmail;
import ru.stepanian.project4.user.validation.ValidPassword;

import javax.validation.constraints.Size;


/**
 * Created by Stepanian on 25.04.2016.
 */

/* DTO - Data Transfer Object */
@PasswordMatches
@Component
public class UserDto {

    @Size(min = 1, max = 50, message = "{firstNameSize}")
    private String firstName;

    @Size(min = 1, max = 50, message = "{lastNameSize}")
    private String lastName;

    @Size(min = 1, max = 50, message = "{loginSize}")
    private String login;

    @ValidEmail
    @Size(max = 100)
    private String email;

    @ValidPassword
    private String password;
    private String matchingPassword;

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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getMatchingPassword() {
        return matchingPassword;
    }

    public void setMatchingPassword(String matchingPassword) {
        this.matchingPassword = matchingPassword;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
