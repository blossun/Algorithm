package dev.solar.programmers;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class N12901Test {

    private N12901 S = new N12901();

    @Test
    void case1() {
        String expected = "TUE";
        assertEquals(expected, S.solution(5, 24));
    }

    @Test
    void case2() {
        String expected = "SAT";
        assertEquals(expected, S.solution(1, 2));
    }

    @Test
    void case3() {
        String expected = "SUN";
        assertEquals(expected, S.solution(1, 3));
    }

    @Test
    void case4() {
        String expected = "MON";
        assertEquals(expected, S.solution(1, 4));
    }
}
