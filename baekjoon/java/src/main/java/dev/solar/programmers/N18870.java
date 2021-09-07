package dev.solar.programmers;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class N18870 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            int num = Integer.parseInt(st.nextToken());
            arr[i] = num;
        }

        // 배열 복사 후, 정렬
        int[] copy = arr.clone();
        Arrays.sort(copy);

        // 배열 중복 항목 제거
        int[] compact = new int[n];
        int index = 1;
        compact[0] = copy[0];

        for (int i = 1; i < n; i++) {
            if (compact[index - 1] != copy[i]) {
                compact[index] = copy[i];
                index++;
            }
        }

        // 압축
        for (int i = 0; i < n; i++) {
            int tmp = Arrays.binarySearch(compact, 0, index, arr[i]);
            arr[i] = tmp; //압축 값으로 변환
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            sb.append(arr[i]).append(" ");
        }

        System.out.println(sb.toString());
    }
}
