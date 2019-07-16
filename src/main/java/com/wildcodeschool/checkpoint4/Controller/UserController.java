package com.wildcodeschool.checkpoint4.Controller;

import com.wildcodeschool.checkpoint4.Entity.Authentication;
import com.wildcodeschool.checkpoint4.Entity.Rider;
import com.wildcodeschool.checkpoint4.Entity.User;
import com.wildcodeschool.checkpoint4.Repository.RiderRepository;
import com.wildcodeschool.checkpoint4.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RiderRepository riderRepository;

    @PostMapping("/user")
    public User create(@RequestBody User user) {
        return userRepository.save(user);
    }

    @GetMapping("/user/{idUser}")
    public User read(@PathVariable Long idUser) {
        return userRepository.findById(idUser).get();
    }

    @PutMapping("/user/{userId}/{riderId}")
    public User addFavorite(@PathVariable Long userId,
                            @PathVariable Long riderId) {
        User user = userRepository.findById(userId).get();
        Rider rider = riderRepository.findById(riderId).get();
        rider.getUsers().add(user);
        user.getRiders().add(rider);
        riderRepository.save(rider);
        return userRepository.save(user);
    }

    @PostMapping("/user/search")
    public Authentication search(@RequestBody User user) {
        Authentication authentication = new Authentication();
        User userFromDb = userRepository.findUserByEmail(user.getEmail());
        if (userFromDb == null) {
            authentication.setError("ERROR_EMAIL");
        } else if (!user.getPassword().equals(userFromDb.getPassword())) {
            authentication.setError("ERROR_PASSWORD");
        } else {
            authentication.setUser(userFromDb);
        }
        return authentication;
    }
}
