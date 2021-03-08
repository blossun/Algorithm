package dev.solar.codility;

import java.util.Stack;

public class Brackets {
    public int solution(String S) {
        char[] chars = S.toCharArray();
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < chars.length; i++) {
            char ch = chars[i];
            if (ch == '{' || ch == '[' || ch == '(') {
                stack.push(ch);
                continue;
            }
            if (ch == '}') {
                if (stack.isEmpty() || stack.peek() != '{') {
                    return 0;
                }
                stack.pop();
            }
            if (ch == ']') {
                if (stack.isEmpty() || stack.peek() != '[') {
                    return 0;
                }
                stack.pop();
            }
            if (ch == ')') {
                if (stack.isEmpty() || stack.peek() != '(') {
                    return 0;
                }
                stack.pop();
            }
        }
        return stack.isEmpty() ? 1: 0;
    }
}
