package dev.solar.codingtest;

import java.util.*;

public class Channel02 {

    public int solution(String road, int n) {
        int result = 0;
        //확인할 시작위치를 큐에 담는다. (맨처음, 0과 0이 나온 다음 index들)
        Queue<Integer> startIndexs = new LinkedList<>();
        HashSet<Integer> startIndexSet = new HashSet<>();
        startIndexs.offer(0);
        startIndexSet.add(0);
        for (int i = 0; i < road.length(); i++) {
            if (road.charAt(i) == '0') {
                if (!startIndexSet.contains(i)) {
                    startIndexs.offer(i);
                    startIndexSet.add(i);
                }
                if (i + 1 < road.length()) {
                    startIndexs.offer(i + 1);
                    startIndexSet.add(i + 1);
                }
            }
        }

        while (!startIndexs.isEmpty()) {
            int countOfOne = 0;
            int useCount = n;
            for (int idx = startIndexs.poll(); idx < road.length(); idx++) {
                if (road.charAt(idx) == '1') {
                    countOfOne++;
                }
                if (road.charAt(idx) == '0') {
                    if (useCount > 0) {
                        useCount--;
                        countOfOne++;
                    } else {
                        break;
                    }
                }
            }
            result = Math.max(result, countOfOne);

        }
        return result;
    }


    // 1의 갯수를 카운팅해서 담는 리스트
    List<Integer> countOfOne = new ArrayList<>();
    // 0의 갯수를 담는 리스트
    List<Integer> countOfZero = new ArrayList<>();

    public int solution02(String road, int n) {
        int result = 0;
        parseData(road);

        for (int i = 0; i < countOfZero.size(); i++) {
            int used = 0;
            int oneCount = 0; //1이 나온 횟수
            for (int j = i; j < countOfZero.size(); j++) { //n번을 초과해서 사용하게 되면 종료
                Integer curZeroCount = countOfZero.get(j);
                if (used + curZeroCount <= n) {
                    oneCount = oneCount + countOfOne.get(j) + curZeroCount; //앞의 1의 갯수 + 0의 갯수
                    used += curZeroCount;
                } else {
                    break;
                }
                if (used >= n) {
                    // 0으로 묶어서 다음에 1이 이어지면 추가해줘야한다.
                    oneCount += countOfOne.get(j + 1);
                    break;
                }
            }
            result = Math.max(result, oneCount);
        }
        return result;
    }

    private void parseData(String road) {
        int one = 0;
        int zero = 0;
        for (int i = 0; i < road.length(); i++) {
            if (road.charAt(i) == '1') {
                one++;
                if (zero != 0) {
                    countOfZero.add(zero);
                    zero = 0;
                }
            } else {
                zero++;
                if (one != 0) {
                    countOfOne.add(one);
                    one = 0;
                }
            }

        }
        if (one != 0) {
            countOfOne.add(one);
        }
        if (zero != 0) {
            countOfZero.add(zero);
        }
    }
}
