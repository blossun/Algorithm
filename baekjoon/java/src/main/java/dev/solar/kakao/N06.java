package dev.solar.kakao;

import java.util.Arrays;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Stream;

public class N06 {
    public int solution(int[][] board, int[][] skills) {
        for (int[] skill : skills) {
            int value = skill[0] == 1 ? skill[5] * -1 : skill[5];
            for (int i = skill[1]; i <= skill[3]; i++) {
                for (int j = skill[2]; j <= skill[4]; j++) {
                    board[i][j] += value;
                }
            }
        }
        int answer = 0;
//        for (int[] line : board) {
//            for (int i : line) {
//                if (i > 0) {
//                    answer++;
//                }
//            }
//        }
        answer = (int) Arrays.asList(board).parallelStream()
                .flatMapToInt(arrays -> Arrays.stream(arrays))
                .filter(data -> data > 0)
                .count();
        return answer;
    }
}
