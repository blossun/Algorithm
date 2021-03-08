package dev.solar.codility;

import java.util.Stack;

public class Nesting {
    public int solution(String S) {
        char[] chars = S.toCharArray();
        Stack<Character> stack = new Stack<>();
        for (char ch : chars) {
            if (ch == '(') {
                stack.push(ch);
                continue;
            }
            if (ch != ')') {
                continue;
            }
            if (stack.isEmpty() || stack.peek() != '(') {
                return 0;
            }
            stack.pop();
        }
        return stack.isEmpty() ? 1 : 0;
    }
}
