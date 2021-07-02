package dev.solar.programmers;

import java.util.Stack;

public class N60058 {
    public String solution(String p) {
        if (p.isEmpty()) {
            return "";
        }

        if (isCorrect(p)) {
            return p;
        }

        // 문자열 w를 두 "균형잡힌 괄호 문자열" u, v로 분리
        int index = splitString(p);
        String u = p.substring(0, index + 1);
        String v = p.substring(index + 1);
        if (isCorrect(u)) {
            return u + solution(v);
        } else {
            String str = "(";
            str += solution(v);
            str += ")";
            str += reverse(u.substring(1, u.length() - 1));
            return str;
        }
    }

    private String reverse(String str) {
        char[] chars = str.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == '(') {
                chars[i] = ')';
            } else {
                chars[i] = '(';
            }
        }
        return String.valueOf(chars);
    }

    private boolean isCorrect(String str) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == '(') {
                stack.push(str.charAt(i));
            } else { //')'인 경우
                if (stack.isEmpty()) {
                    return false;
                }
                stack.pop();
            }
        }
        return stack.isEmpty();
    }

    private int splitString(String p) {
        int countOfOpen = 0;
        int countOfClose = 0;
        for (int i = 0; i < p.length(); i++) {
            if (p.charAt(i) == '(') {
                countOfOpen++;
            } else {
                countOfClose++;
            }
            if (countOfOpen == countOfClose) {
                return i;
            }
        }
        return 0;
    }
}
