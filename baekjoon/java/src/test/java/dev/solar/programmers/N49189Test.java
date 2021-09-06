package dev.solar.programmers;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class N49189Test {
    N49189 n49189 = new N49189();

    @Test
    void case01() {
        int n = 6;
        int[][] vertext = {{3, 6}, {4, 3}, {3, 2}, {1, 3}, {1, 2}, {2, 4}, {5, 2}};
        int expected = 3;
        assertEquals(expected, n49189.solution(n, vertext));
    }
}
