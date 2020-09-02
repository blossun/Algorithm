package dev.solar.level1;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class NaturalNumberInversionArrayTest {
    NaturalNumberInversionArray mock = new NaturalNumberInversionArray();

    @Test
    void solution() {
        int[] expected = {5,4,3,2,1};
        int[] actual = mock.solution(12345);
        assertArrayEquals(expected, actual);
    }
}
