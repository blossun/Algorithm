package dev.solar.baekjoon;

import java.io.*;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class N11650 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());
        int[][] arr = new int[N][2];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            arr[i][0] = Integer.parseInt(st.nextToken());
            arr[i][1] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr, Comparator.comparingInt(a -> a[1]));
        Arrays.sort(arr, Comparator.comparingInt(a -> a[0]));
        for (int[] pos : arr) {
            sb.append(pos[0]).append(" ").append(pos[1]).append("\n");
        }
        System.out.println(sb);

    }
}
