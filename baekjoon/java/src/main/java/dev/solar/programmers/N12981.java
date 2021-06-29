package dev.solar.programmers;

import java.util.HashSet;

public class N12981 {
    HashSet<String> hashSet = new HashSet<>();
    public int[] solution(int n, String[] words) {
        hashSet.add(words[0]);
        for (int i = 1; i < words.length; i++) {
            if (!isValid(words[i], words[i - 1])) {
                return new int[]{i % n + 1, i / n + 1}; //번호, 차례
            }
            hashSet.add(words[i]);
        }
        return new int[]{0, 0};
    }

    private boolean isValid(String word, String previous) {
        if (hashSet.contains(word)) {
            return false;
        }
        if (previous.charAt(previous.length() - 1) != word.charAt(0)) {
            return false;
        }
        return true;
    }
}
