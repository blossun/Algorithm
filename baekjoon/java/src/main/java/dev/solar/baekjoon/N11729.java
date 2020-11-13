package dev.solar.baekjoon;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Scanner;

public class N11729 {
    static BufferedWriter bw;
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = sc.nextInt();
        System.out.println((int) Math.pow(2, N) - 1);
        hanoi(1, 3, N);
        bw.flush();
        bw.close();
    }

    static void hanoi(int from, int to, int n) throws IOException {

        if (n == 1) { //base condition
            bw.write(from + " " + to + "\n");
            return ;
        }

        // from : 1, to : 3 -> next :
        // K : N 일 떄
        // N-1 은 1 -> 2
        // N 은 1 -> 3
        // N-1 은 2 - > 3
        hanoi(from, 6 - from - to, n - 1);
//        hanoi(from, to, n); //여기서 호출하는 것 아님
        bw.write(from + " " + to + "\n");
        hanoi(6 - from - to, to, n - 1);
    }
}
