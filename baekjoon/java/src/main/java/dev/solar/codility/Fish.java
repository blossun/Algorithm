package dev.solar.codility;

import java.util.Stack;

public class Fish {
    public int solution(int[] A, int[] B) {
        Stack<Integer> upStream = new Stack<>();
        Stack<Integer> downStream = new Stack<>();
        for (int i = 0; i < A.length; i++) {
            if (B[i] == 1) { //하류로 가는 fish는 하류 스택에 담아줌
                downStream.push(A[i]);
                continue;
            }
            if (downStream.isEmpty()) {
                upStream.push(A[i]);
                continue;
            }
            // 하류 스택에 있는 모든 물고기를 확인해야함.
            upStream.push(A[i]);
            while (!downStream.isEmpty()) {
                if (A[i] < downStream.peek()) {
                    upStream.pop();
                    break;
                }
                downStream.pop();
            }
        }
        return upStream.size() + downStream.size();
    }
}
