package dev.solar.baekjoon;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.*;

class AvgTest {
    public static Avg avg;

    @BeforeAll
    static void setUp() {
        avg = new Avg();
    }

    @DisplayName("정확성 테스트")
    @Test
    void test1() {
        int[] scores = {10, 65, 100, 30, 95};
        int expected = 68;
        int actual = avg.solv(scores);

        assertEquals(expected, actual);
    }

    @DisplayName("효율성 테스트")
    @Test
    void test2() {
        int[] scores = {10, 65, 100, 30, 95};
        assertTimeout(Duration.ofMillis(0), () -> avg.solv(scores));
    }
}
