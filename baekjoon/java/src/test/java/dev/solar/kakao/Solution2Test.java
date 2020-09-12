package dev.solar.kakao;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class Solution2Test {
    public static Solution2 solution;

    @BeforeEach
    void setUp() {
        solution = new Solution2();
    }

    @DisplayName("조합 테스트")
    @Test
    void test() {
        List<String> arr = new ArrayList<>();
        arr.add("1");
        arr.add("2");
        arr.add("3");
        List<String> result = new ArrayList<>();
        solution.reculsion(arr, result, 0, arr.size(), 2);
        for (String s : result) {
            System.out.println(s + " ");
        }
    }

    @DisplayName("조합 테스트")
    @Test
    void test2() {
        String str = "ABCFG";
        List<String> arr = Arrays.asList(str.split(""));
        List<String> result = new ArrayList<>();
        solution.reculsion(arr, result, 0, arr.size(), 2);
        for (String s : result) {
            System.out.println(s + " ");
        }
    }

    @DisplayName("조합 테스트")
    @Test
    void test3() {
        String str = "GFCBA";
        List<String> arr = Arrays.asList(str.split(""));
        Collections.sort(arr); //정렬
        List<String> result = new ArrayList<>();
        solution.reculsion(arr, result, 0, arr.size(), 2);
        for (String s : result) {
            System.out.println(s + " ");
        }
    }

    @DisplayName("문자열에 대한 모든 조합 구하기")
    @Test
    void test4() {
        int[] course = {2, 3};
//        List<String> thisCombinations = new ArrayList<>();
        String[] orders = {"XYZ", "XWY", "WXA"};
        for (String order : orders) {
            solution.courseCombination(course, order);
        }
    }

    @DisplayName("최종")
    @Test
    void finalTest() {
        String[] orders = {"XYZ", "XWY", "WXA"};
        int[] course = {2, 3};
        String[] expected = {"WX", "XY"};
        String[] actual = solution.solution(orders, course);
        assertArrayEquals(expected, actual);
    }

    @DisplayName("최종2")
    @Test
    void finalTest2() {
        String[] orders = {"ABCFG", "AC", "CDE", "ACDE", "BCFG", "ACDEH"};
        int[] course = {2, 3, 4};
        String[] expected = {"AC", "ACDE", "BCFG", "CDE"};
        String[] actual = solution.solution(orders, course);
        assertArrayEquals(expected, actual);
    }
}
