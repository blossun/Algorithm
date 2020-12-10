package dev.solar.baekjoon;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RadixSortTest {
    RadixSort radixSort;

    @BeforeEach
    void setUp() {
        radixSort = new RadixSort();
    }

    @Test
    void test1() {
        int[] arr = {15, 25, 22, 357, 16, 23, 12, -46, 3};
        int[] sortedArr = radixSort.radixSort(arr);
        int[] expected = {-46, 3, 12, 15, 16, 22, 23, 25, 357};

        for (int i : sortedArr) {
            System.out.println(i);
        }
        assertArrayEquals(expected, sortedArr);
    }

    @Test
    void test2() {
        int[] arr = {15, 15, 25, 22, -11, 357, 16, 23, 12, -88, 0, 46, 3};
        for (int i = 0; i < arr.length; i++) {
            arr[i] += 1000000;
        }
        int[] sortedArr = radixSort.radixSort(arr);
        for (int i = 0; i < sortedArr.length; i++) {
            sortedArr[i] -= 1000000;
        }
        int[] expected = {-88, -11, 0, 3, 12, 15, 15, 16, 22, 23, 25, 46, 357};

        for (int i : sortedArr) {
            System.out.println(i);
        }
        assertArrayEquals(expected, sortedArr);
    }

    @Test
    void 음수값() {
        int[] arr = {15, 15, 25, 22, -11, -11, 357, 16, 23, 12, -88, 0, 46, 3};
        int[] sortedArr = radixSort.radixSort(arr);
        int[] expected = {-88, -11, -11, 0, 3, 12, 15, 15, 16, 22, 23, 25, 46, 357};

        for (int i : sortedArr) {
            System.out.println(i);
        }
        assertArrayEquals(expected, sortedArr);
    }
}
