package dev.solar.baekjoon;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class N1978Test {
    public static N1978 n1978;

    @BeforeAll
    static void setUp() {
        n1978 = new N1978();
    }

    @Test
    void 소수1() {
        assertFalse(N1978.isPrime(1));
    }

    @Test
    void 소수3() {
        assertTrue(N1978.isPrime(3));
    }

    @Test
    void 소수4() {
        assertFalse(N1978.isPrime(4));
    }

    @Test
    void 소수5() {
        assertTrue(N1978.isPrime(5));
    }

    @Test
    void 소수7() {
        assertTrue(N1978.isPrime(7));
    }
}
