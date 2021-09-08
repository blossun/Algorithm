package dev.solar.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class N2467 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);
        int[] result = solution(n, arr);
        Arrays.stream(result).forEach(s -> System.out.print(arr[s] + " "));
    }

    private static int[] solution(final int n, final int[] arr) {
        int left = 0;
        int right = n - 1;
        int diff = Integer.MAX_VALUE;
        int[] result = new int[]{left, right};
        while (left < right) {
            int sum = arr[left] + arr[right];
            if (Math.abs(sum) < diff) {
                result[0] = left;
                result[1] = right;
                diff = Math.abs(sum);
            }
            if (sum > 0) {
                right--;
            } else {
                left++;
            }
        }
        return result;
    }
}
