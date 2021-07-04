package dev.solar.naver;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Webtoon03Test {

    Webtoon03 webtoon03 = new Webtoon03();

    @Test
    void temp() {
        String s = "aabcbcd";
        String t = "abc";
        System.out.println(s.indexOf(t));
        String s1 = s.replaceFirst(t, "");
        System.out.println(s1);
    }


    @Test
    void case01() {
        String s = "aabcbcd";
        String t = "abc";
        int expected = 2;
        int actual = webtoon03.solution(s, t);
        assertEquals(expected, actual);
    }

    @Test
    void case02() {
        String s = "abacde";
        String t = "zzz";
        int expected = 0;
        int actual = webtoon03.solution(s, t);
        assertEquals(expected, actual);
    }

    @Test
    void case03() {
        String s = "aaaaa";
        String t = "a";
        int expected = 5;
        int actual = webtoon03.solution(s, t);
        assertEquals(expected, actual);
    }

    @Test
    void case04() {
        String s = "aababba";
        String t = "ab";
        int expected = 3;
        int actual = webtoon03.solution(s, t);
        assertEquals(expected, actual);
    }

    @Test
    void case05() {
        String s = "aababba";
        String t = "a";
        int expected = 4;
        int actual = webtoon03.solution(s, t);
        assertEquals(expected, actual);
    }

    @Test
    void case06() {
        String s = "aababba";
        String t = "b";
        int expected = 3;
        int actual = webtoon03.solution(s, t);
        assertEquals(expected, actual);
    }
}
