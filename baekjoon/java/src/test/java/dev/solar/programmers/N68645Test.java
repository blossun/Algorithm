package dev.solar.programmers;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class N68645Test {

    N68645 n68645 = new N68645();

    @Test
    void case01() {
        int n = 4;
        int[] expected = {1,2,9,3,10,8,4,5,6,7};
        int[] actual = n68645.solution(n);
        assertArrayEquals(expected, actual);
    }
}
