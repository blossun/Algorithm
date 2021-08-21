package dev.solar.codingtest;

import java.util.HashMap;

public class Wadiz01 {
    public int solution(int[][] passwords, String s) {
        HashMap<Integer, Integer> passwordMap = new HashMap<>();
        for (int[] password : passwords) {
            passwordMap.put(password[0], password[1]);
        }

        int answer = 0;
        String[] inputOrder = s.split("#");
        for (int i = 0; i < inputOrder.length; i++) {
            int room = Integer.parseInt(inputOrder[i]);
            if (!passwordMap.containsKey(room)) {
                continue;
            }
            if (i + 1 == inputOrder.length) {
                break;
            }
            int password = Integer.parseInt(inputOrder[++i]);
            if(passwordMap.get(room) == password) {
                answer++;
            }
        }

        return answer;
    }
}
