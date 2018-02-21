package com.wyrzel.biblioteka.controller;

import com.wyrzel.biblioteka.model.Rent;
import com.wyrzel.biblioteka.model.User;
import com.wyrzel.biblioteka.service.Rent.RentServiceImpl;
import com.wyrzel.biblioteka.service.User.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
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

    @Autowired
    private RentServiceImpl rentService;

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
    public ModelAndView getUser(Principal principal) {
        ModelAndView modelAndView = new ModelAndView();
        User user= userService.findByEmail(principal.getName());
        modelAndView.addObject("user",user);

        List<Rent> userRents=rentService.findRentsByUser(user);
        System.out.println(user.getFirstName());
        modelAndView.addObject("userRents", userRents);
        modelAndView.setViewName("profile");

        return modelAndView;
    }
}

