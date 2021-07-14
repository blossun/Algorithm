package dev.solar.sort;

import java.util.Arrays;

public class SelectionSort {

    public static void main(String[] args) {
        int[] arr = {15, 25, 22, 357, 16, 23, -53, 12, 46, 3};
//        int []arr = {7, 5, 9, 0, 3, 1, 6, 2, 4, 8};

        int minIndex; // 가정 적은 원소의 인덱스

        for (int i = 0; i < arr.length - 1; i++) { // i: 가장작은 값을 집어 넣을 자리
            minIndex = i;
            for (int j = i+1; j < arr.length; j++) {
                if (arr[minIndex] > arr[j]) {
                    minIndex = j;
                }
            }
            int tmp = arr[i]; //집어넣을 자리
            arr[i] = arr[minIndex];
            arr[minIndex] = tmp;
        }

        System.out.println(Arrays.toString(arr));
    }
}
