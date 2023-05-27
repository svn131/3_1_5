package ru.kata.spring.boot_security.demo.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.kata.spring.boot_security.demo.model.User;
import ru.kata.spring.boot_security.demo.repository.RoleRepository;
import ru.kata.spring.boot_security.demo.service.UserService;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


//@RestController
//@RequestMapping("api/admin")
//public class AdminRESTController {
//    private final UserService userService;
//    private final RoleRepository roleRepository;
//
//    @Autowired
//    public AdminRESTController(UserService userService, RoleRepository roleRepository) {
//        this.userService = userService;
//        this.roleRepository = roleRepository;
//    }
@RestController
@RequestMapping("api/admin")
public class AdminRESTController {
    private final UserService userService;
    private final RoleRepository roleRepository;
    private final ObjectMapper objectMapper;

    @Autowired
    public AdminRESTController(UserService userService, RoleRepository roleRepository, ObjectMapper objectMapper) {
        this.userService = userService;
        this.roleRepository = roleRepository;
        this.objectMapper = objectMapper;

        this.objectMapper.configure(SerializationFeature.FAIL_ON_EMPTY_BEANS, false);
    }


    @GetMapping()
    public ResponseEntity<List<User>> getAllUsers() {
        List<User> users = userService.getListOfUsers();
        return ResponseEntity.ok(users);
    }

    //    @PostMapping()
//    public String createUser(@ModelAttribute("user") User user) {
//        userService.saveUser(user);
//        return "redirect:/admin";
//    }

    @PostMapping()
    public ResponseEntity<User> createUser(@RequestBody User user) {
        userService.saveUser(user);
        return ResponseEntity.ok(user);
    }

//
//    @GetMapping("/{id}/edit")
//    public String editUser(Model model, @PathVariable("id") Long id) {
//        model.addAttribute("roles", roleRepository.findAll());
//        model.addAttribute("user", userService.getUserById(id));
//        return "/edit";
//    }

    //
    @GetMapping("/{id}/edit")
    public ResponseEntity<Map<String, Object>> editUser(@PathVariable("id") Long id) {
        Map<String, Object> userMap = new HashMap<>();

        userMap.put("roles", roleRepository.findAll());
        userMap.put("user", userService.getUserById(id));

        return ResponseEntity.ok(userMap);
    }


//
//    @PatchMapping("/{id}")
//    public String update(@ModelAttribute("user") User user, @PathVariable("id") Long id) {
//        userService.saveUser(user);
//        return "redirect:/admin";
//    }


    @PostMapping("/{id}")
    public ResponseEntity<User> update(@RequestBody User user) {
        userService.saveUser(user);
        return ResponseEntity.ok().build();
    }
//
//    @DeleteMapping("/{id}")
//    public String delete(@PathVariable("id") Long id) {
//        userService.deleteUser(id);
//        return "redirect:/admin";
//    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") Long id) {
        try {
            userService.deleteUser(id);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }


    }
}