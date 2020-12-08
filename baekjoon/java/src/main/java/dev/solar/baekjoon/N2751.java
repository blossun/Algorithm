package dev.solar.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class N2751 {
    public static int N;
    public static int[] arr;
    public static int[] tmp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        N = Integer.parseInt(br.readLine());
        arr = new int[N];
        tmp = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
        mergeSort(0, arr.length);
        for (int i : arr) {
            sb.append(i).append('\n');
        }
        System.out.println(sb);
    }


    private static void mergeSort(int st, int en) {
        if (en == st + 1)
            return ;
        int mid = (st + en) / 2;
        mergeSort(st, mid);
        mergeSort(mid, en);
        merge(st, en);
    }

    private static void merge(int st, int en) {
        int mid = (st + en) / 2;
        int lidx = st;
        int ridx = mid;

        for (int i = st; i < en; i++) {
            if (lidx == mid) tmp[i] = arr[ridx++];
            else if (ridx == en) tmp[i] = arr[lidx++];
            else if (arr[lidx] <= arr[ridx]) tmp[i] = arr[lidx++];
            else tmp[i] = arr[ridx++];
        }

        System.arraycopy(tmp, st, arr, st, en - st);
    }
}
