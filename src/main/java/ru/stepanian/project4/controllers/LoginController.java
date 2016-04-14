package ru.stepanian.project4.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by 1 on 08.04.2016.
 */

@Controller
public class LoginController {


    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String login() {
        return "login";
    }

}
	



