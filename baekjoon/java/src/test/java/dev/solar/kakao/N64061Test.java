package dev.solar.kakao;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class N64061Test {

    N64061 n64061 = new N64061();

    @Test
    void case01() {
        int[][] board = {{0,0,0,0,0},{0,0,1,0,3},{0,2,5,0,1},{4,2,4,4,2},{3,5,1,3,1}};
        int[] moves = {1,5,3,5,1,2,1,4};
        int expected = 4;
        int actual = n64061.solution(board, moves);
        assertThat(actual).isEqualTo(expected);
    }

}
