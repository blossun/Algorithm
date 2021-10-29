package dev.solar.kakao;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class N02Test {
    N02 n02 = new N02();

    @Test
    void case01() {
        int n = 437674;
        int k = 3;
        int expected = 3;
        int actual = n02.solution(n, k);
        assertEquals(expected, actual);
    }

    @Test
    void case02() {
        int n = 110011;
        int k = 10;
        int expected = 2;
        int actual = n02.solution(n, k);
        assertEquals(expected, actual);
    }

    @Test
    void case03() {
        int n = 0;
        int k = 3;
        int expected = 0;
        int actual = n02.solution(n, k);
        assertEquals(expected, actual);
    }

    @Test
    void case04() {
        int n = 202002;
        int k = 10;
        int expected = 3;
        int actual = n02.solution(n, k);
        assertEquals(expected, actual);
    }

    @Test
    void temp() {
        int n = 437674;
        String number = n02.convertNumber(n, 10);
        System.out.println("number : " + number);
        String[] numberList = String.valueOf(number).split("0");
        for (String s : numberList) {
            System.out.println("s => " + s);
        }
    }
}
