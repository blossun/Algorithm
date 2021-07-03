package dev.solar.kakao;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Mobility03Test {

    Mobility03 mobility03 = new Mobility03();

    @Test
    void case01() {
        int[] A = {3, 2, 3, 2, 3};
        int expected = 5;
        int actual = mobility03.solution(A);
        assertEquals(expected, actual);
    }

    @Test
    void case02() {
        int[] A = {7, 4, -2, 4, -2, -9};
        int expected = 4;
        int actual = mobility03.solution(A);
        assertEquals(expected, actual);
    }

    @Test
    void case03() {
        int[] A = {7, -5, -5, -5, 7, -1, 7};
        int expected = 3;
        int actual = mobility03.solution(A);
        assertEquals(expected, actual);
    }

    @Test
    void case04() {
        int[] A = {4};
        int expected = 1;
        int actual = mobility03.solution(A);
        assertEquals(expected, actual);
    }
}
