package dev.solar.programmers;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class N12951Test {

    N12951 n12951 = new N12951();

    @Test
    void case01() {
        String s = "test test1  Tes2 tesT4";
        String expected = "Test Test1  Tes2 Test4";
        assertThat(n12951.solution(s)).isEqualTo(expected);
    }

    @Test
    void case02() {
        String s = "test TEST  ";
        String expected = "Test Test  ";
        assertThat(n12951.solution(s)).isEqualTo(expected);
    }
}
