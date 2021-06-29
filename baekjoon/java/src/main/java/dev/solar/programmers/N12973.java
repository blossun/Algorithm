package dev.solar.programmers;

import java.util.Stack;

public class N12973 {
    public int solution(String s) {
        Stack<Character> left = new Stack<>();
        char[] chars = s.toCharArray();
        for (char ch : chars) {
            if (!left.isEmpty() && left.peek() == ch) {
                left.pop();
                continue;
            }
            left.push(ch);
        }

        return left.isEmpty() ? 1 : 0;
    }
}
