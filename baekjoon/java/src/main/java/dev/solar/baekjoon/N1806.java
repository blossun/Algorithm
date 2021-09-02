package dev.solar.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class N1806 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] split = br.readLine().split(" ");
        int N = Integer.parseInt(split[0]);
        int S = Integer.parseInt(split[1]);
        int[] arr = new int[N];
        StringTokenizer token = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(token.nextToken());
        }
        // 5 1 3 5 10 7 4 9 2 8
        // 15 -> 5, 10
        int min = Integer.MAX_VALUE;
        int en = 0;
        int sum = arr[0];
        for (int st = 0; st < N; st++) {
            while (en < N && sum < S) {
                en++;
                if (en != N) sum += arr[en];
            }
            if (en == N) break;
            min = Math.min(min, en - st + 1);
            sum -= arr[st];
        }
        if (min == Integer.MAX_VALUE) min = 0;
        System.out.println(min);
    }
}
