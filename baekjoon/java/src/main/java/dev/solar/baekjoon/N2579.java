package dev.solar.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class N2579 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N + 1];
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
        System.out.println(solution(N, arr));
    }

    public static int solution(int n, int[] arr) {
        int[][] result = new int[n + 1][3]; //1계단, 2계단만 필요하지만 편의상 1-> 한칸째, 2->두칸째로 보기 편하게 크기를 잡음
        result[0][1] = 0;
        result[0][2] = 0;
        result[1][1] = arr[0];
        result[1][2] = 0;
        for (int i = 2; i < n + 1; i++) {
            result[i][1] = Math.max(result[i - 2][1], result[i - 2][2]) + arr[i - 1];
            result[i][2] = result[i - 1][1] + arr[i - 1];
        }
        return (Math.max(result[n][1], result[n][2]));
    }
}
