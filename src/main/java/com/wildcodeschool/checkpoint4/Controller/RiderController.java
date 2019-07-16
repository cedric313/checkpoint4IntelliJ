package com.wildcodeschool.checkpoint4.Controller;

import com.wildcodeschool.checkpoint4.Entity.Rider;
import com.wildcodeschool.checkpoint4.Repository.RiderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

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


}
