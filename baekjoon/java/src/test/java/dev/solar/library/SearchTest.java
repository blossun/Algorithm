package dev.solar.library;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class SearchTest {

    Search search = new Search();

    @DisplayName("이분탐색 확인")
    @Test
    void case01() {
        int[] arr = {4, 2, 1, 5, 3};
        assertEquals(1, search.binarySearch(arr, 1));
        assertEquals(1, search.binarySearch(arr, 2));
        assertEquals(1, search.binarySearch(arr, 3));
        assertEquals(1, search.binarySearch(arr, 4));
        assertEquals(1, search.binarySearch(arr, 5));
        assertEquals(0, search.binarySearch(arr, 9));
        assertEquals(0, search.binarySearch(arr, 19));
        assertEquals(0, search.binarySearch(arr, 202));
    }

    @Test
    void case02() {
        int[] arr = {4, 2, 1, 5, 3};
        Arrays.sort(arr);
        int index = Arrays.binarySearch(arr, 1); //정렬된 배열을 넘겨야 한다.
        System.out.println(index); //0
        index = Arrays.binarySearch(arr, 2);
        System.out.println(index); //1
        index = Arrays.binarySearch(arr, 3);
        System.out.println(index); //2
        index = Arrays.binarySearch(arr, 4);
        System.out.println(index); //3
        index = Arrays.binarySearch(arr, 5);
        System.out.println(index); //4
        assertTrue(Arrays.binarySearch(arr, 10) < 0);
    }

    @Test
    void case03() {
        int[] arr = {1, 2, 3, 4, 5};
        assertEquals(2, search.lower_index(arr, 3));
        assertEquals(4, search.lower_index(arr, 5));
        assertEquals(0, search.lower_index(arr, -1));
    }

    @Test
    void case04() {
        int[] arr = {1, 2, 3, 4, 5};
        assertEquals(5, search.lower_index(arr, 7));
        assertEquals(0, search.lower_index(arr, -1));
    }
}
