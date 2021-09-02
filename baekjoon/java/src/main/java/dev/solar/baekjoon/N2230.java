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
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < N; i++) {
            int index = lowerBound(arr, arr[i] + M);
//            System.out.println(arr[i] + M + ", " + index);
            if (index >= N) continue;
            min = Math.min(min, arr[index] - arr[i]);
        }
        System.out.println(min);
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
