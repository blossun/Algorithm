package dev.solar.programmers;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class N42747Test {

    N42747 n42747 = new N42747();

    @Test
    void case00() {
        int[] citations = {3, 0, 6, 1, 5};
        assertThat(n42747.solution(citations)).isEqualTo(3);
    }

    @Test
    void case01() {
        int[] citations = {2, 3, 6, 6, 7, 7, 7, 7, 8, 9};
        assertThat(n42747.solution(citations)).isEqualTo(6);
    }

    @Test
    void case02() {
        int[] citations = {10, 8, 5, 4, 3};
        assertThat(n42747.solution(citations)).isEqualTo(4);
    }

    @Test
    void case03() {
        int[] citations = {25, 8, 5, 3, 3};
        assertThat(n42747.solution(citations)).isEqualTo(3);
    }

    @Test
    void case04() {
        int[] citations = {5, 5, 5, 5};
        assertThat(n42747.solution(citations)).isEqualTo(4);
    }

    @Test
    void case05() {
        int[] citations = {88, 89};
        assertThat(n42747.solution(citations)).isEqualTo(2);
    }
}
