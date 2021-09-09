package dev.solar.programmers.weekly;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class N05Test {
    N05 n05 = new N05();

    @Test
    void case01() {
        String word = "AAAAE";
        int expected = 6;
        assertEquals(expected, n05.solution(word));
    }
}
