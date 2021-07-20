package dev.solar.sort;

import java.util.Arrays;

public class QuickSort {

    public static void main(String[] args) {
        int[] arr = {15, 25, 22, 357, 16, 23, -53, 12, 46, 3};
        quickSort(arr, 0, arr.length - 1);
        System.out.println(Arrays.toString(arr));

    }

    private static void quickSort(int[] arr, int left, int right) {
        // left가 rigth보다 크거나 같다면 정렬할 원소가 1개 이하이므로
        // 정렬하지 않고 return
        if (left >= right) {
            return;
        }

        //분할
        int pivot = partition(arr, left, right);

        //피벗 제외한 2개 부부 배열을 대상으로 순환 호출
        quickSort(arr, left, pivot - 1);
        quickSort(arr, pivot + 1, right);

    }

    /**
     * pivot을 기준으로 파티션을 나누기 위한 약한 정렬 메소드
     *
     * @param arr		정렬 할 배열
     * @param left	현재 배열의 가장 왼쪽 부분
     * @param right	현재 배열의 가장 오른쪽 부분
     * @return		최종적으로 위치한 피벗의 위치(lo)를 반환
     */
    private static int partition(int[] arr, int left, int right) {
        int lo = left;
        int hi = right;
        int pivot = arr[left]; //부분 리스트의 왼쪽 요소를 피벗으로 설정

        // lo가 hi보다 작을 때 까지만 반복
        while (lo < hi) {

            /*
             * hi가 lo보다 크면서, hi의 요소가 pivot보다 작거나 같은 원소를
             * 찾을 떄 까지 hi를 감소시킨다.
             */
            while (arr[hi] > pivot && lo < hi) {
                hi--;
            }

            /*
             * hi가 lo보다 크면서, lo의 요소가 pivot보다 큰 원소를
             * 찾을 떄 까지 lo를 증가시킨다.
             */
            while (arr[lo] <= pivot && lo < hi) { //주의. 여기 등호가 들어가야한다.
                lo++;
            }

            // 교환 될 두 요소를 찾았으면 두 요소를 바꾼다
            swap(arr, lo, hi);
        }

        /*
         *  마지막으로 맨 처음 pivot으로 설정했던 위치(a[left])의 원소와
         *  lo가 가리키는 원소를 바꾼다.
         */
        swap(arr, left, lo);
        return lo;
    }

    private static void swap(int[] arr, int x, int y) {
        int temp = arr[x];
        arr[x] = arr[y];
        arr[y] = temp;
    }
}
