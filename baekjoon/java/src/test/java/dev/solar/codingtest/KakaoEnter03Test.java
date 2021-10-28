package dev.solar.codingtest;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class KakaoEnter03Test {
    KakaoEnter03 kakaoEnter03 = new KakaoEnter03();

    @Test
    void case01() {
        long n = 4;
        long expected = 7;
        assertEquals(expected, KakaoEnter03.minOperations(n));
    }

    @Test
    void case02() {
        long n = 13;
        long expected = 9;
        assertEquals(expected, KakaoEnter03.minOperations(n));
    }


    @Test
    void case03() {
        long n = 156;
        long expected = 232;
        assertEquals(expected, KakaoEnter03.minOperations(n));
    }
}
