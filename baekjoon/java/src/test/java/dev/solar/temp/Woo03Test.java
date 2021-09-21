package dev.solar.temp;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Woo03Test {
    Woo03 woo03 = new Woo03();

    @Test
    void case01() {
        String word = "I love you";
        String expected = "R olev blf";
        String actual = woo03.solution(word);
        assertEquals(expected, actual);
    }

    @Test
    void case02() {
        String word = "ABCDEFGHIJKLMNOPQRSTUVWXYZ abcdefghijklmnopqrstuvwxyz";
        String expected = "ZYXWVUTSRQPONMLKJIHGFEDCBA zyxwvutsrqponmlkjihgfedcba";
        String actual = woo03.solution(word);
        assertEquals(expected, actual);
    }
}
