package dev.solar.baekjoon;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class N1463Test {
    @Test
    void test1() {
        int expected = 0;
        int actual = N1463.solution(1);
        assertEquals(expected, actual);
    }

    @Test
    void test2() {
        int expected = 1;
        int actual = N1463.solution(2);
        assertEquals(expected, actual);
    }

    @Test
    void test3() {
        int expected = 1;
        int actual = N1463.solution(3);
        assertEquals(expected, actual);
    }

    @Test
    void test4() {
        int expected = 2;
        int actual = N1463.solution(4);
        assertEquals(expected, actual);
    }

    @Test
    void test5() {
        int expected = 3;
        int actual = N1463.solution(5);
        assertEquals(expected, actual);
    }

    @Test
    void test6() {
        int expected = 2;
        int actual = N1463.solution(6);
        assertEquals(expected, actual);
    }

    @Test
    void test7() {
        int expected = 3;
        int actual = N1463.solution(7);
        assertEquals(expected, actual);
    }

    @Test
    void test8() {
        int expected = 3;
        int actual = N1463.solution(8);
        assertEquals(expected, actual);
    }

    @Test
    void test9() {
        int expected = 2;
        int actual = N1463.solution(9);
        assertEquals(expected, actual);
    }

    @Test
    void test10() {
        int expected = 3;
        int actual = N1463.solution(10);
        assertEquals(expected, actual);
    }

    @Test
    void test30() {
        int expected = 4;
        int actual = N1463.solution(30);
        assertEquals(expected, actual);
    }

    @Test
    void test570() {
        int expected = 8;
        int actual = N1463.solution(570);
        assertEquals(expected, actual);
    }

    @Test
    void test571() {
        int expected = 9;
        int actual = N1463.solution(571);
        assertEquals(expected, actual);
    }

    @Test
    void test572() {
        int expected = 10;
        int actual = N1463.solution(572);
        assertEquals(expected, actual);
    }

    @Test
    void test642() {
        int expected = 10;
        int actual = N1463.solution(642);
        assertEquals(expected, actual);
    }

    @Test
    void test643() {
        int expected = 11;
        int actual = N1463.solution( 643);
        assertEquals(expected, actual);
    }

    @Test
    void test734() {
        int expected = 9;
        int actual = N1463.solution(734);
        assertEquals(expected, actual);
    }

    @Test
    void test740() {
        int expected = 9;
        int actual = N1463.solution(740);
        assertEquals(expected, actual);
    }

    @Test
    void test842() {
        int expected = 11;
        int actual = N1463.solution(842);
        assertEquals(expected, actual);
    }

    @Test
    void test284() {
        int expected = 10;
        int actual = N1463.solution(284);
        assertEquals(expected, actual);
    }

    @Test
    void test321() {
        int expected = 9;
        int actual = N1463.solution(321);
        assertEquals(expected, actual);
    }

    @Test
    void test1000000() {
        int expected = 19;
        int actual = N1463.solution(1000000);
        assertEquals(expected, actual);
    }

}
