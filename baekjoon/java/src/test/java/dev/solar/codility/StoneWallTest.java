package dev.solar.codility;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StoneWallTest {
    private StoneWall stoneWall;

    @BeforeEach
    void setUp() {
        stoneWall = new StoneWall();
    }

    @Test
    void test1() {
        int[] H = {8, 7, 7, 8, 9, 4, 5, 8, 8};
        int actual = stoneWall.solution(H);
        int expected = 7;
        assertEquals(expected, actual);
    }
}
