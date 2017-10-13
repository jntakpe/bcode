package com.github.jntakpe.battlecode.y2014.numberandletters

fun main(args: Array<String>) {
    val x = 10
    println(IntRange(x, Int.MAX_VALUE).first { isAllRangeDivisible(it, x) })
}

fun isAllRangeDivisible(searchedValue: Int, endRange: Int) = (2..endRange).none { !isDivisible(searchedValue, it) }

fun isDivisible(numerator: Int, denominator: Int) = numerator % denominator == 0