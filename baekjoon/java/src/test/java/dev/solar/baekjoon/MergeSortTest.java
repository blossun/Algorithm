package dev.solar.baekjoon;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MergeSortTest {
    public static MergeSort mergeSort;

    @BeforeAll
    static void setUp() {
        mergeSort = new MergeSort();
    }

    @Test
    void test1() {
        int[] arr = {15, 25, 22, 357, 16, 23, -53, 12, 46, 3};
        int[] sortedArr = mergeSort.sort(arr);
        int[] expected = {-53, 3, 12, 15, 16, 22, 23, 25, 46, 357};

        for (int i : sortedArr) {
            System.out.println(i);
        }
        assertArrayEquals(expected, sortedArr);
    }
}
