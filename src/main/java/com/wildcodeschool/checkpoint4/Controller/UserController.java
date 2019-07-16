package com.wildcodeschool.checkpoint4.Controller;

import com.wildcodeschool.checkpoint4.Entity.User;
import com.wildcodeschool.checkpoint4.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @PostMapping("/user")
    public User create(@RequestBody User user) {
        return userRepository.save(user);
    }

    @GetMapping("/user/{idUser}")
    public User read(@PathVariable Long idUser) {
        return userRepository.findById(idUser).get();
    }

}
