package dev.solar.codingtest;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class OliveYoung02Test {
    OliveYoung02 oliveYoung02 = new OliveYoung02();

    @Test
    void case01() {
        String[] subway = {"1 2 3 4 5 6 7 8","2 11","0 11 10","3 17 19 12 13 9 14 15 10","20 2 21"};
        int start = 1;
        int end = 9;
        int expected = 1;
        int actual = oliveYoung02.solution(subway, start, end);
        assertEquals(expected, actual);
    }
}
