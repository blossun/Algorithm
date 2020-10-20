package dev.solar.baekjoon;

import java.io.*;

public class N10808 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        char[] chars = br.readLine().toCharArray();
        int[] alpha = new int[26];
        for (char c : chars) {
            alpha[(int)c - 'a']++;
        }
        for (int i : alpha) {
            bw.write(i + " ");
        }
        bw.flush();
        bw.close();
        br.close();
    }
}
