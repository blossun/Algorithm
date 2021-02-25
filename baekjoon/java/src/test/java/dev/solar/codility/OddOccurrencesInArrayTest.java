package dev.solar.codility;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class OddOccurrencesInArrayTest {

    public static OddOccurrencesInArray oddOccurrencesInArray;

    @BeforeEach
    void setUp() {
        oddOccurrencesInArray = new OddOccurrencesInArray();
    }

    @Test
    void test1() {
        int[] arr = {9, 3, 9, 3, 7, 3, 3};
        int actual = oddOccurrencesInArray.solution(arr);
        int expected = 7;
        assertEquals(expected, actual);
    }
}
