package dev.solar.programmers;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class N12915Test {

    private N12915 S;

    @BeforeEach
    void setUp() {
        S = new N12915();
    }

    @Test
    void case1() {
        String[] strings = {"sun", "bed", "car"};
        int n = 1;

        String[] expected = {"car", "bed", "sun"};
        String[] result = S.solution(strings, n);
        assertArrayEquals(expected, result);
    }

}
