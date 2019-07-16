package com.wildcodeschool.checkpoint4.Controller;

import com.wildcodeschool.checkpoint4.Entity.Rider;
import com.wildcodeschool.checkpoint4.Repository.RiderRepository;
import com.wildcodeschool.checkpoint4.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class RiderController {

    @Autowired
    private RiderRepository riderRepository;

    @PostMapping("/rider")
    public Rider create(@RequestBody Rider rider) {
        return riderRepository.save(rider);
    }

    @GetMapping("/rider")
    public List<Rider> read() {
        return riderRepository.findAll();
    }

    @GetMapping("/rider/{idRider}")
    public Rider readRiderById(@PathVariable Long idRider) {
        return riderRepository.findById(idRider).get();
    }

}
