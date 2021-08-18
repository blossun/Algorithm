package dev.solar.programmers;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class N76502 {
    public int solution(String s) {
        int lenght = s.length();
        Queue<Character> queue = new LinkedList<>();
        for (int i = 0; i < lenght; i++) {
            queue.offer(s.charAt(i));
        }

        int answer = 0;
        for (int i = 0; i < lenght; i++) {
            String string = queue.toString();
            char[] chars = string.substring(1, string.length() - 1).replaceAll(", ", "").toCharArray();
            if (isCorrect(chars)) {
                answer++;
            }
            queue.offer(queue.poll());
        }

        return answer;
    }

    private boolean isCorrect(final char[] chars) {
        Stack<Character> stack = new Stack<>();
        int length = chars.length;
        for (int i = 0; i < length; i++) {
            char ch = chars[i];
            if (ch == '[' || ch == '(' || ch == '{') {
                stack.push(ch);
            } else {
                if (stack.isEmpty()) {
                    return false;
                }
                Character pop = stack.pop();
                switch (ch) {
                    case ']':
                        if (pop != '[') {
                            return false;
                        }
                        break;
                    case '}':
                        if (pop != '{') {
                            return false;
                        }
                        break;
                    case ')':
                        if (pop != '(') {
                            return false;
                        }
                }
            }
        }
        return stack.isEmpty();
    }

}
