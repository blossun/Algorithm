package dev.solar.programmers;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class N60058Test {

    N60058 n60058 = new N60058();

    @Test
    void case01() {
        String p = "(()())()";
        String expected = "(()())()";
        String actual = n60058.solution(p);
        assertEquals(expected, actual);
    }

    @Test
    void case02() {
        String p = ")(";
        String expected = "()";
        String actual = n60058.solution(p);
        assertEquals(expected, actual);
    }

    @Test
    void case03() {
        String p = "()))((()";
        String expected = "()(())()";
        String actual = n60058.solution(p);
        assertEquals(expected, actual);
    }
}
