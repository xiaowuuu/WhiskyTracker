package com.codeclan.example.WhiskyTracker.controllers;

import com.codeclan.example.WhiskyTracker.models.Distillery;
import com.codeclan.example.WhiskyTracker.repositories.DistilleryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class DistilleryController {
    @Autowired
    DistilleryRepository distilleryRepository;
    //Get all the distilleries for a particular region
    @GetMapping(value="/distilleries")
    public ResponseEntity<List<Distillery>> getDistilleriesByRegion(@RequestParam(
            name = "region", required = false) String region){
        if(region == null) {
            return new ResponseEntity<>(distilleryRepository.findAll(), HttpStatus.OK);
        }
        else {
            return new ResponseEntity<>(distilleryRepository.findByRegion(region), HttpStatus.OK);
        }
    }
    //Get distilleries that have whiskies that are 12 years old
    @GetMapping(value="/distilleries/{age}")
    public ResponseEntity<List<Distillery>> getDistilleriesByAge(@PathVariable Integer age){
        return new ResponseEntity<>(distilleryRepository.findByWhiskiesAge(age), HttpStatus.OK);
    }

}
