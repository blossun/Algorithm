package dev.solar.programmers;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

public class N42890 {
    public int solution(String[][] relation) {
        List<Integer> candidateKey = new LinkedList<>(); //선정된 후보키 저장

        int rowLen = relation.length;
        int colLen = relation[0].length;
        // 1 << colLen : col의 갯수를 가지고 만들 수 있는 최대 이진수의 다음수가 나온다.
        // ex) 1 << 4 -> 10000(2)
        // 즉, 4개의 자리(1과 0컬럼)를 가지고 만들 수 있는 최대 이진수는 1111(2)=15이고, 
        // 총 16개(0 ~ 15)의 조합이 나오게 된다.
        // set은 col의 갯수에 따라 만들 수 있는 조합의 모든 경우의 수
        for (int set = 0; set < (1 << colLen); set++) {
            // 최소성 검사
            if (!isMinimal(set, candidateKey)) {
                continue;
            }

            // 유일성 검사
            if (isUnique(set, candidateKey, rowLen, colLen, relation)) {
                System.out.println("후보키 : " + set);
                candidateKey.add(set); //후보키로 등록
            }
        }

        return candidateKey.size(); //후보키 갯수 반환
    }

    private boolean isUnique(int set, List<Integer> candidateKey, int rowLen, int colLen, String[][] relation) {
        HashSet<String> data = new HashSet<>(); //다른 row에 이미 값이 나왔다면 유일하지 않다는 의미이다. 이를 확인하기 위해 HashSet에 담아서 확인

        for (int row = 0; row < rowLen; row++) { //모든 행을 확인
            StringBuilder sb = new StringBuilder(); //후보키에 해당하는 열에 대한 row값을 담는다.

            for (int th = 0; th < colLen; th++) { //컬럼 각 자리에 해당하는 위치를 th로 표시
                if ((set & (1 << th)) != 0) { //컬럼의 해당 위치(th)가 set의 1의 자리로 표시된 위치라면 -> 후보키 컬럼이라는 의미
                    sb.append(relation[row][th]);
                }
            }

            if (data.contains(sb.toString())) return false;
            else data.add(sb.toString());
        }
        return true;
    }

    private boolean isMinimal(int set, List<Integer> candidateKey) {
        for (Integer key : candidateKey) {
            if ((key & set) == key) {
                return false;
            }
        }
        return true;
    }
}
