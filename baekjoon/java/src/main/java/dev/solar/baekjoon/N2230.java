package dev.solar.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class N2230 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] split = br.readLine().split(" ");
        int N = Integer.parseInt(split[0]);
        int M = Integer.parseInt(split[1]);
        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(arr); //정렬해야 이분탐색할 수 있다.
//        int min = binarySearch(N, M, arr);
        int min = towPointer(N, M, arr);
        System.out.println(min);
    }

    private static int towPointer(final int n, final int m, final int[] arr) {
        int min = Integer.MAX_VALUE;
        int en = 0;
        for (int st = 0; st < n; st++) {
            while (en < n && arr[en] - arr[st] < m) en++; //조건에 맞는 en을 찾을 때까지 index를 증가
            if (en == n) break; //en이 범위를 벗어나면 종료
            min = Math.min(min, arr[en] - arr[st]);
        }
        return min;
    }

    private static int binarySearch(final int n, final int m, final int[] arr) {
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            int index = lowerBound(arr, arr[i] + m);
//            System.out.println(arr[i] + M + ", " + index);
            if (index >= n) continue;
            min = Math.min(min, arr[index] - arr[i]);
        }
        return min;
    }

    private static int lowerBound(final int[] arr, final int target) {
        int st = 0;
        int en = arr.length;
        while (st < en) {
            int mid = (st + en) / 2;
            if (arr[mid] < target) {
                st = mid + 1;
            } else {
                en = mid;
            }
        }
        return st;
    }
}
