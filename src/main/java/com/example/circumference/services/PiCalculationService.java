package com.example.circumference.services;

import com.example.circumference.vo.Pi;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;

@Service
public class PiCalculationService {
    // Constants
    private final BigDecimal TWO = new BigDecimal( 2 );

    private final BigDecimal FOUR = new BigDecimal( 4 );

    private final BigDecimal FIVE = new BigDecimal( 5 );

    private final BigDecimal SIX = new BigDecimal( 6 );

    private final BigDecimal EIGHT = new BigDecimal( 8 );

    private final BigDecimal SIXTEEN = new BigDecimal( 16 );

    // variable
    private Pi mostAccuratePi = new Pi();

    public Pi getMostAccuratePiValue() {
        return this.mostAccuratePi;
    }

    public void calculatePINthDigits( int nthDigits ) {
        int k = 0;

        BigDecimal pi = BigDecimal.ZERO;
        BigDecimal fractions;

        // set digits precision to avoid precision loss during calculation
        MathContext mathContext = new MathContext( nthDigits );

        while ( k < nthDigits ) {
            // Sum of k to nthDigits
            fractions = FOUR.divide( ( EIGHT.multiply( BigDecimal.valueOf( k ) ).add( BigDecimal.ONE ) ), mathContext ) // 4 / 8k + 1
                            .subtract( TWO.divide( ( EIGHT.multiply( BigDecimal.valueOf( k ) ).add( FOUR ) ), mathContext ) ) // 2 / 8k + 4
                            .subtract( BigDecimal.ONE.divide( ( EIGHT.multiply( BigDecimal.valueOf( k ) ).add( FIVE ) ), mathContext ) ) // 1 / 8k + 5
                            .subtract( BigDecimal.ONE.divide( ( EIGHT.multiply( BigDecimal.valueOf( k ) ).add( SIX ) ), mathContext ) ); // 1 / 8k + 6

            pi = pi.add( BigDecimal.ONE.divide( SIXTEEN.pow( k ), mathContext ).multiply( fractions ) );

            // store the most accurate value
            this.mostAccuratePi.setCurrentKnownPi( pi.setScale( k, RoundingMode.DOWN ) );

            // set next iteration
            k++;
        }
    }
}
