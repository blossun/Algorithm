package dev.solar.codingtest;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Woowa04Test {
    Woowa04 woowa04 = new Woowa04();

    @Test
    void case01() {
        int[] A = {1, 2, 4, 5};
        int[] B = {3, 3, 3, 3, 5};
        int expected = 5;
        int actual = woowa04.solution(A, B);
        assertEquals(expected, actual);
    }

    @Test
    void case02() {
        int[] A = {1, 2, 4, 5};
        int[] B = {3, 3, 3, 3, 3};
        int expected = -1;
        int actual = woowa04.solution(A, B);
        assertEquals(expected, actual);
    }

    @Test
    void case03() {
        int[] A = {1, 2, 3, 4, 5};
        int[] B = {3, 3, 3, 3, 3};
        int expected = 3;
        int actual = woowa04.solution(A, B);
        assertEquals(expected, actual);
    }

    @Test
    void case04() {
        int[] A = {1, 2, 4, 5};
        int[] B = {3, 3, 3, 3, 4};
        int expected = 4;
        int actual = woowa04.solution(A, B);
        assertEquals(expected, actual);
    }

    @Test
    void case05() {
        int[] A = {6, 7, 8, 9};
        int[] B = {1, 2, 3, 4, 6};
        int expected = 6;
        int actual = woowa04.solution(A, B);
        assertEquals(expected, actual);
    }

    @Test
    void case06() {
        int[] A = {5, 7, 8, 9};
        int[] B = {1, 2, 3, 4, 9};
        int expected = 9;
        int actual = woowa04.solution(A, B);
        assertEquals(expected, actual);
    }
}
