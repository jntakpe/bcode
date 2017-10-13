package com.github.jntakpe.battlecode.y2014.numberandletters

import org.assertj.core.api.Assertions.assertThat
import org.junit.Test

class NumbersAndLettersTest {

    val numbersAndLetters = NumbersAndLetters()

    @Test
    fun `should read dictionary`() {
        assertThat(numbersAndLetters.readDictionary()).isNotEmpty
        assertThat(numbersAndLetters.readDictionary()).contains("bonjour")
        assertThat(numbersAndLetters.readDictionary()).hasSize(336531)
    }

    @Test
    fun `should contain one letter`() {
        assertThat(NumbersAndLetters("azet").containsAllLetters("test")).isTrue()
    }

    @Test
    fun `should contain multiple letters`() {
        assertThat(NumbersAndLetters("titi").containsAllLetters("test")).isTrue()
    }

    @Test
    fun `should not contain any letter`() {
        assertThat(NumbersAndLetters("titi").containsAllLetters("haha")).isFalse()
    }

    @Test
    fun `should count one occurrence`() {
        assertThat(NumbersAndLetters("abc").score("paris").score).isEqualTo(1)
    }

    @Test
    fun `should count one occurrence couple times`() {
        assertThat(NumbersAndLetters("titi").score("toto").score).isEqualTo(2)
    }

    @Test
    fun `should count multiple occurrences`() {
        assertThat(NumbersAndLetters("hello").score("heho").score).isEqualTo(3)
    }

    @Test
    fun `should not find any occurrence`() {
        assertThat(NumbersAndLetters("toto").score("haha").score).isEqualTo(0)
    }

}