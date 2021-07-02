package dev.solar.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class N1920 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        StringTokenizer stringTokenizer = new StringTokenizer(br.readLine().trim(), " ");
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(stringTokenizer.nextToken());
        }
        Arrays.sort(arr);

        int M = Integer.parseInt(br.readLine());
        int[] targets = new int[M];
        int[] answer = new int[M];
        stringTokenizer = new StringTokenizer(br.readLine().trim(), " ");
        for (int i = 0; i < M; i++) {
            targets[i] = Integer.parseInt(stringTokenizer.nextToken());
        }
        for (int i = 0; i < M; i++) {
            int target = targets[i];
            int st = 0;
            int en = N - 1;
            while (st <= en) {
                int mid = (st + en) / 2;
                if (arr[mid] < target) {
                    st = mid + 1;
                } else if (arr[mid] > target) {
                    en = mid - 1;
                } else {
                    answer[i] = 1;
                    break;
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        Arrays.stream(answer).forEach(n -> sb.append(n).append('\n'));
        System.out.println(sb.toString());
    }
}
