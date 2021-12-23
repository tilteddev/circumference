package com.example.circumference.vo;

import java.math.BigDecimal;

public class Pi {
    BigDecimal currentKnownPi = BigDecimal.ZERO;

    public BigDecimal getCurrentKnownPi () {
        return currentKnownPi;
    }

    public void setCurrentKnownPi ( BigDecimal currentKnownPi ) {
        this.currentKnownPi = currentKnownPi;
    }

    @Override
    public boolean equals ( Object obj ) {

        if ( null == obj || !(obj instanceof Pi) ) return false;

        Pi objectToCompareWith = (Pi)obj;

        return objectToCompareWith.getCurrentKnownPi().equals( this.getCurrentKnownPi() );
    }
}
