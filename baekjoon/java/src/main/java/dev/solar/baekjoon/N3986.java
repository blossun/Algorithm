package dev.solar.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class N3986 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int result = 0;
        while (N-- > 0) {
            Stack<Character> stack = new Stack<>();
            String str = br.readLine();
            for (int i = 0; i < str.length(); i++) {
                if (!stack.isEmpty() && stack.peek() == str.charAt(i)) {
                    stack.pop();
                    continue;
                }
                stack.push(str.charAt(i));
            }
            if (stack.isEmpty()) {
                result++;
            }
        }
        System.out.println(result);
    }
}
