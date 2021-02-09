package dev.solar.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class N1431 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        List<Word> arr = new ArrayList<>();
        while( T-- > 0) {
            arr.add(new Word(br.readLine()));
        }
        Collections.sort(arr);
        Iterator<Word> it = arr.iterator();
        while (it.hasNext()) {
            sb.append(it.next().str).append('\n');
        }
        System.out.println(sb);
    }

    private static class Word implements Comparable<Word>{
        Integer length;
        String str;

        public Word(String str) {
            this.length = str.length();
            this.str = str;
        }


        @Override
        public int compareTo(Word o) {
            if (this.length == o.length) { //글자수가 같은 경우 숫자 비교
                int sumThis = 0;
                for (char c : str.toCharArray()) {
                    if (c >= '0' && c <= '9') {
                        sumThis += c - '0'; //숫자값들만 더함
                    }
                }
                int sumOther = 0;
                for (char c : o.str.toCharArray()) {
                    if (c >= '0' && c <= '9') {
                        sumOther += c - '0'; //숫자값들만 더함
                    }
                }
                if (sumThis != sumOther) {
                    return sumThis - sumOther;
                }
                return this.str.compareTo(o.str);
            }
            return this.length - o.length;
        }
    }
}
