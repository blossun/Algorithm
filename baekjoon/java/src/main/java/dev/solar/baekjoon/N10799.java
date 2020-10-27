package dev.solar.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class N10799 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[] cmd = br.readLine().toCharArray();
        Stack<Character> st = new Stack<>();
        int count = 0;
        for (int i = 0; i < cmd.length; i++) {
            if (cmd[i] == '(') {
                // '(' 인경우와 '()'인 경우 구분
                if (cmd[i+1] == ')') { // 레이저인 경우
                    count += st.size();
                    i++;
                } else {
                    st.push('(');
                }
            } else if (cmd[i] == ')') {
                st.pop();
                count++;
            }

        }
        System.out.println(count);
        br.close();
    }
}
