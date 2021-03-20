package dev.solar.line;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Test2 {
    // 규칙 항목 위배 여부
    public boolean[] violation = new boolean[6];
    public boolean[] step2Char = new boolean[5];
    public int[] solution(String inp_str) {

        checkRule1(inp_str);
        checkRule2(inp_str);
        checkRule3();
        checkRule4(inp_str);
        checkRule5(inp_str);

        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < violation.length; i++) {
            if (violation[i]) {
                result.add(i);
            }
        }

        if (result.size() == 0) {
            int[] answer = {0};
            return answer;
        }

        int[] answer = result.stream().mapToInt(i -> i).toArray();
        return answer;
    }

    private void checkRule5(String inp_str) {
        char[] chars = inp_str.toCharArray();
        HashMap<Character, Integer> digit = new HashMap<>();
        for (Character ch : chars) {
            if (digit.containsKey(ch)) {
                int count = digit.get(ch) + 1;
                if (count >= 5) {
                    violation[5] = true;
                    return;
                }
                digit.put(ch, count);
                continue;
            }
            digit.put(ch, 1);
        }
    }

    private void checkRule4(String inp_str) {
        char[] chars = inp_str.toCharArray();
        int count = 0;
        char pre = chars[0];
        for (char ch : chars) {
            if (ch == pre) {
                count++;
                if (count >= 4) {
                    violation[4] = true;
                    return ;
                }
                continue;
            }
            pre = ch;
            count = 1;
        }
    }

    private void checkRule3() {
        int count = 0;
        for (boolean b : step2Char) {
            if (b) {
                count++;
            }
        }
        if (count < 3) {
            violation[3] = true;
        }
    }

    private void checkRule2(String inp_str) {
        char[] chars = inp_str.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            char ch = chars[i];
            if (ch >= 'A' && ch <= 'Z') {
                step2Char[1] = true;
                continue;
            }
            if (ch >= 'a' && ch <= 'z') {
                step2Char[2] = true;
                continue;
            }
            if (ch >= '0' && ch <= '9') {
                step2Char[3] = true;
                continue;
            }
            if (ch == '~' || ch == '!' || ch == '@' || ch == '#'
                    || ch == '$' || ch == '%' || ch == '^' || ch == '&' || ch == '*') {
                step2Char[4] = true;
                continue;
            }
            violation[2] = true;
        }
    }

    private void checkRule1(String inp_str) {
        if (inp_str.length() < 8 || inp_str.length() > 15) {
            violation[1] = true;
        }
    }
}
