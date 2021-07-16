package dev.solar.programmers;

import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

public class N17687 {
    public String solution(int n, int t, int m, int p) {
        /**
         * Queue로 말해야하는 숫자를 한 글자씩 담는다.
         * 큐가 m(인원수)보다 작은 경우 다음 숫자값을 진수 변환하여, 값을 한자리수 만큼 잘라내서 담는다.
         * m명 만큼 큐에서 꺼내고, 그 과정 중 p 번째 순서일 때 문자열 결과값을 붙여준다.
         */
        StringBuilder sb = new StringBuilder();
        Queue<Character> ready = new ConcurrentLinkedQueue<>();
        ready.offer('0');
        int currentNumber = 1;
        while (t-- > 0) {//미리 구할 숫자 갯수
             while (ready.size() <= m) {
                char[] chars = convertNumber(currentNumber, n).toCharArray();
                for (char ch : chars) {
                    ready.offer(ch);
                }
                currentNumber++;
            }
            //m명중 p순서의 값들
            for (int i = 1; i <= m; i++) {
                // p순서가 오기 전의 값들은 빼버린다.
                Character ch = ready.poll();
                if (i == p) {
                    //p순서가 오면 담는다.
                    sb.append(ch);
                }
            }
        }
        return sb.toString();
    }

    public String convertNumber(int number, int n) { //number를 n진수형으로 변
        StringBuilder sb = new StringBuilder();
        int current = number;

        // 진법 변환을 할 숫자가 0보다 큰 경우까지 진행
        while (current > 0) {
            int remain = current % n;
            if (remain < 10) { // 0 ~ 9 사이의 값은 그대로 넣으면 된다.
                sb.append(remain);
            } else {
                sb.append((char) (remain - 10 + 'A')); //10부터는 A이후 문자로 표시된다.
            }
            current /= n;
        }
        return sb.reverse().toString();
    }
}
