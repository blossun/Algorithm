package dev.solar.kakao;

import java.util.Arrays;
import java.util.List;

public class Test03 {
    public static int solution(List<Integer> arr) {
        // 오르기만 하는 것은 되지만, 내려가기만 하는건..? x0 <= x1 이 아니니깐 안되나? 뒤에 조건 때문에 된다!
        // boolean isTurned : 한번 올라갔다가 내려가는 상황을 체크(x) 내려가기 시작하면 바로 true로 체크. (내려갔으면 다시 올라갈 수 없다.)
        // boolean isEnded : isTurned가 true로 된 이후에 값이 증가하는 형태면 종료.-> isEnded = true;
        // isEnded == false 인 경우에 계속 counting
        int arrSize = arr.size();
        int[] lengthArray = new int[arrSize];
        // 굳이 isTurned, isEnded를 배열로 둘 필요가 없다.... true가 되는 시점의 index를 저장하고 그 이후만 비교를 진행하면 된다.
        // boolean[] isTruned = new boolean[arrSize];
        // boolean[] isEnded = new boolean[arrSize];
        int isTurned = -1;
        int isEnded = -1;
        int max = 1;
        int untilIndex = 1;

        // 처음 값 셋팅
        lengthArray[0] = 1;
        for (int i = 1; i < lengthArray.length; i++) {
            int curNumber = arr.get(i);
            // 이미 max가 arr.size()/2 이상이면? 해당 인덱스(j) 이후로는 더 이상 비교할 필요가 없다.
            if (max < arr.size() / 2) {
                untilIndex = i;
            }
            for (int j = isEnded + 1; j <= untilIndex; j++) { //lengthArray 시작위치
                // if (isEnded[j]) { //이미 조건이 끝났으면 skip
                // continue;
                // }
                // isTurned가 true로 된 이후에 값이 증가하는 형태면 종료.-> isEnded = true;
                if (isTurned >= j && (curNumber > arr.get(i - 1))) {
                    isEnded = j;
                    continue;
                }
                // 처음 시작위치는 이전값과 비교하지 않는다.
                // 이전값과 비교해서 값이 증가(동일)인지 감소인지 확인 -> 감소면 isTurned = true
                if (i != j && curNumber < arr.get(i - 1)) {
                    isTurned = j;
                }
                lengthArray[j]++;
                max = Math.max(max, lengthArray[j]);
                if (max > arr.size() / 2) {
                    untilIndex = j;
                }
            }
        }
        Arrays.stream(lengthArray).forEach(System.out::println);
        // lengthArray에서 최댓값을 반환
//        return Arrays.stream(lengthArray).max().getAsInt();
        return max;
    }
}
