package dev.solar.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class N11722 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N + 1];
        int[] result = new int[N + 1];

        // D[i] : i번째 항을 마지막으로 사용할 때 가장 긴 감소하는 수열의 길이
        // 첫 항 초기화
        st = new StringTokenizer(br.readLine());
        arr[1] = Integer.parseInt(st.nextToken());
        result[1] = 1;
        for (int i = 2; i < N + 1; i++) { //2부터 시작
            arr[i] = Integer.parseInt(st.nextToken());
            result[i] = 1;
            for (int j = 0; j < i; j++) {
                if (arr[j] > arr[i]) { //i번쨰 값이 감소하는 경우라면
                    result[i] = Math.max(result[i], result[j] + 1);
                }
            }
        }

//        System.out.println(Arrays.toString(result));
        int max = -1;
        for (int i : result) {
            max = Math.max(max, i);
        }
        System.out.println(max);
    }
}
