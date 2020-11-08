package dev.solar.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class N4889 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int n = 1;
        while (true) {
            String line = br.readLine();
            if (line.contains("-"))
                break;
            char[] cmd = line.toCharArray();
            Stack<Character> st = new Stack<>();
            int count = 0;
            for (int i = 0; i < cmd.length; i++) {
                if (cmd[i] == '}') {
                    if (st.empty() || st.peek() != '{') {
                        st.push('{');
                        count++;
                    } else {
                        st.pop();
                    }
                } else {
                    st.push('{');
                }
            }
            if (!st.empty()) {
                count += st.size() / 2;
            }
            sb.append(n + ". " + count + "\n");
            n++;
        }
        System.out.println(sb);
    }
}

/*
* '}' 인 경우
peek이 '{' 이면 -> pop 하고 넘어감
empty 이거나 '{'이 아니면 -> count + 1 하고, '{'로 바꿔서 push
* '{' 인 경우
일단 다 push
cmd가 끝나고 스택에 '{' 가 남아있다면, size/2 만큰 count에 플러스한다. 스택에 남은 '{'의 반은 '}'로 바꿔주기 위해서)
 */
