package dev.solar.kakao;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.*;

class Test03Test {

    Test03 test03 = new Test03();

    @Test
    void case01() {
        int[] arr = {10, 8, 9, 15, 12, 6, 7};
        List<Integer> arrList = Arrays.stream(arr).boxed().collect(Collectors.toList());
        int expected = 5;
        int actual = test03.solution(arrList);
        assertEquals(expected, actual);
    }

    @Test
    void case02() {
        int[] arr = {5, 1, 2, 1, 4, 5};
        List<Integer> arrList = Arrays.stream(arr).boxed().collect(Collectors.toList());
        int expected = 3;
        int actual = test03.solution(arrList);
        assertEquals(expected, actual);
    }

    @Test
    void case03() {
        int[] arr = {9, 7, 6, 2, 1};
        List<Integer> arrList = Arrays.stream(arr).boxed().collect(Collectors.toList());
        int expected = 5;
        int actual = test03.solution(arrList);
        assertEquals(expected, actual);
    }

    @Test
    void case04() {
        int[] arr = {7, 3, 4, 4, 8, 2, 5, 1};
        List<Integer> arrList = Arrays.stream(arr).boxed().collect(Collectors.toList());
        int expected = 5;
        int actual = test03.solution(arrList);
        assertEquals(expected, actual);
    }

    @Test
    void case05() {
        int[] arr = {6, 4, 1, 2, 3, 6, 9};
        List<Integer> arrList = Arrays.stream(arr).boxed().collect(Collectors.toList());
        int expected = 5;
        int actual = test03.solution(arrList);
        assertEquals(expected, actual);
    }
}
