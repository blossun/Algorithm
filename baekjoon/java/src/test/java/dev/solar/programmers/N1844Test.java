package dev.solar.programmers;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class N1844Test {
    N1844 n1844 = new N1844();

    @Test
    void case01() {
        int[][] maps = {{1,0,1,1,1},{1,0,1,0,1},{1,0,1,1,1},{1,1,1,0,1},{0,0,0,0,1}};
        int actual = n1844.solution(maps);
        int expected = 11;
        assertEquals(expected, actual);
    }
}
