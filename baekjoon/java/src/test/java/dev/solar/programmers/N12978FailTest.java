package dev.solar.programmers;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class N12978FailTest {
    N12978Fail n12978Fail = new N12978Fail();

    @Test
    void case01() {
        int N = 5;
        int[][] road = {{1,2,1},{2,3,3},{5,2,2},{1,4,2},{5,3,1},{5,4,2}};
        int K = 3;
        int expected = 4;
        int actual = n12978Fail.solution(N, road, K);
        assertEquals(expected, actual);
    }

    @Test
    void case02() {
        int N = 6;
        int[][] road = {{1,2,1},{1,3,2},{2,3,2},{3,4,3},{3,5,2},{3,5,3},{5,6,1}};
        int K = 4;
        int expected = 4;
        int actual = n12978Fail.solution(N, road, K);
        assertEquals(expected, actual);
    }
}
