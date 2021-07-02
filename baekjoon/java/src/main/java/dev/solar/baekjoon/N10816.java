package dev.solar.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class N10816 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        StringTokenizer stringTokenizer = new StringTokenizer(br.readLine().trim(), " ");
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(stringTokenizer.nextToken());
        }
        // 정렬 필요
        Arrays.sort(arr);

        int M = Integer.parseInt(br.readLine());
        int[] targets = new int[M];
        stringTokenizer = new StringTokenizer(br.readLine().trim(), " ");
        for (int i = 0; i < M; i++) {
            targets[i] = Integer.parseInt(stringTokenizer.nextToken());
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < M; i++) {
            // 왼쪽 인덱스 구하기
            int lower = lower_index(arr, targets[i]);
            // 오른쪽 인덱스 구하기
            int upper = upper_index(arr, targets[i]);
            sb.append(upper - lower).append(' ');
        }
        System.out.println(sb.toString());
    }

    private static int lower_index(int[] arr, int target) {
        int st = 0;
        int en = arr.length; // arr.length -1 이 아님을 주의
        while (st < en) {
            int mid = (st + en)/2;
            if (arr[mid] < target) {
                st = mid + 1;
            } else if (arr[mid] >= target) {  //arr[mid] = target인 경우 en을 옮겨준다.
                en = mid;
            }
        }

        // 값을 찾는게 아니라 값이 들어갈 수 있는 제일 왼쪽 index를 구하는 것이므로..
        return st; //st = en으로 가능한 후보가 1개로 확정될 경우 while문을 탈출함
    }

    private static int upper_index(int[] arr, int target) {
        int st = 0;
        int en = arr.length; // arr.length -1 이 아님을 주의
        while (st < en) {
            int mid = (st + en)/2;
            if (arr[mid] <= target) { //arr[mid] = target인 경우 st를 옮겨준다.
                st = mid + 1;
            } else if (arr[mid] > target) {
                en = mid;
            }
        }

        // 값을 찾는게 아니라 값이 들어갈 수 있는 제일 왼쪽 index를 구하는 것이므로..
        return st; //st = en으로 가능한 후보가 1개로 확정될 경우 while문을 탈출함
    }
}
