package com.example.circumference.controller;

import com.example.circumference.services.PiCalculationService;
import com.example.circumference.vo.Pi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value="/api/v1/pi")
public class PiRESTController {

    @Autowired
    PiCalculationService piCalculationService;

    @GetMapping
    public ResponseEntity<Pi> getCurrentKnownPi() {
        Pi currentKnownPi = piCalculationService.getMostAccuratePiValue();
        return new ResponseEntity<Pi>( currentKnownPi, HttpStatus.OK );
    }
}
