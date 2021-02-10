package dev.solar.programmers;

public class N12930 {

    public String solution(String s) {
        char[] chars = s.toCharArray();
        int wordIndex = 0;
        for (int i = 0; i < chars.length; i++) {
            System.out.println("i : " + i +", chars[i] : " + chars[i] + ", wordIndex : " + wordIndex);
            if (chars[i] == ' ') { // 공백을 만나면 다음 문자의 시작을 다시 0번 인덱스로 시작
                wordIndex = 0;
                continue;
            }
            if (wordIndex % 2 == 0)
                chars[i] = Character.toUpperCase(chars[i]);
            else
                chars[i] = Character.toLowerCase(chars[i]);
            wordIndex++;
        }
        return String.valueOf(chars);
    }
}
