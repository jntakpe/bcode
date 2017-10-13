package com.github.jntakpe.battlecode.y2014.numberandletters;

public class SmallestIntegerJava7 {

    public static void main(String[] args) {
        Integer x = 4;
        System.out.println(resolve(x));
    }

    private static Boolean isDivisible(Integer numerator, Integer denominator) {
        return numerator % denominator == 0;
    }

    private static Integer resolve(Integer x) {
        Integer value = 0;
        for (int i = x; i < Integer.MAX_VALUE; i++) {
            Integer j = 2;
            while (isDivisible(i, j)) {
                j++;
            }
            if (j - 1 == x) {
                value = i;
                break;
            }
        }
        return value;
    }

}
