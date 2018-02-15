package com.wyrzel.biblioteka.controller;

import com.wyrzel.biblioteka.model.User;
import com.wyrzel.biblioteka.service.User.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.security.Principal;
import java.util.List;

@Controller
public class UserController {

    @Autowired
    private UserServiceImpl userService;

    @RequestMapping(value = "/users", method = RequestMethod.GET)
    public String getUsersPage(Model model) {
        List<User> userList = userService.getAllUsers();

        model.addAttribute("userList", userList);

        return "users";
    }

    @RequestMapping(value = "/user/delete/{id}", method = RequestMethod.POST)
    public String deleteUser(@PathVariable Long id) {

        userService.deleteUser(id);
        return "redirect:/users";

    }

    @RequestMapping(value = "/profile",method = RequestMethod.GET)
    public ModelAndView getUser(Principal principal, ModelAndView modelAndView) {
        User user= userService.findByEmail(principal.getName());
      //  ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("user",user);
        modelAndView.setViewName("profile");
        System.out.println(user.getFirstName());
        return modelAndView;
    }
}

