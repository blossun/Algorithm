package dev.solar.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class N1439 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();

        Stack<Character> stack = new Stack<>();
        char preChar = str.charAt(0);
        stack.add(preChar);
        int cnt = 0;
        for (int i = 1; i < str.length(); i++) {
            if (str.charAt(i) != preChar) {
                preChar = str.charAt(i);
                if (stack.isEmpty()) {
                    stack.add(preChar);
                    continue;
                }
                stack.pop();
                cnt++;
            }
        }
        System.out.println(cnt);
    }
}
