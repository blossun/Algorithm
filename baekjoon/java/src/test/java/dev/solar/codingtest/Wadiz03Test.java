package dev.solar.codingtest;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Wadiz03Test {
    Wadiz03 wadiz03 = new Wadiz03();

    @Test
    void case01() {
        int[] arr = {1, 2, 4, 8, 4, 2, 1};
        assertEquals(4, wadiz03.solution(arr));
    }

    @Test
    void case02() {
        int[] arr = {10, 0, 10, 0, 10, 0};
        assertEquals(3, wadiz03.solution(arr));
    }

    @Test
    void case03() {
        int[] arr = {5, 4, 5, 4, 5, 5};
        assertEquals(4, wadiz03.solution(arr));
    }


    @Test
    void case04() {
        int[] arr = {0,0,0,0};
        assertEquals(0, wadiz03.solution(arr));
    }

    @Test
    void case05() {
        int[] arr = {1, 1, 1, 1};
        assertEquals(1, wadiz03.solution(arr));
    }

    @Test
    void case06() {
        int[] arr = {1, 1, 2, 1};
        assertEquals(2, wadiz03.solution(arr));
    }

    @Test
    void case07() {
        int[] arr = {1, 3, 5, 7, 3, 8, 9, 5, 1, 5, 3, 9, 8, 3};
        assertEquals(11, wadiz03.solution(arr));
    }

}
