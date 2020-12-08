package dev.solar.baekjoon;

public class QuickSort {
    private int[] arr;

    public static void main(String[] args) {
        int[] arr = {15, 25, 22, 357, 16, 23, -53, 12, 46, 3};
        QuickSort qs = new QuickSort();
        int[] result = qs.sort(arr);
        for (int i : result) {
            System.out.println(i);
        }
    }

    public int[] sort(int[] arr) {
        this.arr = arr;
        quickSort(0, arr.length);
        return arr;
    }

    private void quickSort(int st, int en) {
        System.out.println("st : " + st + ", en : " + en);
        if (st + 1 == en)
            return ;
        int pivotPos = quick(st, en);
        quickSort(st, pivotPos);
        quickSort(pivotPos, en);
    }

    private int quick(int st, int en) {
        int pivot = arr[st];
        int lidx = st + 1;
        int ridx = en - 1;
        while (true) {
            //l은 pivot보다 큰 값이 나올 때 까지 오른쪽으로 이동
            while (lidx < en) {
                if (arr[lidx] > pivot)
                    break;
                lidx++;
            }
            //r은 pivot보다 작거나 같은 값이 나올 때 까지 왼쪽으로 이동
            while (ridx > st) {
                if (arr[ridx] < pivot)
                    break;
                ridx--;
            }
            System.out.println("lidx : " + lidx + ", ridx : " + ridx);
            if (ridx < lidx) {
                arr[st] = arr[ridx];
                arr[ridx] = pivot;
                return ridx;
            } else {
                int tmp = arr[lidx];
                arr[lidx] = arr[ridx];
                arr[ridx] = tmp;
            }
        }
    }
}
