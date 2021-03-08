package dev.solar.codility;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BracketsTest {
    private Brackets brackets;

    @BeforeEach
    void setUp() {
        brackets = new Brackets();
    }

    @Test
    void test1() {
        String S = "{[()()]}";
        assertEquals(1, brackets.solution(S));
    }

    @Test
    void test2() {
        String S = "{[()()]}{";
        assertEquals(0, brackets.solution(S));
    }

    @Test
    void test3() {
        String S = "{[(";
        assertEquals(0, brackets.solution(S));
    }

    @Test
    void test4() {
        String S = ")}";
        assertEquals(0, brackets.solution(S));
    }

    @Test
    void test5() {
        String S = "";
        assertEquals(1, brackets.solution(S));
    }

}
