package dev.solar.codingtest;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Toss02Test {
    Toss02 t = new Toss02();

    @Test
    void case01() {
        int servers = 2;
        boolean sticky = true;
        int[] requests = {1,1,2,2};

        int[][] result = t.solution(servers, sticky, requests);
        int[][] expected = {{1, 1}, {2, 2}};
        assertArrayEquals(expected, result);
    }

    @Test
    void case02() {
        int servers = 2;
        boolean sticky = true;
        int[] requests = {1,2,2,3,4,1};

        int[][] result = t.solution(servers, sticky, requests);
        int[][] expected = {{1, 3, 1}, {2, 2, 4}};
        assertArrayEquals(expected, result);
    }


    @Test
    void case03() {
        int servers = 3;
        boolean sticky = true;
        int[] requests = {1, 3, 1, 2, 3, 4};

        int[][] result = t.solution(servers, sticky, requests);
        int[][] expected = {{1, 1}, {3, 3}, {2, 4}};
        assertArrayEquals(expected, result);
    }
}
