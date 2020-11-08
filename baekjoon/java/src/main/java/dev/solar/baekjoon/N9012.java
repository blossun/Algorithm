package dev.solar.baekjoon;

import java.io.*;
import java.util.Stack;

public class N9012 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int testCase = Integer.parseInt(br.readLine());
        for (int i = 0; i < testCase; i++) {
            char[] cmd = br.readLine().toCharArray();
            Stack<Character> st = new Stack<>();
            boolean isVPS = true;
            for (int j = 0; j < cmd.length; j++) {
                if (cmd[j] == '(') {
                    st.push('(');
                    continue;
                } else { // ')' 인 경우
                    if (st.empty()) { // 스택이 비어있으면 false, 스택에 push되는 문자는 '(' 밖에 없으니깐 다른 비교 필요 없음
                        isVPS = false;
                        break;
                    }
                    st.pop();
                }
            }
            // 스택이 남아있으면 false
            if (!st.empty()) {
                isVPS = false;
            }
            bw.write(isVPS ? "YES\n" : "NO\n");
        }
        bw.flush();
        bw.close();
        br.close();
    }
}
