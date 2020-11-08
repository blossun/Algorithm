package dev.solar.baekjoon;

import java.io.*;
import java.util.Stack;

public class N5397 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());

        for (int i = 0; i < n; i++) {
            char[] keyLoger = br.readLine().toCharArray();
            Stack<Character> left = new Stack<>();
            Stack<Character> right = new Stack<>();
            for (char c : keyLoger) {
                if (c == '<') {
                    if (!left.empty()) {
                        right.push(left.pop());
                    }
                } else if (c == '>') {
                    if (!right.empty()) {
                        left.push(right.pop());
                    }
                } else if (c == '-') {
                    if (!left.empty()) {
                        left.pop();
                    }
                } else { //문자인 경우
                    left.push(c);
                }
            }
            // 모든 문자를 right 스택으로 이동
            while (!left.empty()) {
                right.push(left.pop());
            }
            // 문자 출력
            while (!right.empty()) {
                bw.write(right.pop());
            }
            bw.write('\n');
        }
        bw.flush();
        bw.close();
        br.close();
    }


}

/*
입력은 한번에 br로 받아서 처리해야할듯
입력문자가 영문 A~Z,a~z인 경우?? (특수키가 아닌경우) 저장하는 스택 1 -> x
특수키(지우기, 커서 위치 이동)를 저장하는 스택 2 -> x

커서를 기준으로
왼쪽 문자 스택 : left
오른쪽 문자 스택 : right
각 키입력마다에 따라 push, pop을 진행
 */
