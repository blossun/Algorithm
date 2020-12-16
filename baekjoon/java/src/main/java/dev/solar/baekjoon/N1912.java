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
        int[] d = new int[N]; //각 인덱스를 시작값으로 해서 누적된 값만 저장
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < N; i++) {
            int num = Integer.parseInt(st.nextToken());
            for (int j = 0; j < i + 1; j++) {
                d[j] = d[j] + num;
                mx = Math.max(mx, d[j]);
            }
        }
        System.out.println(mx);
    }
}
