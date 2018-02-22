package com.wyrzel.biblioteka.controller;

import com.wyrzel.biblioteka.model.User;
import com.wyrzel.biblioteka.service.User.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;


@Controller
public class MainController {

    @Autowired
    UserService userService;

    @GetMapping(value="/working")
    public String MainPage(){
        return "working";
    }

    @GetMapping(value="/")
    public String MainPage1(){
        return "main";
    }

    @GetMapping(value="/login")
    public String LoginPage(){
        return "login";
    }

    @GetMapping(value = "/registration")
    public String getRegisterPage() {
        return "registration";
    }

    @RequestMapping(value = "/registration", method = RequestMethod.POST)
    public String register(@ModelAttribute User user) {

        if(userService.isEmailUnique(user.getEmail())) {
            ModelAndView modelAndView=new ModelAndView();
            return "registration";

        }
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        String password = encoder.encode(user.getPassword());
        user.setPassword(password);
        userService.save(user);

        return "redirect:/login";
    }


}