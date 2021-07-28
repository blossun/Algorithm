package dev.solar.programmers;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class N1829Test {
    N1829 n1829 = new N1829();

    @Test
    void case01() {
        int[][] picture = {{1, 1, 1, 0}, {1, 2, 2, 0}, {1, 0, 0, 1}, {0, 0, 0, 1}, {0, 0, 0, 3}, {0, 0, 0, 3}};
        int m = 6;
        int n = 4;
        int[] expected = {4,5};
        int[] actual = n1829.solution(m, n, picture);
        assertThat(actual).isEqualTo(expected);
    }
}
