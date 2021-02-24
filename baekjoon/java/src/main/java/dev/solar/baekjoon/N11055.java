package dev.solar.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
import java.util.stream.Stream;

public class N11055 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N + 1];
        int[] result = new int[N + 1];

        st = new StringTokenizer(br.readLine());
        // D[i] : i번쨰 원소를 마지막으로 사용하는 수열 중 최대 합
        arr[1] = Integer.parseInt(st.nextToken()); //첫 항 설정
        result[1] = arr[1];
        for (int i = 2; i < N + 1; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            result[i] = arr[i];
            for (int j = 0; j < i; j++) {
                if (arr[j] < arr[i]) { // 증가하는 경우에만 합할 수 있다.
                    result[i] = Math.max(result[i], result[j] + arr[i]); //기존에 구한 D[i]보다 더 놓은 D[i]가 나오면 갱신
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
