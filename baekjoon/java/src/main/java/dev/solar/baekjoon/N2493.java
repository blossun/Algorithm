package dev.solar.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
import java.util.StringTokenizer;

/*
result stack : 입력 순서에 따라서 하나씩 점근하면서 레이저 신호를 수신한 탑들의 인덱스를 리스트에 저장
레이저 신호를 발사한 탑을 중심으로 **왼쪽에 있는** 탑들을 스택을 이용해 탐색
1. stack이 비어있다면,
    (현재 위치의 탑보다 왼쪽에 위치한 탑이 없다.)
    왼쪽에 수신가능한 탑이 없는 것이므로 result에 0을 셋팅
2. stack이 비어있지 않다면, 자신의 왼쪽에 존재하는 것과 비교를 진행
    1) 자신보다 높이가 낮은 탑이 있다면 pop()
        -> 어짜피 오른쪽 탑의 레이저를 자신때문에 앞의 낮은 탑이 받지 못하므로 확인할 필요가 없다.
        그리고 그 앞의 기둥에서 수신할 수 있는 탑이 있을지 모르므로 stackdㅣ 빌 때까지 확인
    2) 자신보다 높이가 높은 탑이 있다면, result에 인덱스를 저장 후, 본인 정보를 스택에 저장
* 스택에 자료를 인덱스와 높이 정보를 가지는 제네릭으로 넣어준다.
 */
public class N2493 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());
        List<Integer> result = new ArrayList<>();
        Stack<Top> topStack = new Stack<>();
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i < N + 1; i++) {
            Top top = new Top(i, Integer.parseInt(st.nextToken()));
            if (topStack.isEmpty()) { //왼쪽에 탑이 아무것도 없는 경우 - 수신 불가
                result.add(0);
                topStack.push(top);
            } else {
                while (!topStack.isEmpty()) { //왼쪽에 수신가능한 탑이 있는지 모두 확인
                    if (topStack.peek().height > top.height) { //수신 가능한 탑이 있는 경우
                        result.add(topStack.peek().index);
                        topStack.push(top);
                        break;
                    } else { //수신 불가능하다면 왼쪽 탑들을 계속 탐색
                        topStack.pop();
                    }
                }
                // 아무도 수신 못한 경우가 있는지 확인
                if (topStack.isEmpty()) {
                    result.add(0);
                    topStack.push(top);
                }
            }
        }
        for (Integer n : result) {
            sb.append(n).append(" ");
        }
        System.out.println(sb);
    }

    private static class Top {
        private int index;
        private int height;

        public Top(int index, int height) {
            this.index = index;
            this.height = height;
        }
    }
}
