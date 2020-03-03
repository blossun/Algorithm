package dev.solar.level1;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class SortStringTest {

    @Test
    void solutionTest() {
        SortString sortString = new SortString();
        String[] strings = {"sun", "bed", "car"};
        int n = 1;
        String[] expected = {"car", "bed", "sun"};
        String[] actual = sortString.solution(strings, n);
        System.out.println(Arrays.toString(actual));
        assertEquals(Arrays.toString(expected), Arrays.toString(actual));
    }
}
