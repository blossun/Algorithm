package dev.solar.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class N11652 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        long[] arr = new long[N];

        for (int i = 0; i < N; i++) {
            arr[i] = Long.parseLong(br.readLine());
        }

        Arrays.sort(arr);

        int maxCnt = 1; //0으로 잘못 카운트 했음
        int cnt = 1;
        long maxCntNumber = arr[0];

        for (int i = 1; i < N; i++) {
            if (arr[i - 1] != arr[i]) {
                cnt = 1;
            } else {
                cnt++;
            }
            if (maxCnt < cnt) {
                maxCnt = cnt;
                maxCntNumber = arr[i];
            }
        }

        System.out.println(maxCntNumber);

    }
}
