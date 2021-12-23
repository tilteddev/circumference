package com.example.circumference.services;

import com.example.circumference.vo.Pi;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class PiCalculationService {

    private Pi mostAccuratePi = new Pi();

    public Pi getMostAccuratePiValue () {
        return this.mostAccuratePi;
    }

    public void calculatePINthDigits( int nthDigits ) {
        // TODO do an actual calculation and store the most accurate value
    }
}
