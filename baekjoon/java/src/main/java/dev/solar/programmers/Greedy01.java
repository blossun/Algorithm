package dev.solar.programmers;

import java.util.*;

public class Greedy01 {
    public static void main(String[] args) {

    }

    public int solution(int n, int[] lost, int[] reserve) {
        int students = n - lost.length;
        //무조건 최댓값을 구하기위해서 앞번호부터 체크해나가야한다.
        Arrays.sort(lost);
        HashSet<Integer> losts = new HashSet<>();
        for (int i : lost) {
            losts.add(i);
        }
        // 채육복이 있는 학생(reserve)을 표시하는 배열
        // 인덱스값 == 해당 번호의 학생이 여벌의 옷을 가지고 있다면 1
        boolean[] isReseved = new boolean[32]; //전체 학생의 수 30명이하
        for (int i : reserve) {
            isReseved[i] = true;
        }

        // 놓쳤던 조건
        // 5, {2, 3, 4}, {3, 4, 5} => 4
        // 3번이 2번을 빌려주고, 4번에게 빌릴 수 있을 줄 알았는데,
        // 3번은 도난당했으므로 자기 자신의 여벌은 자신이 입어야한다는 조건

        // 선행체크 : 도난 당한 사람이 여벌옷이 있다면 자신의 여벌옷으로 참여
        Iterator<Integer> it = losts.iterator();
        while (it.hasNext()) {
            int i = it.next();
            if (isReseved[i]) {
                students++;
                isReseved[i] = false;
                it.remove();
                continue;
            }
        }

        it = losts.iterator();
        while (it.hasNext()) {
            int i = it.next();
            if (i - 1 > 0) {
                if (isReseved[i - 1]) {
                    students++;
                    isReseved[i - 1] = false; //빌려줬으므로 여벌옷 없음
                    continue;
                }
            }
            if (i + 1 <= 30) {
                if (isReseved[i+1]) {
                    students++;
                    isReseved[i+1] = false;
                    continue;
                }
            }
        }
        return students;
    }
}
