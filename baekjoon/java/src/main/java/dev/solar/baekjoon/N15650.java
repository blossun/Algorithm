package dev.solar.baekjoon;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Scanner;

public class N15650 {
    static int N, size;
    static int[] arr;
    static BufferedWriter bw;

    public static void main(String []args) throws IOException {
        Scanner sc = new Scanner(System.in);
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        N = sc.nextInt();
        size = sc.nextInt();
        arr = new int[size];

        sequence(1, 0);

        bw.flush();
        bw.close();
    }

    private static void sequence(int start, int k) throws IOException { // 현재 k번째까지 선택
        if (k == size) { // size개 선택 되었다면
            // System.out.println("arr[0] : " + arr[0]);
            for (int i = 0; i < size; i++) {
                bw.write(arr[i] + " ");
            }
            bw.write("\n");
            return ;
        }

        for (int i = start; i <= N; i++) { //범위! 1부터 N포함 까지
            arr[k] = i;
            sequence(i + 1, k + 1);
        }

    }
}
