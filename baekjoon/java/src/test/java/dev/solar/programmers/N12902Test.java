package dev.solar.programmers;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class N12902Test {
    N12902 n12902 = new N12902();

    @Test
    void case01() {
        int n = 4;
        assertThat(n12902.solution(n)).isEqualTo(11);
    }

    @Test
    void case02() {
        int n = 6;
        assertThat(n12902.solution(n)).isEqualTo(41);
    }
}
