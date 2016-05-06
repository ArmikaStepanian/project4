package ru.stepanian.project4.user.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import ru.stepanian.project4.entities.User;
import ru.stepanian.project4.service.ProjectService;
import ru.stepanian.project4.user.model.UserDto;

import javax.validation.Valid;

/**
 * Created by Stepanian on 25.04.2016.
 */

@Controller
public class RegisterController {

    @Autowired
    private ProjectService projectService;
    @Autowired
    private User user;
    @Autowired
    private UserDto userDto;

    @RequestMapping(value = "/registerForm", method = RequestMethod.GET)
    public String registerForm(ModelMap model) {
        model.addAttribute("userDto", userDto);
        return "register";
    }

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public String registerUser(@Valid @ModelAttribute("userDto") UserDto userDto,
                               BindingResult result) {

        if (!result.hasErrors()) {
            user = projectService.createNewUserAccount(userDto);
        }
        if (user == null) {
            result.rejectValue("login", "message.regError");
        }
        if (result.hasErrors()) {
            return "register";
        }
        else {
            projectService.saveCreatedNewUserAccount(user);
            projectService.saveGroupMember(userDto);
            return "redirect:/";
        }
    }
}
