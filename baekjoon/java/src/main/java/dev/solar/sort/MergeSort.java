package dev.solar.sort;

import java.util.Arrays;

public class MergeSort {
    public static void main(String[] args) {
        int[] array = {230, 10, 60, 550, 40, 220, 20};

        mergeSort(array, 0, array.length - 1);
        System.out.println(Arrays.toString(array));
    }

    private static void mergeSort(int[] array, int left, int right) {
        /*
         *  left==right 즉, 부분리스트가 1개의 원소만 갖고있는경우
         *  더이상 쪼갤 수 없으므로 return한다.
         */
        if (left == right) {
            return;
        }

        int mid = (left + right) / 2; // 절반 위치

        mergeSort(array, left, mid); // 절반 중 왼쪽 부분리스트(left ~ mid)
        mergeSort(array, mid + 1, right); // 절반 중 오른쪽 부분리스트(mid+1 ~ right)
        merge(array, left, mid, right); // 병합작업
    }

    private static void merge(int[] array, int left, int mid, int right) {
        // 기존 array에 새롭게 값을 채운다.
        // 원래 값은 L, R 배열에 복사해서 넣고 비교
        int[] L = Arrays.copyOfRange(array, left, mid + 1);
        int[] R = Arrays.copyOfRange(array, mid + 1, right + 1);

        int i = 0, j = 0, k = left; //K: 집어넣을 위치의 인덱스

        while (i < L.length && j < R.length) {
            if (L[i] <= R[j]) { //L의 값이 더 작으면 L의 값을 채워넣는다.
                array[k] = L[i++];
            } else {
                array[k] = R[j++];
            }
            k++;
        }

        // L배열이 남아있다면 채워 넣어준다.
        while (i < L.length) {
            array[k++] = L[i++];
        }

        // R배열이 남아있다면 채워 넣어준다.
        while (j < R.length) {
            array[k++] = R[j++];
        }

    }
}
