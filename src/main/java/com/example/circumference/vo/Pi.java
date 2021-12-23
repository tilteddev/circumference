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
}
