package dev.solar.kakao;

import java.util.Arrays;

public class Mobility03 {
    public int solution(int[] A) {
        // A size가 1인 경우
        // 각 비교 시작 위치별 odd, even 숫자값을 저장
        int[] oddArray = new int[A.length];
        int[] evenArray = new int[A.length];
        int[] lengthArray = new int[A.length]; //시작 위치(index)별 연속된 스위칭 길이 저장
        int endIndex = -1; //더 이상 비교를 진행하지 않아도 되는 lengthArray의 index - j
        boolean isEven = true;
        int max = 1;
        // 첫번째 시작값 초기화
        evenArray[0] = A[0];
        lengthArray[0] = 1;
        for (int index = 1; index < A.length; index++) {
            isEven = (index % 2 == 0); //even인지 odd 차례인지 확인
            int curNumber = A[index];
            // 자신이랑, 자신 바로 하나 전 even, odd값 셋팅
            if (isEven) {
                evenArray[index] = curNumber;
                evenArray[index - 1] = curNumber;
            } else {
                oddArray[index] = curNumber;
                oddArray[index - 1] = curNumber;
            }
            for (int j = endIndex + 1; j <= index; j++) { //비교할 시작위치부터 i번째까지비교
                if (isEven) {
                    if (evenArray[j] != curNumber) {
                        endIndex = j;
                        continue;
                    }
                } else {
                    if (oddArray[j] != curNumber) {
                        endIndex = j;
                        continue;
                    }
                }
                lengthArray[j]++;
                max = Math.max(max, lengthArray[j]);
            }
        }

//        Arrays.stream(lengthArray).forEach(System.out::println);
        return max;
    }
}
