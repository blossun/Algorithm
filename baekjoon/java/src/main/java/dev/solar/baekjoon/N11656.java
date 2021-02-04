package dev.solar.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class N11656 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        char[] S = br.readLine().toCharArray();
        char[][] arr = new char[S.length][S.length];

        for (int i = 0; i < S.length; i++) {
            char ch = S[i];
            for (int x = i; x < i + 1; x++) {
                for (int y = 0; y < i + 1; y++) {
                    arr[y][x] = ch;
                }
            }
        }
        List<String> list = new LinkedList<>();
        for (char[] chars : arr) {
            list.add(String.valueOf(chars).trim());
//            System.out.println(String.valueOf(chars).trim());
        }
        Collections.sort(list);
        for (String s : list) {
            sb.append(s).append('\n');
        }
        System.out.println(sb);
    }
}
