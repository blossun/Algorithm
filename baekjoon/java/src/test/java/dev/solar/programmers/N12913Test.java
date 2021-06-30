package dev.solar.programmers;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class N12913Test {

    N12913 n12913 = new N12913();

    @Test
    void case01() {
        int[][] land = {{1,2,3,5},{5,6,7,8},{4,3,2,1}};
        int expected = 16;
        int actual = n12913.solution(land);
        assertEquals(expected, actual);
    }
}
