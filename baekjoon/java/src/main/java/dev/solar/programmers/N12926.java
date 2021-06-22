package dev.solar.programmers;

public class N12926 {
    public String solution(String s, int n) {

        char[] chars = s.toCharArray();
//        char[] result = new char[chars.length];
        for (int i = 0; i < chars.length; i++) {
            char ch = chars[i];
            if (ch >= 'A' && ch <= 'Z') {
                ch += n;
                if (ch > 'Z') {
                    ch = (char) (ch - 'Z' - 1 + 'A');
                }
                chars[i] = ch;
                continue;
            }
            if (ch >= 'a' && ch <= 'z') {
                ch += n;
                if (ch > 'z') {
                    ch = (char) (ch - 'z' - 1 + 'a');
                }
                chars[i] = ch;
                continue;
            }
        }

        return String.valueOf(chars);
    }
}
