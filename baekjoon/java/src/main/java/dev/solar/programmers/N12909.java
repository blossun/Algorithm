package dev.solar.programmers;

import java.util.Stack;

public class N12909 {
    boolean solution(String s) {
        boolean answer = true;
        char[] ch = s.toCharArray();
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < ch.length; i++) {
            if (ch[i] == '(') {
                stack.push(ch[i]);
                continue;
            }
            if (ch[i] == ')') {
                if (stack.isEmpty() || stack.pop() != '(') {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }
}
