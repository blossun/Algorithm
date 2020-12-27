package dev.solar.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class N1931 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());
        int[][] arr = new int[N][2];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            arr[i][0] = Integer.parseInt(st.nextToken());
            arr[i][1] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr, Comparator.comparingInt(a -> a[0]));
        Arrays.sort(arr, Comparator.comparingInt(a -> a[1]));
        //끝나는 시간이 빠른 회의를 선택
        int count = 1;
        int endTime = arr[0][1];
        for (int i = 1; i < N; i++) {
            if (arr[i][0] >= endTime) { //이전 회의 종료시간 이후에 시작하는 회의인 경우
                endTime = arr[i][1];
                count++;

            }
        }
        System.out.println(count);
    }
}
