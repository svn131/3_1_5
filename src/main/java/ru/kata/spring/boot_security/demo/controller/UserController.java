package ru.kata.spring.boot_security.demo.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.kata.spring.boot_security.demo.model.User;
import ru.kata.spring.boot_security.demo.service.UserService;
import ru.kata.spring.boot_security.demo.service.UserServiceImp;

import java.security.Principal;


@Controller
@RequestMapping("/user")
public class UserController {
    private final UserServiceImp userService;
@Autowired
    public UserController(UserServiceImp userService) {
        this.userService = userService;
    }
@GetMapping()
    public String getUser(Model model, Principal principal) {
    System.out.println("======================================================="+principal.getName());
    System.out.println("11111111111111111111111111111111111111111111111111111111111111");
        User user = (User) userService.loadUserByEmail(principal.getName());
        model.addAttribute("user", user);
        return "user_page";
    }


    }

