package dev.solar.programmers;

public class N12951 {
    public String solution(String s) {
        char[] chars = s.toLowerCase().toCharArray();
        for (int i = chars.length - 2; i > 0 ; i--) {
            if (chars[i] == ' ') {
                chars[i + 1] = Character.toUpperCase(chars[i + 1]);
            }
        }
        chars[0] = Character.toUpperCase(chars[0]);
        return String.valueOf(chars);
    }

    public String solution01(String s) { //틀린 solution 문자열 끝의 공백이 유지되지 않는다.
        String[] words = s.split(" ");
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < words.length; i++) {
            if (words[i].length() == 0) {
                sb.append(" ");
                continue;
            }
            char[] chars = words[i].toCharArray();
            chars[0] = Character.toUpperCase(chars[0]);
            for (int j = 1; j < chars.length; j++) {
                chars[j] = Character.toLowerCase(chars[j]);
            }
            sb.append(String.valueOf(chars)).append(" ");
        }
        sb.deleteCharAt(sb.length() - 1);
        return sb.toString();
    }
}
