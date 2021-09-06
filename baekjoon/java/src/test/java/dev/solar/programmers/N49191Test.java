package dev.solar.programmers;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class N49191Test {
    N49191 n49191 = new N49191();

    @Test
    void case01() {
        int n = 5;
        int[][] results = {{4, 3}, {4, 2}, {3, 2}, {1, 2}, {2, 5}};
        assertEquals(2, n49191.solution(n, results));
    }
}
