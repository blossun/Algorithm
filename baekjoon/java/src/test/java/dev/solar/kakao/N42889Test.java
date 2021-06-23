package dev.solar.kakao;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class N42889Test {

    private N42889 n42889 = new N42889();

    @Test
    void temp() {
        double failure = (double) 1 / 8;
        System.out.println(failure);
    }

    @Test
    void case01() {
        int N = 5;
        int[] stages = {2, 1, 2, 6, 2, 4, 3, 3};
        int[] expected = {3, 4, 2, 1, 5};
        assertThat(n42889.solution(N, stages)).isEqualTo(expected);
    }

}
