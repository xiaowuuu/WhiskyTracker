package com.codeclan.example.WhiskyTracker.controllers;

import com.codeclan.example.WhiskyTracker.models.Whisky;
import com.codeclan.example.WhiskyTracker.repositories.WhiskyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class WhiskyController {
    @Autowired
    WhiskyRepository whiskyRepository;
    //Get all the whisky from a particular region
    @GetMapping(value="/whiskies/{region}")
    public ResponseEntity<List<Whisky>> getWhiskyByRegion(@PathVariable String region){
        return new ResponseEntity<>(whiskyRepository.findByDistilleryRegion(region), HttpStatus.OK);
    }
    //Get all the whiskies for a particular year
    @GetMapping(value="/whisky")
    public ResponseEntity<List<Whisky>> getWhiskyByYear(@RequestParam(
            name = "year", required = false) Integer year){
        if (year == null) {
            return new ResponseEntity<>(whiskyRepository.findAll(), HttpStatus.OK);
        }
        else{
            return new ResponseEntity<>(whiskyRepository.findWhiskiesByYear(year), HttpStatus.OK);
        }
    }
    @GetMapping(value = "/whisky/find")
    public ResponseEntity<List<Whisky>> getWhiskyByYearAndDistillery(@RequestParam(
            name = "age", required = false) Integer age, @RequestParam(
                    name = "distillery", required = false) Long id) {
        if (age == null) {
            return new ResponseEntity<>(whiskyRepository.findAll(), HttpStatus.OK);
        }else {
            return new ResponseEntity<>(whiskyRepository.findByAgeAndDistilleryId(age, id), HttpStatus.OK);
        }
    }
    //Get all the whisky from a particular distillery that's a specific age
    //localhost:8080/whisky?age=11?distillery=highland

}
