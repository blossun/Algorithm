package dev.solar.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class N1543 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[] docs = br.readLine().toCharArray();
        char[] word = br.readLine().toCharArray();
        int count = 0;
        int sIndex = 0;
        int eIndex = 0;
        while (true) {
            int wordLength = word.length;
            if (docs.length - sIndex < wordLength) break;
            for (int i = 0; i < wordLength; i++) {
                if (word[i] != docs[eIndex]) {
                    break;
                }
                eIndex++;
            }
            if (eIndex - sIndex == wordLength) {
                count++;
                sIndex = eIndex;
            } else {
                sIndex++;
                eIndex = sIndex;
            }
        }
        System.out.println(count);
    }
}
