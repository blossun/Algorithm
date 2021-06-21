package dev.solar.programmers;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Greedy01Test {

    private Greedy01 greedy01;

    @BeforeEach
    void setUp() {
        greedy01 = new Greedy01();
    }

    @Test
    void solution() {
        int expected = 5;
        int[] lost = {2, 4};
        int[] reserve = {1, 3, 5};
        int actual = greedy01.solution(5, lost, reserve);
        assertEquals(expected, actual);
    }

    @Test
    void test02() {
        int expected = 4;
        int[] lost = {2, 4};
        int[] reserve = {3};
        int actual = greedy01.solution(5, lost, reserve);
        assertEquals(expected, actual);
    }

    @Test
    void test03() {
        int expected = 2;
        int[] lost = {3};
        int[] reserve = {1};
        int actual = greedy01.solution(3, lost, reserve);
        assertEquals(expected, actual);
    }

    @Test
    void test04() {
        int expected = 1;
        int[] lost = {1, 2};
        int[] reserve = {4};
        int actual = greedy01.solution(3, lost, reserve);
        assertEquals(expected, actual);
    }

    @Test
    void test05() {
        int expected = 10;
        int[] lost = {5, 4, 3, 2, 1};
        int[] reserve = {3, 1, 2, 5, 4};
        int actual = greedy01.solution(10, lost, reserve);
        assertEquals(expected, actual);
    }

    @Test
    void test06() {
        int expected = 4;
        int[] lost = {2, 3, 4};
        int[] reserve = {3, 4, 5};
        int actual = greedy01.solution(5, lost, reserve);
        assertEquals(expected, actual);
    }
}
