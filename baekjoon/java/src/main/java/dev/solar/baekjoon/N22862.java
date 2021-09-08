package dev.solar.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class N22862 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(token.nextToken());
        int k = Integer.parseInt(token.nextToken());
        int[] arr = new int[n];
        token = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(token.nextToken());
        }
        int st = 0;
        int en;
        while (arr[st] % 2 != 0) { //앞에 나오는 홀수 건너뛰기
            st++;
            if (st >= n) {
                break;
            }
        }
        en = st;
        int max = 0;
        int length = 0;
        while (en < n) {
            if (k < 0) {
                max = Math.max(max, length);
                // 홀수 하나만큼 이동
                while (arr[st] % 2 == 0) {
                    st++;
                    length--;
                }
                st++;
                k++;
            }
            if (arr[en] % 2 != 0) {
                k--;
            } else {
                length++;
            }
            en++;
        }
        max = Math.max(max, length);
        System.out.println(max);
    }
}
