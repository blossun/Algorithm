package dev.solar.baekjoon;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Quadrant_14681Test {
    Quadrant_14681 quadrant = new Quadrant_14681();

    @Test
    void test1() {
        int x = 12;
        int y = 5;

        int expected = 1;
        int actual = quadrant.quadrant(x, y);
        assertEquals(expected, actual);
    }

    @Test
    void test2() {
        int x = 9;
        int y = -13;

        int expected = 4;
        int actual = quadrant.quadrant(x, y);
        assertEquals(expected, actual);
    }

    @Test
    void test3() {
        int x = -3;
        int y = 5;

        int expected = 2;
        int actual = quadrant.quadrant(x, y);
        assertEquals(expected, actual);
    }

    @Test
    void test4() {
        int x = -2;
        int y = -13;

        int expected = 3;
        int actual = quadrant.quadrant(x, y);
        assertEquals(expected, actual);
    }
}
