package dev.solar.baekjoon;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class N2579Test {
    @Test
    void test1() {
        int arr[] = {10, 20, 15, 25, 10, 20};
        int expected = 75;
        int actual = N2579.solution(arr.length, arr);
        assertEquals(expected, actual);
    }

    @Test
    void test2() {
        int arr[] = {10};
        int expected = 10;
        int actual = N2579.solution(arr.length, arr);
        assertEquals(expected, actual);
    }

    @Test
    void test3() {
        int arr[] = {10, 20};
        int expected = 30;
        int actual = N2579.solution(arr.length, arr);
        assertEquals(expected, actual);
    }

    @Test
    void test4() {
        int arr[] = {10, 20, 15};
        int expected = 35;
        int actual = N2579.solution(arr.length, arr);
        assertEquals(expected, actual);
    }

    @Test
    void test5() {
        int arr[] = {10, 20, 15, 25};
        int expected = 55;
        int actual = N2579.solution(arr.length, arr);
        assertEquals(expected, actual);
    }

    @Test
    void test6() {
        int arr[] = {10, 20, 15, 25};
        int expected = 55;
        int actual = N2579.solution(arr.length, arr);
        assertEquals(expected, actual);
    }

    @Test
    void test7() {
        int arr[] = {50, 40, 30, 20, 10};
        int expected = 120;
        int actual = N2579.solution(arr.length, arr);
        assertEquals(expected, actual);
    }

    @Test
    void test8() {
        int arr[] = {8, 3, 5, 8, 1};
        int expected = 20;
        int actual = N2579.solution(arr.length, arr);
        assertEquals(expected, actual);
    }


}
