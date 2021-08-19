package dev.solar.programmers;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class N42627Test {
    N42627 n42627 = new N42627();

    @Test
    void case01() {
        int[][] jobs = {{0, 3}, {1, 9}, {2, 6}};
        int expected = 9;
        int actual = n42627.solution(jobs);
        assertEquals(expected, actual);
    }

    @Test
    void case02() {
        int[][] jobs = {{1, 9}, {2, 6}, {0, 3}};
        int expected = 9;
        int actual = n42627.solution(jobs);
        assertEquals(expected, actual);
    }

    @Test
    void case03() {
        int[][] jobs = {{0, 3}, {4, 3}, {5, 2}, {7, 2}};
        int expected = 3;
        int actual = n42627.solution(jobs);
        assertEquals(expected, actual);
    }

    @Test
    void case04() {
        int[][] jobs = {{0, 10}, {4, 10}, {15, 2}, {5, 11}};
        int expected = 15;
        int actual = n42627.solution(jobs);
        assertEquals(expected, actual);
    }

    @Test
    void case05() {
        int[][] jobs = {{24, 10}, {18, 39}, {34, 20}, {37, 5}, {47, 22}, {20, 47}, {15, 34}, {15, 2}, {35, 43}, {26, 1}};
        int expected = 74;
        int actual = n42627.solution(jobs);
        assertEquals(expected, actual);
    }

    @Test
    void case06() {
        int[][] jobs = {{24, 10}, {28, 39}, {43, 20}, {37, 5}, {47, 22}, {20, 47}, {15, 34}, {15, 2}, {35, 43}, {26, 1}};
        int expected = 72;
        int actual = n42627.solution(jobs);
        assertEquals(expected, actual);
    }
}
