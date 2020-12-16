package dev.solar.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class N1912 {
    static int mx = Integer.MIN_VALUE;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] d = new int[N]; //i 번째 항을 마지막으로 사용하는 수열의 합 중 최댓값
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        d[0] = Integer.parseInt(st.nextToken());
        for (int i = 1; i < N; i++) {
            d[i] = Math.max(0, d[i - 1]) + Integer.parseInt(st.nextToken()); //음수면 버리고 아니라면 합해서 저장
        }
        for (int i : d) {
            mx = Math.max(mx, i);
        }
        System.out.println(mx);
    }
}
