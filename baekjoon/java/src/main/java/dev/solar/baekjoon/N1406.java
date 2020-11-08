package dev.solar.baekjoon;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class N1406 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
//        solvWithList(br, bw); // 연결리스트로 풀이 -> 시간초과
        char[] charText = br.readLine().toCharArray();
        Stack<String> left = new Stack<>();
        Stack<String> right = new Stack<>();
        for (char c : charText) {
            left.push(String.valueOf(c));
        }
        int m = Integer.parseInt(br.readLine());
        String cmd;
        for (int i = 0; i < m; i++) {
            cmd = br.readLine();
            if (cmd.startsWith("P")) {
                left.push(cmd.substring(2));
            } else if (cmd.equals("L")) {
                if (!left.empty()) {
                    right.push(left.pop());
                }
            } else if (cmd.equals("D")) {
                if (!right.empty()) { // (커서가 문장의 맨 뒤이면 무시됨) //backText가 비어있으면 무시
                    left.push(right.pop());
                }
            } else if (cmd.equals("B")) {
                if (!left.empty()) {
                    left.pop();
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        // left 스택의 모든 문자를 right 스택으로 모두 옮김
        while (!left.empty()) {
            right.push(left.pop());
        }
        // right 스택의 모든 문자를 꺼내서 문자열로 만듦
        while(!right.empty()) {
            bw.write(right.pop());
        }
        bw.flush();
        bw.close();
        br.close();
    }

    private static void solvWithList(BufferedReader br, BufferedWriter bw) throws IOException {
        List<String> text = new ArrayList<>(); //문자열 -> char 배열 -> List
        char[] charText = br.readLine().toCharArray();
        for (char c : charText) {
            text.add(String.valueOf(c));
        }
        int m = Integer.parseInt(br.readLine());
        int index = text.size();
        String cmd;
        for (int i = 0; i < m; i++) {
            cmd = br.readLine();
            if (cmd.startsWith("P")) {
                text.add(index, cmd.substring(2));
                index++;
            } else if (cmd.startsWith("L")) {
                if (index != 0) {
                    index--;
                }
            } else if (cmd.startsWith("D")) {
                if (index < text.size()) {
                    index++;
                }
            } else if (cmd.startsWith("B")) {
                if (index != 0) {
                    index--;
                    text.remove(index);
                }
            }
        }
        for (String s : text) {
            bw.write(s);
        }
        bw.flush();
        bw.close();
    }
}

/*
연결리스트로 로직은 알겠는데 스택으로는 어떻게 처리하지?
해당 커서 위치를 기준으로 두 개의 스택을 가지고 구현해야하나?
커서를 기준으로
앞 text를 가진 스택 1 - left
뒤 text를 가진 스택 2 - right
두개의 스택을 가지고 빠르게 입력 출력을 진행해야 시간초과가 나지 않는다.
 */
