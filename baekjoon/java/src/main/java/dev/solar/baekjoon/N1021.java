package dev.solar.baekjoon;

import java.util.*;

public class N1021 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt(); // 1~N 까지 넣을 수 있는 덱
        int M = sc.nextInt(); //뽑으려는 숫자 갯수
        Deque<Integer> deque = new LinkedList<>();
        int count = 0;
        // 덱 초기화
        for (int i = 1; i <= N ; i++) {
            deque.add(i);
        }
        for (int i = 0; i < M; i++) {
            int num = sc.nextInt();
            while (true) {
//                if (deque.peekFirst() == num) {
//                    deque.pop();
//                    break;
//                }
                int index = 0; //몇번째 인덱스인지 찾기
                Iterator<Integer> it = deque.iterator(); //Iterator 타입으로 Integer로 지정해줘야 비교 가능
                while (it.hasNext()) {
                    if (it.next() == num)
                        break;
                    index++;
                }

                if (index == 0) {
                    deque.pop();
                    break;
                } else if (index > deque.size() / 2) { //이 조건이 먼저나오느냐 후자에 나오느냐에 따라 달라짐 주의!! 반올림이 아니므로 계산하기
                    deque.addFirst(deque.removeLast());
                    count++;
                } else {
                    deque.addLast(deque.removeFirst());
                    count++;
                }
            }
        }
        System.out.println(count);
    }
}

/*
<- , -> 방향을 정하는 기준 ?
1. 중간값과 비교 -> x
2. 위치랑 남은 size 비교 -> x
3. iterator로 위치값을 알아와서 덱의 size와 비교
 */
