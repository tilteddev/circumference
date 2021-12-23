package com.example.circumference.services;

import com.example.circumference.vo.Pi;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

public class PiCalculationServiceTests {

    private PiCalculationService piCalculationService = new PiCalculationService();

    @Test
    public void most_accurate_value_for_n_digits() {
        Pi expectedValue = new Pi();

        // calculate 3 digits of pi
        this.piCalculationService.calculatePINthDigits( 3 );
        expectedValue.setCurrentKnownPi( BigDecimal.valueOf( 3.14 ) );
        assert this.piCalculationService.getMostAccuratePiValue().equals( expectedValue );

        // calculate 16 digits of pi
        this.piCalculationService.calculatePINthDigits( 16 );
        expectedValue.setCurrentKnownPi( BigDecimal.valueOf( Math.PI ) );
        assert this.piCalculationService.getMostAccuratePiValue().equals( expectedValue );

        // calculate 30 digits of pi - this is only to test that it is able to return more decimal precision
        this.piCalculationService.calculatePINthDigits( 30 );
        expectedValue.setCurrentKnownPi( new BigDecimal( "3.14159265358979323846264338327")  );
        assert this.piCalculationService.getMostAccuratePiValue().equals( expectedValue );
    }
}
