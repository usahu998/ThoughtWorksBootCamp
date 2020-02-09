package com.thoughtworks.calculatepower;

public class CalculatePower {

    public static Integer computePower(Integer base, Integer exponent) {
        Integer product = 1;
        for (int i = 1; i <= exponent; i++) {
           product = product * base;
        }
        return product;
    }
}
