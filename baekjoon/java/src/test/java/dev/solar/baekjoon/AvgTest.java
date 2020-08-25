package dev.solar.baekjoon;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AvgTest {
    Avg avg = new Avg();

    @Test
    void test1() {
        int[] scores = {10, 65, 100, 30, 95};
        int expected = 68;
        int actual = avg.solv(scores);

        assertEquals(expected, actual);
    }
}
