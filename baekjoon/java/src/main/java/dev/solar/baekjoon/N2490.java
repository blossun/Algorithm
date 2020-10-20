package dev.solar.baekjoon;

import java.io.*;
import java.util.Arrays;
import java.util.stream.IntStream;

public class N2490 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int[] numbs = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        bw.write(mapping(IntStream.of(numbs).sum()) + "\n");
        numbs = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        bw.write(mapping(IntStream.of(numbs).sum()) + "\n");
        numbs = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        bw.write(mapping(IntStream.of(numbs).sum()) + "\n");
        bw.flush();
        bw.close();
        br.close();
    }

    public static char mapping(int n) {
        if (n == 4) {
            return 'E';
        } else if (n == 3) {
            return 'A';
        } else if (n == 2) {
            return 'B';
        } else if (n == 1) {
            return 'C';
        }
        return 'D';
    }
}
