package ru.kata.spring.boot_security.demo.service;



import org.springframework.security.core.userdetails.UserDetailsService;
import ru.kata.spring.boot_security.demo.model.User;

import javax.transaction.Transactional;
import java.util.List;


public interface UserService extends UserDetailsService {
    User getUserById(Long id) ;

    List<User> getListOfUsers();

    void deleteUser(Long id);

//    User findByUsername(String email);


    void saveUser(User user);

    User findByEmail(String email);



}
