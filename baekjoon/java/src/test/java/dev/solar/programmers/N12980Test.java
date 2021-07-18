package dev.solar.programmers;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class N12980Test {
    N12980 n12980 = new N12980();

    @Test
    void case01() {
        int expected = 2;
        int actual = n12980.solution(5);
        assertEquals(expected, actual);
    }
}
