package dev.solar.level1;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FindKimTest {
    FindKim findKim = new FindKim();

    @Test
    void solutionTest1() {
        String[] seoul = {"Jane", "Kim"};
        String expected = "김서방은 1에 있다";
        String actual = findKim.solution(seoul);
        assertEquals(expected, actual);
    }

    @Test
    void solutionTest2() {
        String[] seoul = {"Jane", "Sun", "Kim"};
        String expected = "김서방은 2에 있다";
        String actual = findKim.solution(seoul);
        assertEquals(expected, actual);
    }

    @Test
    void solutionTest3() {
        String[] seoul = {"Jane", "Sun", "Hae", "Choi", "Kim", "Hwang", "Lee"};
        String expected = "김서방은 4에 있다";
        String actual = findKim.solution(seoul);
        assertEquals(expected, actual);
    }
}