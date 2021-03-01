package dev.solar.codility;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GenomicRangeQueryTest {
    private GenomicRangeQuery genomicRangeQuery;

    @BeforeEach
    void setUp() {
        genomicRangeQuery = new GenomicRangeQuery();
    }

    @Test
    void test1() {
        String S = "CAGCCTA";
        int[] P = new int[]{2, 5, 0};
        int[] Q = new int[]{4, 5, 6};
        int[] actual = genomicRangeQuery.solution(S, P, Q);
        int[] expected = new int[]{2, 4, 1};
        assertArrayEquals(expected, actual);
    }
}
