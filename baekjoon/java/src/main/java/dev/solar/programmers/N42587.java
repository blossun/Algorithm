package dev.solar.programmers;

import java.util.*;

public class N42587 {
    public int solution(int[] priorities, int location) {
        // 결과적으로 리턴해줄 값 : 출력 순서
        int result = 0;
        // 인덱스와 우선순위가 함께 저장되는 곳
        Queue<Node> waitingQ = new LinkedList<>();
        // 우선순위큐 (우선순위 큐는 기본적으로 최대힙이므로 내림차순으로 정렬)
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(Collections.reverseOrder());

        // 대기목록(priorities)을 순회하면서 인덱스와 함께 우선순위를 저장
        for (int i = 0; i < priorities.length; i++) {
            waitingQ.add(new Node(i, priorities[i]));
            priorityQueue.add(priorities[i]);//우선순위를 가진 대기 목록을 우선순위 큐에 저장
        }

        // 대기목록 큐가 빌 때까지 순회
        while (!waitingQ.isEmpty()) {
            // 대기 큐의 맨 앞 우선순위와 우선순위큐의 첫번쨰 값을 비교
            if (waitingQ.peek().priority == priorityQueue.peek()) {

                // 큐의 맨 앞에 있는 값의 인덱스가 내가 요청한 문서의 인덱스인지 확인
                if (waitingQ.peek().index == location) {
                    return result + 1;
                }

                // 우선순위가 값과 일치하므로 대기큐와 우선순위 큐에서 하나를 poll 한다.
                result += 1;
                waitingQ.poll();
                priorityQueue.poll();
            } else { // 대기큐의 현재 첫번째 순서보다 더 높은 우선순위 값이 있다는 의미
                // 하나를 꺼내서 맨 뒤에 push
                waitingQ.offer(waitingQ.poll());
            }
        }

        return result;
    }

    private class Node {
        int index;
        int priority;

        public Node(int index, int priority) {
            this.index = index;
            this.priority = priority;
        }
    }
}
