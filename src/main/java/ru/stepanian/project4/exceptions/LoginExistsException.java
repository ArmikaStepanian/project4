package ru.stepanian.project4.exceptions;

/**
 * Created by Stepanian on 26.04.2016.
 */

@SuppressWarnings("serial")
public class LoginExistsException extends Throwable {

    public LoginExistsException(String message) {
        super(message);
    }

}
