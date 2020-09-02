package dev.solar.level1;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SumDigitsTest {
    SumDigits sumDigits;

    @BeforeEach
    void beforEach() {
        sumDigits = new SumDigits();
    }

    @Test
    void solution() {
        int n = 123;
        int expected = 6;
        int actual = sumDigits.solution(n);
        assertEquals(expected, actual);
    }
}
