package dev.solar.programmers;

import java.util.Stack;

public class N42584 {
    public int[] solution(int[] prices) {
        int[] answer = new int[prices.length];
        Stack<Node> stack = new Stack<>();
        for (int i = 0; i < prices.length; i++) {
            while (!stack.isEmpty()) {
                Node peek = stack.peek();
                if (peek.number <= prices[i]) { //가격이 떨어지지 않은 부분
                    break;
                }
                // 가격이 떨어진 경우, 해당 index에 유지된 초값을 계산에서 넣어줌
                answer[peek.index] = i - peek.index;
                stack.pop();
            }
            stack.push(new Node(i, prices[i]));
        }

        int lastIndex = prices.length - 1;
        while (!stack.isEmpty()) {
            Node node = stack.pop();
            answer[node.index] = lastIndex - node.index;
        }
        
        return answer;
    }
    
    private class Node {
        int index;
        int number;

        public Node(int index, int number) {
            this.index = index;
            this.number = number;
        }
    }
}
 
