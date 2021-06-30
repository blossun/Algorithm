package dev.solar.programmers;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class N60057Test {

    N60057 n60057 = new N60057();

    @Test
    void case01() {
        String s = "aabbaccc";
        int expected = 7;
        int actual = n60057.solution(s);
        assertEquals(expected, actual);
    }

    @Test
    void case02() {
        String s = "ababcdcdababcdcd";
        int expected = 9;
        int actual = n60057.solution(s);
        assertEquals(expected, actual);
    }

    @Test
    void case03() {
        String s = "abcabcdede";
        int expected = 8;
        int actual = n60057.solution(s);
        assertEquals(expected, actual);
    }

    @Test
    void case04() {
        String s = "abcabcabcabcdededededede";
        int expected = 14;
        int actual = n60057.solution(s);
        assertEquals(expected, actual);
    }

    @Test
    void case05() {
        String s = "xababcdcdababcdcd";
        int expected = 17;
        int actual = n60057.solution(s);
        assertEquals(expected, actual);
    }
}
