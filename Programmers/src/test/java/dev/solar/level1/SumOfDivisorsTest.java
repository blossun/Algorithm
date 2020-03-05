package dev.solar.level1;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SumOfDivisorsTest {
    SumOfDivisors sumOfDivisors = new SumOfDivisors();

    @Test
    void example1() {
        int expected = 28;
        int actual = sumOfDivisors.solution(12);
        assertEquals(expected, actual);
    }

    @Test
    void example2() {
        int expected = 6;
        int actual = sumOfDivisors.solution(5);
        assertEquals(expected, actual);
    }

    @Test
    void example3() {
        int expected = 7;
        int actual = sumOfDivisors.solution(4);
        assertEquals(expected, actual);
    }

    @Test
    void example4() {
        int expected = 1;
        int actual = sumOfDivisors.solution(1);
        assertEquals(expected, actual);
    }
}
