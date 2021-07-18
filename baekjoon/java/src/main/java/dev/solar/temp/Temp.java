package dev.solar.temp;

import java.util.Arrays;

public class Temp {
    public static void main(String[] args) {
        int[] arr = {3, 4, 2, 1, 5};
//        mergeSort(arr, 0, arr.length - 1);
        quickSort(arr, 0, arr.length - 1);
        System.out.println(Arrays.toString(arr));
        // 이분 탐색
        System.out.println(binarySearch(arr, 1));
        System.out.println(binarySearch(arr, 2));
        System.out.println(binarySearch(arr, 3));
        System.out.println(binarySearch(arr, 4));
        System.out.println(binarySearch(arr, 5));
        System.out.println(binarySearch(arr, 6));
    }

    private static int binarySearch(int[] arr, int n) {
        int first = 0;
        int last = arr.length - 1;
        int mid = 0;

        while (first <= last) {
            mid = (first + last) / 2;

            if (n == arr[mid]) {
                return 1;
            }
            if (n < arr[mid]) {
                last = mid - 1;
            } else {
                first = mid + 1;
            }
        }
        return 0;
    }

    private static void quickSort(int[] arr, int left, int right) {
        if (left >= right) {
            return;
        }

        // 분할
        int pivot = partition(arr, left, right);

        // 피벗 제외한 2개 부분 배열을 대상으로 순환 호출
        quickSort(arr, left, pivot - 1);
        quickSort(arr, pivot + 1, right);

    }

    private static int partition(int[] arr, int left, int right) {
        int lo = left;
        int hi = right;
        int pivot = arr[left];

        while (lo < hi) {
            while (arr[hi] > pivot && lo < hi) {
                hi--;
            }
            while (arr[lo] <= pivot && lo < hi) {
                lo++;
            }
            swap(arr, lo, hi);
        }
        /**
         * 마지막으로 처음 pivot 지정한 값을 lo와 바꿔준다.
         */
        swap(arr, left, lo);
        return lo;
    }

    private static void swap(int[] arr, int x, int y) {
        int temp = arr[x];
        arr[x] = arr[y];
        arr[y] = temp;
    }

    private static void mergeSort(int[] arr, int left, int right) {
        if (left == right) {
            return ;
        }

        int mid = (left + right) / 2;
        mergeSort(arr, left, mid);
        mergeSort(arr, mid + 1, right);
        merge(arr, left, mid, right);
    }

    private static void merge(int[] arr, int left, int mid, int right) {
        int[] L = Arrays.copyOfRange(arr, left, mid + 1);
        int[] R = Arrays.copyOfRange(arr, mid + 1, right + 1);

        int i = 0, j = 0, k = left;

        while (i < L.length && j < R.length) {
            if (L[i] <= R[j]) {
                arr[k] = L[i++];
            } else {
                arr[k] = R[j++];
            }
            k++;
        }

        // L이 남아있다면
        while (i < L.length) {
            arr[k++] = L[i++];
        }

        while (j < R.length) {
            arr[k++] = R[i++];
        }
    }
}
