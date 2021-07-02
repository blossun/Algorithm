package dev.solar.programmers;

import org.junit.jupiter.api.Test;

class N17679Test {

    N17679 n17679 = new N17679();

    @Test
    void case01() {
        int[] scoville = {1, 2, 3, 9, 10, 12};
        int K = 7;
        int expected = 2;
        int actual = n17679.solution(scoville, K);
    }

    @Test
    void case02() {
        int[] scoville = {1, 2, 3};
        int K = 11;
        int expected = 2;
        int actual = n17679.solution(scoville, K);
    }


}
