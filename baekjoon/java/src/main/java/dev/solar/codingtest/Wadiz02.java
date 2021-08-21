package dev.solar.codingtest;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public class Wadiz02 {
    // 변수 저장: HashMap
    // key: depth, value : (key - 변수명, value - 변수값)
    static HashMap<Integer, HashMap<Character, Integer>> depthMap = new HashMap<>();

    public String[] solution(String[] code) {
        List<String> answer = new LinkedList<>();
        // . 갯수가 많아지면 (얼마나 더 많아지던지 무조건) depth는 +1, . 갯수가 적어지는 만큼 상위 depth로 이동
        int currentDepth = 0;
        int prevOpDepth = 0;
        for (String op : code) {
            int opDepth = countDepth(op);
            if (opDepth == -1) {
                currentDepth = 0;
            } else {
                if (opDepth > prevOpDepth) {
                    currentDepth++;
                } else if (opDepth < prevOpDepth) { //얼만큼 작아지는지 계산
                    currentDepth = opDepth;
                }
            }
            prevOpDepth = opDepth;
            if (isPrint(op)) {
                answer.add(getPrintedString(currentDepth, op));
                continue;
            }
            saveValue(currentDepth, op.substring(op.lastIndexOf('.') + 1));
        }
        return answer.toArray(new String[0]);
    }

    private void saveValue(final int currentDepth, final String op) {
        HashMap<Character, Integer> currentDepthMap = depthMap.get(currentDepth);
        if (currentDepthMap == null) {
            currentDepthMap = new HashMap<>();
            depthMap.put(currentDepth, currentDepthMap);
        }
        int value = op.charAt(op.length() - 1) - '0';
        currentDepthMap.put(op.charAt(0), value);
    }

    private String getPrintedString(int currentDepth, final String op) {
        char variable = op.charAt(op.length() - 1);
        HashMap<Character, Integer> currentDepthMap;
        while (currentDepth >= 0) {
            currentDepthMap = depthMap.get(currentDepth);
            if (currentDepthMap.containsKey(variable)) {
                Integer value = currentDepthMap.get(variable);
                return variable + "=" + value;
            }
            currentDepth--;
        }
        return "error";
    }

    private int countDepth(final String op) {
        return op.lastIndexOf('.');
    }

    private boolean isPrint(final String op) {
        return op.contains("print");
    }
}
