package dev.solar.programmers;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class N43162Test {

    N43162 n43162 = new N43162();

    @Test
    void case01() {
        int[][] computers = {{1,1,0}, {1,1,0}, {0,0,1}};
        int n = 3;
        int expected = 2;
        int actual = n43162.solution(n, computers);
        assertEquals(expected, actual);
    }

    @Test
    void case02() {
        int[][] computers = {{1, 1, 0, 1}, {1, 1, 0, 0}, {0, 0, 1, 0}, {1, 0, 0, 1}};
        int n = 4;
        int expected = 2;
        int actual = n43162.solution(n, computers);
        assertEquals(expected, actual);
    }

    @Test
    void case03() {
        int[][] computers = {{1,0,1,0}, {0,1,0,1}, {1,0,1,0}, {0, 1, 0, 1}};
        int n = 4;
        int expected = 2;
        int actual = n43162.solution(n, computers);
        assertEquals(expected, actual);
    }
}
