package dev.solar.programmers;

public class N60057 {
    public int solution(String s) {
        int length = s.length();
        int min = length;

        for (int i = 1; i <= length / 2; i++) {
            int compressLength = compress(s, i);
            min = Math.min(min, compressLength);
        }
        return min;
    }

    private int compress(String s, int size) {
        StringBuilder sb = new StringBuilder();
        String previousWord = s.substring(0, size);
        int count = 0;
        for (int i = 0; i < s.length(); i = i + size) {
            int end = ((i + size) >= s.length()) ? (s.length()) : (i + size);
            String word = s.substring(i, end);
            if (previousWord.equals(word)) {
                count++;
                continue;
            }
            if (count != 1) {
                sb.append(count);
            }
            sb.append(previousWord);
            previousWord = word;
            count = 1;
        }
        if (count != 1) {
            sb.append(count);
        }
        sb.append(previousWord);
//        System.out.println("result => " + sb);
        return sb.length();
    }
}
