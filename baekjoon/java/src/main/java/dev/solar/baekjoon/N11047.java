package dev.solar.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class N11047 {
    public static void main(String[] args) throws IOException {
        // 명제 : 가치가 더 큰 동전을 최대한 많이 사용해야함
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int[] coins = new int[N];
        for (int i = 0; i < N; i++) {
            coins[i] = Integer.parseInt(br.readLine());
        }
        int total = 0;
        for (int i = N - 1; i >= 0; i--) {
            if (K == 0)
                break;
            while (true) {
                if (K / coins[i] == 0)
                    break;
                K -= coins[i];
                total++;
            }
        }
        System.out.println(total);
    }
}
