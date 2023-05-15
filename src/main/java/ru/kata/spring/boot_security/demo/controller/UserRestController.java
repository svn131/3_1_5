package ru.kata.spring.boot_security.demo.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.*;
import ru.kata.spring.boot_security.demo.model.User;
import ru.kata.spring.boot_security.demo.service.UserService;

import java.security.Principal;


@RestController
@RequestMapping("/userProfile")
public class UserRestController {
    private final UserService userService;

    @Autowired
    public UserRestController(UserService userService) {
        this.userService = userService;
    }

    @ResponseStatus
    @GetMapping()
    public ResponseEntity<User> getUser(Principal principal) {

        System.out.println("33333333333333333333333333333333333333333333333333333333333333333333333");
        User user = userService.findByEmail(principal.getName());
        return ResponseEntity.ok(user);
    }

}