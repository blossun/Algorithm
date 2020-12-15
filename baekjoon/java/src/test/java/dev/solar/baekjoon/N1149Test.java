package dev.solar.baekjoon;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class N1149Test {
    @Test
    void test1() {
        int[][] arr = {{26, 40, 83},
                {49, 60, 57},
                {13, 89, 99}};
        int expected = 96;
        int actual = N1149.solution(arr, arr.length);
        assertEquals(expected, actual);
    }


}
