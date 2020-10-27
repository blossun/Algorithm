package dev.solar.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class N4949 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        while (true) {
            Stack<Character> st = new Stack<>(); //매번 스택 초기화되어야되는 위치
            boolean isYes = true;
            char[] str = br.readLine().toCharArray();
            if (str.length == 1 && str[0] == '.') {
                break;
            }
            for (int i = 0; i < str.length; i++) {
                char ch = str[i];
                if (ch == '[' || ch == '(') {
                    st.push(ch);
                } else if (ch == ']' || ch == ')') {
                    // 스택이 비어있다면 no
                    if (st.empty()) {
                        isYes = false;
                        break;
                    }
//                    System.out.println("st.peek : " + st.peek() + ", ch : " + ch);
                    if ((ch == ']' && st.peek() == '[') || (ch == ')' && st.peek() == '(')) { //쌍이 맞는경우
                        st.pop();
                    } else { //ch 와 최상위 스택 괄호와 짝이 안맞으면 no
                        isYes = false;
                        break;
                    }
                }
            }
//            System.out.println("stack : " + st);
            // 스택에 괄호가 남아있다면 no
            if (!st.empty()) {
                isYes = false;
            }
            if (isYes) {
                sb.append("yes\n");
            } else {
                sb.append("no\n");
            }
        }
        System.out.println(sb);
    }
}
