package dev.solar.codingtest;

import java.util.HashSet;

public class Wadiz03 {
    public int solution(int[] arr) {
        // 임의의 정수를 더하는 것만 된다. 그래서 예제 4번에서 5를 먼저 넣을 수 없다.
        // 아래로 내려왔을 때, 가장 낮은 값을 계속 갱신
        int answer = 0;
        int prevNumber = 0;
        HashSet<Integer> hashSet = new HashSet<>();
        hashSet.add(0);
        for (int number : arr) {
            if (number == prevNumber) {
                continue;
            }
            if (number > prevNumber) {
                answer++;
                hashSet.add(number);
            } else  {
                if (!hashSet.contains(number)) {
                    hashSet.add(number);
                    answer++;
                }
                //hashSet 재정비
                renewal(hashSet, number);
            }
            prevNumber = number;
        }
        return answer;
    }

    private void renewal(final HashSet<Integer> hashSet, final int number) {
        hashSet.removeIf(integer -> integer > number);
    }
}
