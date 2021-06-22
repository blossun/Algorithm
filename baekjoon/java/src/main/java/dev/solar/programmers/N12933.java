package dev.solar.programmers;

import java.util.*;

public class N12933 {
    public long solution(long n) {
        char[] chars = String.valueOf(n).toCharArray();
        Arrays.sort(chars); //Collections.reverseOrder() 쓰려면 references type 이어야 한다.
        StringBuilder sb = new StringBuilder();
        for (char ch : chars) {
            sb.append(ch);
        }
        sb.reverse(); //여기서 역순으로
        long answer = Long.parseLong(sb.toString());
        return answer;
    }
    /*
     * 어떤 테스트케이스로 틀렸는지 확인 필요
     */
    public long solution02(long n) {
        long answer = 0;
        List<Integer> numbers = new ArrayList<>();
        while (n > 0) {
            numbers.add((int) n % 10);
            n /= 10;
        }

        Collections.sort(numbers, Comparator.reverseOrder());
        for (Integer number : numbers) {
            answer *= 10;
            answer += number;
        }


        return answer;
    }
}
