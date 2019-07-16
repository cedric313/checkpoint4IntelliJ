package com.wildcodeschool.checkpoint4.Controller;

import com.wildcodeschool.checkpoint4.Entity.Circus;
import com.wildcodeschool.checkpoint4.Entity.Rider;
import com.wildcodeschool.checkpoint4.Repository.CircusRepository;
import com.wildcodeschool.checkpoint4.Repository.RiderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CircusController {

    @Autowired
    private CircusRepository circusRepository;

    @Autowired
    private RiderRepository riderRepository;

    @PostMapping("/circus")
    public Circus create(@RequestBody Circus circus) {
        return circusRepository.save(circus);
    }

    @GetMapping("/circus")
    public List<Circus> read() {
        return circusRepository.findAll();
    }

    @GetMapping("/circus/{idCircus}")
    public Circus readCircusById(@PathVariable Long idCircus) {
        return circusRepository.findById(idCircus).get();
    }

    @PutMapping("/circus/{idCircus}/{riderId}")
    public Circus addRiderToEvent(@PathVariable Long idCircus,
                                  @PathVariable Long riderId) {
        Circus circus = circusRepository.findById(idCircus).get();
        Rider rider = riderRepository.findById(riderId).get();
        rider.getCircuses().add(circus);
        circus.getRiders().add(rider);
        riderRepository.save(rider);
        return circusRepository.save(circus);
    }
}
