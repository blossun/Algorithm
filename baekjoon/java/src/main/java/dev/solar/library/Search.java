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

    /**
     * target이 arr에 들어갔을 때, 정렬이 유지되는 제일 왼쪽 index를 구한다.
     * @param arr : 정렬된 배열이어야 한다.
     * @param target
     * @return
     */
    public int lower_index(int[] arr, int target) {
        int st = 0;
        int en = arr.length; // arr.length -1 이 아님을 주의
        while (st < en) {
            int mid = (st + en)/2;
            if (arr[mid] < target) {
                st = mid + 1;
            } else if (arr[mid] >= target) {  //arr[mid] = target인 경우 en을 옮겨준다.
                en = mid;
            }
        }

        // 값을 찾는게 아니라 값이 들어갈 수 있는 제일 왼쪽 index를 구하는 것이므로..
        return st; //st = en으로 가능한 후보가 1개로 확정될 경우 while문을 탈출함
    }

    /**
     * target이 arr에 들어갔을 때, 정렬이 유지되는 제일 오른쪽 index를 구한다.
     * @param arr : 정렬된 배열이어야 한다.
     * @param target
     * @return
     */
    public int upper_index(int[] arr, int target) {
        int st = 0;
        int en = arr.length; // arr.length -1 이 아님을 주의
        while (st < en) {
            int mid = (st + en)/2;
            if (arr[mid] <= target) { //arr[mid] = target인 경우 st를 옮겨준다.
                st = mid + 1;
            } else if (arr[mid] > target) {
                en = mid;
            }
        }

        // 값을 찾는게 아니라 값이 들어갈 수 있는 제일 왼쪽 index를 구하는 것이므로..
        return st; //st = en으로 가능한 후보가 1개로 확정될 경우 while문을 탈출함
    }
}
