package dev.solar.codingtest;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class NHN02Test {
    NHN02 nhn02 = new NHN02();

    @Test
    void case01() {
        int numOfRegin = 4;
        int numOfArrackableFrequency = 3;
        int[][] frequencies = {
                {6, 18, 16, 17, 2, 9, 19},
                {8, 2, 16, 3, 11, 6, 19, 15, 17},
                {5, 19, 1, 4, 17, 7},
                {6, 16, 3, 6, 19, 14, 12}
        };
        int actual = nhn02.solution(numOfRegin, numOfArrackableFrequency, frequencies);
        assertEquals(10, actual);

    }
}
