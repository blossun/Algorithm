package dev.solar.naver;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class Test5Test {
    private Test5 test5;

    @BeforeEach
    void setUp() {
        test5 = new Test5();
    }

    @Test
    void test1() {
        int N = 268;
        List<Integer> numDigits = new ArrayList<>();
        int digit = 10;
        while (N > 0) {
            int numDigit = N % digit;
            N /= digit;
            numDigits.add(numDigit);
        }
        System.out.printf(numDigits.toArray().toString());
    }

    @Test
    void test2() {
        assertEquals(5268, test5.solution(268));
    }

    @Test
    void test3() {
        assertEquals(6750, test5.solution(670));
    }

    @Test
    void test4() {
        assertEquals(50, test5.solution(0));
    }

    @Test
    void test5() {
        assertEquals(-5999, test5.solution(-999));
    }

    @Test
    void test6() {
        assertEquals(-55678, test5.solution(-5678));
    }

    @Test
    void test7() {
        assertEquals(-54325, test5.solution(-5432));
    }
}
