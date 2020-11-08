package dev.solar.baekjoon;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class N1158 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        List<Integer> numbers = new ArrayList<>();
        List<Integer> result = new ArrayList<>();
        for (int i = 1; i < n + 1; i++) {
            numbers.add(i);
        }
        int index = -1;
        while (true) {
            for (int i = 0; i < k; i++) {
                if (index + 1 >= numbers.size()) {
                    index = -1;
                }
                index++;
            }
            if (numbers.size() == 0) { // 더 이상 없으면 종료
                break;
            }
            int num = numbers.get(index);
            result.add(num); //해당하는 사람을 뽑아놓고
            numbers.remove(index); //연결리스트에서 제거
            index--; //제거 했으므로 인덱스도 -1 줄여준다.
        }
        StringBuilder sb = new StringBuilder();
        sb.append("<");
        for (Integer num : result) {
            sb.append(num + ", ");
        }
        System.out.println(sb.toString().substring(0, sb.length() - 2) + ">");
    }
}
/*
원형 연결 리스트를 사용하면 좋지 않을까 생각하는데, 그러면 직접 만들어야 하능나?
실수
- 제거된 사람 위치를 0으로 하면 안됨 -> 그사람을 빼고 원을 만들어야 하기 때문
- 제거된 사람 위치를 연결리스트 remove로 하면 index로 접근 헀을 떄 달라짐. -> 지운 뒤, index를 -1 해주면됨
다른 풀이
- next로 다음 사람 찾는 과정을 k번 해야함.
- deque로 하면 좋을 것 같은데 연결리스트로도 가능할까? -> 연결리스트 가능. deque 가
 */
