package dev.solar.library;

import java.util.Arrays;

public class Search {
    /**
     * 이분 탐색
     * 값이 있으면 1, 없으면 0
     */
    public int binarySearch(int[] arr, int target) {
        Arrays.sort(arr);

        int st = 0;
        int en = arr.length - 1;
        while (st <= en) {
            int mid = (st + en) / 2;
            if (arr[mid] < target) {
                st = mid + 1;
            } else if (arr[mid] > target) {
                en = mid - 1;
            } else {
                return 1;
            }
        }
        return 0;
    }
}
