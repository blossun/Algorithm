package dev.solar.codility;

import java.util.Stack;

public class StoneWall {
    public int solution(int[] H) {
        int count = 0;
        Stack<Integer> stack = new Stack<>();
        for (int num : H) {
            while (!stack.isEmpty()) {
                if (num == stack.peek()) {
                    count--;
                    break;
                }
                if (num > stack.peek()) {
                    break;
                }
                if (num < stack.peek()) {
                    stack.pop();
                    continue;
                }
            }
            count++;
            stack.push(num);
        }
        return count;
    }
}
