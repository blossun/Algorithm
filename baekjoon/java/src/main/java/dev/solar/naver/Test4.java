package dev.solar.naver;

public class Test4 {
    public int solution(String S, int[] C) {
        char[] chars = S.toCharArray();
        int totalCost = 0;
        char beforeChar = chars[0];
        int cost = C[0];

        for (int i = 1; i < C.length; i++) {
            char currentChar = chars[i];
            if (beforeChar != currentChar) {
                beforeChar = currentChar;
                cost = C[i];
            } else {
                totalCost += Math.min(cost, C[i]);
                cost = Math.max(cost, C[i]);
            }
        }
        return totalCost;
    }
}
