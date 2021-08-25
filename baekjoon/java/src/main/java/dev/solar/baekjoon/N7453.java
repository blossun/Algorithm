package dev.solar.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class N7453 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());
        int[][] arr = new int[4][N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 4; j++) {
                arr[j][i] = Integer.parseInt(st.nextToken());
            }
        }

        int size = N * N;
        int[] AB = new int[size];
        int[] CD = new int[size];
        int idx = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                AB[idx] = arr[0][i] + arr[1][j];
                CD[idx] = arr[2][i] + arr[3][j];
                idx++;
            }
        }

        Arrays.sort(AB);
        Arrays.sort(CD);

        long answer = 0;
        int leftIndex = 0;
        int rightIndex = size - 1;
        while (leftIndex < size && rightIndex >= 0) {
            int leftValue = AB[leftIndex];
            int rightValue = CD[rightIndex];

            int sum = leftValue + rightValue;
            if (sum == 0) {
                long leftCount = 0;// AB에 중복된 갯수
                long rightCount = 0;// CD에 중복된 갯수

                while (leftIndex < size && AB[leftIndex] == leftValue) {
                    leftCount++;
                    leftIndex++;
                }

                while (rightIndex >= 0 && CD[rightIndex] == rightValue) {
                    rightCount++;
                    rightIndex--;
                }

                answer += leftCount * rightCount; //경우의 수는 n * n
            } else if (sum > 0) { //right의 값이 더 크다는 의미니깐
                rightIndex--;
            } else {
                leftIndex++;
            }
        }

        System.out.println(answer);
    }
}
