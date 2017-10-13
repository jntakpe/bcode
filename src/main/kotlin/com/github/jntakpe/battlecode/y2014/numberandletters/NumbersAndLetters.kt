package com.github.jntakpe.battlecode.y2014.numberandletters

import org.apache.commons.lang3.StringUtils.countMatches
import org.apache.commons.lang3.StringUtils.stripAccents
import java.nio.charset.StandardCharsets.ISO_8859_1
import java.nio.file.Files
import java.nio.file.Paths
import kotlin.text.isNotBlank

class NumbersAndLetters(private val letters: String = "") {

    fun readDictionary() = Files.readAllLines(Paths.get(javaClass.classLoader.getResource("dictionary.txt").toURI()), ISO_8859_1)

    fun containsAllLetters(word: String) = normalize(word).filter { !letters.contains(it) }.isEmpty()

    fun containsAllOccurrences(word: String) = word.filter { letterScore(it) < wordScore(word, it) }.isEmpty()

    fun score(word: String) = WordScore(word, letters.toSet().map { minOf(letterScore(it), wordScore(word, it)) }.sum())

    private fun normalize(word: String) = stripAccents(word).replace("[^a-zA-Z0-9]".toRegex(), "").toLowerCase()

    private fun letterScore(letter: Char) = countMatches(letters, letter)

    private fun wordScore(word: String, letter: Char) = countMatches(normalize(word), letter)

}

data class WordScore(val word: String, val score: Int)

fun main(args: Array<String>) {
    val numbersAndLetters = NumbersAndLetters("aetdurejlm")
    val maxWords = numbersAndLetters.readDictionary()
            .filter(String::isNotBlank)
            .filter(numbersAndLetters::containsAllLetters)
            .filter(numbersAndLetters::containsAllOccurrences)
            .map(numbersAndLetters::score)
            .groupBy({ it.score }, { it.word })
            .maxBy { it.key }
            ?.value
    println(maxWords)
}
