package dev.solar.codingtest;

import java.util.HashMap;
import java.util.Map;

public class Hcard01 {
    public int solution(String[] colors, int[] prices) {
        int numberOfSet = 0;
        HashMap<Character, Integer> topSet = new HashMap<>();
        HashMap<Character, Integer> bottomSet = new HashMap<>();
        for (String color : colors) {
            char top = color.charAt(0);
            if (bottomSet.containsKey(top) && bottomSet.get(top) != 0) {
                bottomSet.put(top, bottomSet.get(top) - 1);
                numberOfSet++;
            } else {
                if (topSet.containsKey(top)) {
                    topSet.put(top, topSet.get(top) + 1);
                } else {
                    topSet.put(top, 1);
                }
            }
            char bottom = color.charAt(1);
            if (topSet.containsKey(bottom) && topSet.get(bottom) != 0) {
                topSet.put(bottom, topSet.get(top) - 1);
                numberOfSet++;
            } else {
                if (bottomSet.containsKey(bottom)) {
                    bottomSet.put(bottom, bottomSet.get(bottom) + 1);
                } else {
                    bottomSet.put(bottom, 1);
                }
            }
        }
        int totalPrice = numberOfSet * prices[0];
        int count = 0;
        for (Map.Entry<Character, Integer> top : topSet.entrySet()) {
            if (top.getValue() != 0) {
                count += top.getValue();
            }
        }
        totalPrice += Math.min((count * 2) * prices[0], count * prices[1]);

        return totalPrice;
    }
}
