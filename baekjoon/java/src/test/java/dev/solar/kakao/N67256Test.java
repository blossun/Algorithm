package dev.solar.kakao;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class N67256Test {

    N67256 n67256 = new N67256();

    @Test
    void case01() {
        int[] numbers = {1, 3, 4, 5, 8, 2, 1, 4, 5, 9, 5};
        String hand = "right";
        String expected = "LRLLLRLLRRL";
        String actual = n67256.solution(numbers, hand);
        assertThat(actual).isEqualTo(expected);
    }

}
