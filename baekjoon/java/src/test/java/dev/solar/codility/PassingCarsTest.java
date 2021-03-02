package dev.solar.codility;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PassingCarsTest {
    private PassingCars passingCars;

    @BeforeEach
    void setUp() {
        passingCars = new PassingCars();
    }

    @Test
    void test1() {
        int[] A = {0, 1, 0, 1, 1};
        int actual = passingCars.solution(A);
        int expected = 5;
        assertEquals(expected, actual);
    }
}
