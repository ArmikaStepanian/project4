package ru.stepanian.project4.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import ru.stepanian.project4.service.ProjectService;
import ru.stepanian.project4.model.UserDto;

/**
 * Created by Stepanian on 25.04.2016.
 */

@Controller
public class RegisterController {

    @Autowired
    private ProjectService projectService;

    @RequestMapping(value = "/registerForm", method = RequestMethod.GET)
    public String registerForm(ModelMap model) {
        model.addAttribute("userDto", new UserDto());
        return "register";
    }

    /*@RequestMapping(value = "/register", method = RequestMethod.POST)
    public String registerUser(@ModelAttribute("user") User user,
                               @RequestParam(value = "password") String password,
                               @RequestParam(value = "username") String username) {

        BCryptPasswordEncoder bcrypt = new BCryptPasswordEncoder(4);
        String str = bcrypt.encode(password);
        user.setPassword(str);
        productService.addUser(user);

        GroupMember groupMember = new GroupMember();
        groupMember.setUsername(username);
        productService.addGroupMember(groupMember);

        return "redirect:/";
    }*/

}
