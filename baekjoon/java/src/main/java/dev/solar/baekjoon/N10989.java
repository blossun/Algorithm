package dev.solar.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class N10989 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());
        int[] input = new int[10002];
        for (int i = 0; i < N; i++) {
            int num = Integer.parseInt(br.readLine());
            input[num]++;
        }
        for (int i = 0; i < 10002; i++) {
            for (int j = 0; j < input[i]; j++) {
                sb.append(i).append('\n');
            }
        }
        System.out.println(sb);
    }
}
