package com.thoughtworks.calculatepower;

import org.testng.Assert;
import org.testng.annotations.Test;

public class TestCalculatePower {

    @Test
    void givenPowerCalculator_WhenBase2AndExponent2_thenShouldReturnCorrectValue()
    {
        int value=CalculatePower.computePower(2,2);
        Assert.assertEquals(4,value);
    }

    @Test
    void givenPowerCalculator_WhenBase2AndExponent0_thenShouldReturnCorrectValue()
    {
        int value=CalculatePower.computePower(2,0);
        Assert.assertEquals(1,value);
    }

    @Test
    void givenPowerCalculator_WhenBaseNegativeNumberAndExponent2_thenShouldReturnCorrectValue()
    {
        int value=CalculatePower.computePower(-2,2);
        Assert.assertEquals(4,value);
    }

    @Test
    void givenPowerCalculator_WhenBase2AndExponentNegativeNumber_thenShouldReturnCorrectValue()
    {
        int value=CalculatePower.computePower(2,-2);
        Assert.assertEquals(1,value);
    }

    @Test
    void givenPowerCalculator_WhenBase9999999AndExponent100_thenShouldReturnCorrectValue()
    {
        int value=CalculatePower.computePower(9999999,100);
        Assert.assertEquals(-239684095,value);
    }

    @Test
    void givenPowerCalculator_WhenBase0AndExponent5_thenShouldReturnCorrectValue()
    {
        int value=CalculatePower.computePower(0,5);
        Assert.assertEquals(0,value);
    }
}
