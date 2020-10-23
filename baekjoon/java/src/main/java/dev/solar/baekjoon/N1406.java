package dev.solar.baekjoon;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class N1406 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
//        solvWithList(br, bw);
        char[] charText = br.readLine().toCharArray();
        Stack<String> left = new Stack<>();
        Stack<String> right = new Stack<>();
        for (char c : charText) {
            left.push(String.valueOf(c));
        }
        int m = Integer.parseInt(br.readLine());
        int index = left.size();
        String cmd;
        for (int i = 0; i < m; i++) {
            cmd = br.readLine();
            if (cmd.startsWith("P")) {
                left.push(cmd.substring(2));
                index++;
            } else if (cmd.equals("L")) {
                if (index != 0) {
                    index--;
                    for (int j = index; j < left.size(); j++) { //무조건 하나인가?
                        right.push(left.pop());
                    }
                }
            } else if (cmd.equals("D")) {
                if (right.size() != 0) { // (커서가 문장의 맨 뒤이면 무시됨) //backText가 비어있으면 무시
                    index++;
                    left.push(right.pop());
                }
            } else if (cmd.equals("B")) {
                if (index != 0) {
                    index--;
                    left.pop();
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        while (!left.empty()) {
//            sb.insert(0, frontText.pop());
            bw.write(left.pop(), 0, 1);
        }
        while(!right.empty()) {
//            sb.append(backText.pop());
            bw.write(right.pop());
        }
//        System.out.println(sb.toString());
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
앞 text를 가진 스택 1
뒤 text를 가진 스택 2
 */
