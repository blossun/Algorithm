package dev.solar.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class N15657 {
    static int N, M;
    static int[] nums; // 수열 대상이 되는 숫자
    static int[] arr; // 뽑힌 수열
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        nums = new int[N];
        arr = new int[M];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(nums);
        bt(0, 0);
        System.out.println(sb);
    }

    private static void bt(int start, int k) { // K번째 수 뽑기
        if (k == M) {
            for (int i : arr) {
                sb.append(i).append(' ');
            }
            sb.append('\n');
            return ;
        }

        for (int i = start; i < N; i++) {
            arr[k] = nums[i];
            bt(i, k + 1);
        }
    }
}
