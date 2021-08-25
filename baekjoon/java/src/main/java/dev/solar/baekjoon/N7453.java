package dev.solar.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class N7453 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());
        int[][] arr = new int[4][N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 4; j++) {
                arr[j][i] = Integer.parseInt(st.nextToken());
            }
        }

        int size = N * N;
        int[] AB = new int[size];
        int[] CD = new int[size];
        int idx = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
//                AB[idx] = arr[0][i] + arr[1][j];
                CD[idx] = arr[2][i] + arr[3][j];
                idx++;
            }
        }

        Arrays.sort(CD);
        int answer = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                int number = arr[0][i] + arr[1][j];
                int upper = upperBound(CD, -number);
                int lower = lowerBound(CD, -number);
                answer += (upper - lower);
            }
        }
        System.out.println(answer);
    }

    public static int lowerBound(int[] arr, int target) {
        int st = 0;
        int en = arr.length;

        while (st < en) {
            int mid = (st + en) / 2;
            if (arr[mid] < target) {
                st = mid + 1;
            } else if (arr[mid] >= target) {
                en = mid;
            }
        }
        return st;
    }

    public static int upperBound(int[] arr, int target) {
        int st = 0;
        int en = arr.length;

        while (st < en) {
            int mid = (st + en) / 2;
            if (arr[mid] <= target) {
                st = mid + 1;
            } else if (arr[mid] > target) {
                en = mid;
            }
        }
        return st;
    }
}
