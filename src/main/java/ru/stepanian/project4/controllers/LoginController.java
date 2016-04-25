package ru.stepanian.project4.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by Stepanian on 24.04.2016.
 */

@Controller
public class LoginController {

    @RequestMapping(value = "/auth", method = RequestMethod.GET)
    public String loginForm() {
        return "login";
    }

    /*@RequestMapping(value = "/registerForm", method = RequestMethod.GET)
    public String registerForm(ModelMap model) {
        model.addAttribute("userDto", new UserDto());
        return "register";
    }

    @RequestMapping(value = "/register", method = RequestMethod.POST)
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
