package com.github.jntakpe.battlecode.y2014.numberandletters;

import java.util.stream.IntStream;

public class SmallestIntegerJava8 {

    public static void main(String[] args) {
        Integer x = 4;
        IntStream.rangeClosed(x, Integer.MAX_VALUE).filter(it -> isAllRangeDivisible(it, x)).findFirst().getAsInt();
    }

    private static Boolean isAllRangeDivisible(Integer searchedValue, Integer endRange) {
        return IntStream.rangeClosed(2, endRange).noneMatch(it -> !isDivisible(searchedValue, it));
    }

    private static Boolean isDivisible(Integer numerator, Integer denominator) {
        return numerator % denominator == 0;
    }

}
