package dev.solar.temp;

public class Woo03 {
    public String solution(String word) {
        StringBuilder sb = new StringBuilder();
        int length = word.length();
        for (int i = 0; i < length; i++) {
            char ch = word.charAt(i);
            if ('A' <= ch && ch <= 'Z') {
                int re = 'Z' - (ch - 'A');
                sb.append(Character.toChars(re));
            } else if ('a' <= ch && ch <= 'z') {
                int re = 'z' - (ch - 'a');
                sb.append(Character.toChars(re));
            } else {
                sb.append(ch);
            }
        }
        return sb.toString();
    }
}
