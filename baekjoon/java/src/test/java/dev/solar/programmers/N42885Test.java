package dev.solar.programmers;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class N42885Test {

    N42885 n42885 = new N42885();

    @Test
    void case01() {
        int[] people = {70, 50, 80, 50};
        int limit = 100;
        int expected = 3;
        int actual = n42885.solution(people, limit);
        assertEquals(expected, actual);
    }

    @Test
    void case02() {
        int[] people = {70, 50, 80};
        int limit = 100;
        int expected = 3;
        int actual = n42885.solution(people, limit);
        assertEquals(expected, actual);
    }

    @Test
    void case03() {
        int[] people = {10, 10, 30, 70, 80};
        int limit = 100;
        int expected = 2;
        int actual = n42885.solution(people, limit);
        assertEquals(expected, actual);
    }
}
