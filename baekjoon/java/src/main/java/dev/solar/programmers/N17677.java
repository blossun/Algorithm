package dev.solar.programmers;

import java.util.HashMap;

public class N17677 {
    public int solution(String str1, String str2) {
        HashMap<String, Integer> keyword1 = new HashMap<>();
        HashMap<String, Integer> keyword2 = new HashMap<>();
        splitElement(str1, keyword1);
        splitElement(str2, keyword2);
        // 교집합
        int intersection = 0;
        for (String key : keyword1.keySet()) {
            if (keyword2.containsKey(key)) {
                intersection += Math.min(keyword1.get(key), keyword2.get(key));
            }
        }
        // 합집합
        int union = 0;
        for (String key : keyword1.keySet()) {
            if (keyword2.containsKey(key)) {
                union += Math.max(keyword1.get(key), keyword2.get(key));
                continue;
            }
            union += keyword1.get(key);
        }
        for (String key : keyword2.keySet()) {
            if (keyword1.containsKey(key)) {
                continue;
            }
            union += keyword2.get(key);
        }

        return (intersection == 0 && union == 0) ? 65536 : (int) Math.floor(intersection / (double) union * 65536);
    }

    private void splitElement(String str1, HashMap<String, Integer> keyword1) {
        for (int i = 0; i < str1.length() - 1; i++) {
            String str = str1.substring(i, i + 2).toLowerCase();
            //문자만 있는지 확인
            if (!str.matches("^[a-z]*$")) {
                continue;
            }
            if (keyword1.containsKey(str)) {
                keyword1.put(str, keyword1.get(str) + 1);
            } else {
                keyword1.put(str, 1);
            }
        }
    }
}
