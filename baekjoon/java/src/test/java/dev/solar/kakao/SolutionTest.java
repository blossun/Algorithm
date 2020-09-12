package dev.solar.kakao;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {
    public static Solution solution;

    @BeforeAll
    static void setUp() {
        solution = new Solution();
    }

    @DisplayName("1단계 소문자로 치환")
    @Test
    void test1() {
        String id = "...!@BaT#*..y.abcdefghijklm";
        String expected = "...!@bat#*..y.abcdefghijklm";
        String actual = solution.step1(id);
        assertEquals(expected, actual);
    }

    @DisplayName("2단계 new_id에서 알파벳 소문자, 숫자, 빼기(-), 밑줄(_), 마침표(.)를 제외한 모든 문자를 제거합니다.")
    @Test
    void test2() {
        String id = "...!@bat#*..y.abcdefghijklm";
        String expected = "...bat..y.abcdefghijklm";
        String actual = solution.step2(id);
        assertEquals(expected, actual);
    }

    @DisplayName("2단계")
    @Test
    void test22() {
        String id = "z-+.^.";
        String expected = "z-..";
        String actual = solution.step2(id);
        assertEquals(expected, actual);
    }

    @DisplayName("2단계")
    @Test
    void test23() {
        String id = "=.=";
        String expected = ".";
        String actual = solution.step2(id);
        assertEquals(expected, actual);
    }

    @DisplayName("3단계")
    @Test
    void test3() {
        String id = "...bat..y.abcdefghijklm";
        String expected = ".bat.y.abcdefghijklm";
        String actual = solution.step3(id);
        assertEquals(expected, actual);
    }

    @DisplayName("3단계")
    @Test
    void test32() {
        String id = "z-..";
        String expected = "z-.";
        String actual = solution.step3(id);
        assertEquals(expected, actual);
    }

    @DisplayName("3단계")
    @Test
    void test33() {
        String id = "=.=";
        String expected = "=.=";
        String actual = solution.step3(id);
        assertEquals(expected, actual);
    }

    @DisplayName("4단계")
    @Test
    void test4() {
        String id = ".bat.y.abcdefghijklm";
        String expected = "bat.y.abcdefghijklm";
        String actual = solution.step4(id);
        assertEquals(expected, actual);
    }

    @DisplayName("4단계")
    @Test
    void test42() {
        String id = "z-.";
        String expected = "z-";
        String actual = solution.step4(id);
        assertEquals(expected, actual);
    }

    @DisplayName("4단계")
    @Test
    void test43() {
        String id = "=.=";
        String expected = "=.=";
        String actual = solution.step4(id);
        assertEquals(expected, actual);
    }

    @DisplayName("5단계")
    @Test
    void test5() {
        String id = "bat.y.abcdefghijklm";
        String expected = "bat.y.abcdefghijklm";
        String actual = solution.step5(id);
        assertEquals(expected, actual);
    }

    @DisplayName("5단계")
    @Test
    void test51() {
        String id = "";
        String expected = "a";
        String actual = solution.step5(id);
        assertEquals(expected, actual);
    }

    @DisplayName("6단계")
    @Test
    void test6() {
        String id = "bat.y.abcdefghijklm";
        String expected = "bat.y.abcdefghi";
        String actual = solution.step6(id);
        assertEquals(expected, actual);
    }

    @DisplayName("6단계 - 문자열 자른 후 앞뒤 마침표 제거 확인")
    @Test
    void test62() {
        String id = "abcdefghijklmn.p";
        String expected = "abcdefghijklmn";
        String actual = solution.step6(id);
        assertEquals(expected, actual);
    }

    @DisplayName("6단계")
    @Test
    void test63() {
        String id = "aaa";
        String expected = "aaa";
        String actual = solution.step6(id);
        assertEquals(expected, actual);
    }

    @DisplayName("7단계")
    @Test
    void test7() {
        String id = "bat.y.abcdefghi";
        String expected = "bat.y.abcdefghi";
        String actual = solution.step7(id);
        assertEquals(expected, actual);
    }

    @DisplayName("7단계")
    @Test
    void test72() {
        String id = "c";
        String expected = "ccc";
        String actual = solution.step7(id);
        assertEquals(expected, actual);
    }
    @DisplayName("7단계")
    @Test
    void test73() {
        String id = "z-";
        String expected = "z--";
        String actual = solution.step7(id);
        assertEquals(expected, actual);
    }

    //123_.def -> 123_.def
    @DisplayName("(1) 1단계")
    @Test
    void ex1() {
        String id = "123_.def";
        String expected = "123_.def";
        String actual = solution.step1(id);
        assertEquals(expected, actual);
    }

    @DisplayName("(1) 2단계")
    @Test
    void ex2() {
        String id = "123_.def";
        String expected = "123_.def";
        String actual = solution.step2(id);
        assertEquals(expected, actual);
    }

    @DisplayName("(1) 3단계")
    @Test
    void ex3() {
        String id = "123_.def";
        String expected = "123_.def";
        String actual = solution.step3(id);
        assertEquals(expected, actual);
    }

    @DisplayName("(1) 4단계")
    @Test
    void ex4() {
        String id = "123_.def";
        String expected = "123_.def";
        String actual = solution.step4(id);
        assertEquals(expected, actual);
    }

    @DisplayName("(1) 5단계")
    @Test
    void ex5() {
        String id = "123_.def";
        String expected = "123_.def";
        String actual = solution.step5(id);
        assertEquals(expected, actual);
    }

    @DisplayName("(1) 6단계")
    @Test
    void ex6() {
        String id = "123_.def";
        String expected = "123_.def";
        String actual = solution.step6(id);
        assertEquals(expected, actual);
    }

    @DisplayName("(1) 7단계")
    @Test
    void ex7() {
        String id = "123_.def";
        String expected = "123_.def";
        String actual = solution.step7(id);
        assertEquals(expected, actual);
    }
}
