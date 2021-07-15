package dev.solar.sort;

import java.util.Arrays;

public class MergeSort2 {

    public static void main(String[] args) {
        int[] arr = {10, 2, 4, 1, 11, 9, 3};

        mergeSort(arr, 0, arr.length - 1);
        System.out.println(Arrays.toString(arr));
    }

    private static void mergeSort(int[] arr, int left, int right) {
        if (left == right) {
            return;
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

        // R이 남아있다면
        while (j < R.length) {
            arr[k++] = R[j++];
        }
    }
}
