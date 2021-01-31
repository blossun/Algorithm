package dev.solar.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class N1181 {

    public static TreeSet<Word> arr = new TreeSet<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());
        for (int i = 0; i < N; i++) {
            arr.add(new Word(br.readLine().trim()));
        }
        Iterator<Word> it = arr.iterator();
        while (it.hasNext()) {
            sb.append(it.next().str).append("\n");
        }
        System.out.println(sb);

    }

    private static class Word implements Comparable<Word> {
        private Integer length;
        private String str;

        public Word(String str) {
            this.length = str.length();
            this.str = str;
        }

        @Override
        public int compareTo(Word o) {
            if (this.length < o.length) {
                return -1;
            } else if (this.length == o.length) {
                if (this.str.equals(o.str)) {
                    return 0;
                } else { //compareTo() 양수 : 호출하는 객체가 인자보다 사전적으로 순서가 압설 때
                    return this.str.compareTo(o.str);
                }
            } else {
                return 1;
            }
        }
    }
}
