package dev.solar.programmers;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class N12900Test {
    N12900 n12900 = new N12900();

    @Test
    void case01() {
        int n = 4;
        assertThat(n12900.solution(n)).isEqualTo(5);
    }

    @Test
    void case02() {
        int n = 2;
        assertThat(n12900.solution(n)).isEqualTo(2);
    }

    @Test
    void case03() {
        int n = 9;
        assertThat(n12900.solution(n)).isEqualTo(55);
    }
}
