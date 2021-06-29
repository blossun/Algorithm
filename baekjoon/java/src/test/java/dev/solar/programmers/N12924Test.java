package dev.solar.programmers;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class N12924Test {

    N12924 n12924 = new N12924();

    @Test
    void case01() {
        assertThat(n12924.solution(15)).isEqualTo(4);
    }
}
