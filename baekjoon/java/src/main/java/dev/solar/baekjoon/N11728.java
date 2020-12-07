package dev.solar.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class N11728 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[] arr1 = new int[N];
        int[] arr2 = new int[M];
        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < N; i++) {
            arr1[i] = Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < M; i++) {
            arr2[i] = Integer.parseInt(st.nextToken());
        }
        int[] sortedArr = solution(arr1, arr2);
        for (int i : sortedArr) {
            sb.append(i).append(" ");
        }
        System.out.println(sb);
    }

    private static int[] solution(int[] arr1, int[] arr2) {
        int idx1 = 0;
        int idx2 = 0;
        int idxResult = 0;
        int arr1Len = arr1.length;
        int arr2Len = arr2.length;
        int[] result = new int[arr1Len + arr2Len];

        while (true) {
            if (idx1 == arr1Len && idx2 == arr2Len)
                return result;
            if (idx1 == arr1Len) {
                for (int j = idx2; j < arr2Len; j++) {
                    result[idxResult++] = arr2[j];
                }
                return result;
            }
            if (idx2 == arr2Len) {
                for (int j = idx1; j < arr1Len; j++) {
//                    System.out.println("arr1[" + j + "] : " + arr1[j]);
                    result[idxResult++] = arr1[j];
                }
                return result;
            }
            if (arr1[idx1] <= arr2[idx2]) {
                result[idxResult++] = arr1[idx1++];
            } else {
                result[idxResult++] = arr2[idx2++];
            }
        }
    }
}
