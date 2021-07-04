package dev.solar.naver;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Webtoon02Test {

    Webtoon02 webtoon02 = new Webtoon02();

    @Test
    void temp() {
        String test = "abc";
        String substring = test.substring(3); ///3은 에러안나고 4는 에러남
        System.out.println(substring);
        System.out.println(substring.isEmpty());
    }

    @Test
    void temp02() {
        String test = null;
        System.out.println(test == null);
    }

    @Test
    void case01() {
        String s = "abcxyasdfasdfxyabc";
        String[] expected = {"abc","xy","asdf","asdf","xy","abc"};
        String[] actual = webtoon02.solution(s);
        assertArrayEquals(expected, actual);
    }

    @Test
    void case02() {
        String s = "zzzzz";
        String[] expected = {"z","z","z","z","z"};
        String[] actual = webtoon02.solution(s);
        assertArrayEquals(expected, actual);
    }

    @Test
    void case022() {
        String s = "zzzzzz";
        String[] expected = {"z","z","z","z","z","z"};
        String[] actual = webtoon02.solution(s);
        assertArrayEquals(expected, actual);
    }

    @Test
    void case03() {
        String s = "a";
        String[] expected = {"a"};
        String[] actual = webtoon02.solution(s);
        assertArrayEquals(expected, actual);
    }

    @Test
    void case04() {
        String s = "ab";
        String[] expected = {"ab"};
        String[] actual = webtoon02.solution(s);
        assertArrayEquals(expected, actual);
    }
}
