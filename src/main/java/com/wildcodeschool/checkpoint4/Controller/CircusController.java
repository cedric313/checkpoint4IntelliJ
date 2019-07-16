package com.wildcodeschool.checkpoint4.Controller;

import com.wildcodeschool.checkpoint4.Entity.Circus;
import com.wildcodeschool.checkpoint4.Repository.CircusRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CircusController {

    @Autowired
    private CircusRepository circusRepository;

    @PostMapping("/circus")
    public Circus create(@RequestBody Circus circus){
        return circusRepository.save(circus);
    }

    @GetMapping("/circus")
    public List<Circus> read() {
        return circusRepository.findAll();
    }
}
