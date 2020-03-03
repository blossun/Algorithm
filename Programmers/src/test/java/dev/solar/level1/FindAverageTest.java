package dev.solar.level1;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FindAverageTest {
    FindAverage findAverage = new FindAverage();

    @Test
    void example1() {
        int[] arr = {1, 2, 3, 4};
        assertEquals(2.5, findAverage.solution(arr));
    }

    @Test
    void example2() {
        int[] arr = {5, 5};
        assertEquals(5, findAverage.solution(arr));
    }
}
