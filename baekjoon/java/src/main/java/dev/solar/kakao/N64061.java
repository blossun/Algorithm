package dev.solar.kakao;

import java.util.HashMap;
import java.util.Stack;

public class N64061 {
    public int solution(int[][] board, int[] moves) {
        // 1. board에 따라서 인형 채우기
        // 각 index+1 번 마다 stack으로 해당 라인의 인형이 쌓인다.
        // 아래에서부터 쌓여야한다.
        HashMap<Integer, Stack<Integer>> boardMap = new HashMap<>();
        for (int i = 0; i < board.length; i++) {
            boardMap.put(i + 1, new Stack());
        }
        for (int i = board.length - 1; i >= 0; i--) { //아래에서부터 쌓여야하므로 뒷 배열부터 담아야한다.
            for (int j = 0; j < board[i].length; j++) {
                Stack stack = boardMap.get(j + 1);
                if (board[i][j] != 0) {
                    stack.push(board[i][j]);
                }
            }
        }

        // 2. 뽑기 진행
        Stack<Integer> basket = new Stack(); //뽑혀서 쌓일 바구니
        int disappeared = 0; //총 사라진 인형의 갯수
        for (int move : moves) {
            Stack columnStack = boardMap.get(move); //해당 열의 stack에서 하나를 pop
            if (columnStack.isEmpty()) { //뽑을 인형이 없다면 skip
                continue;
            }
            Integer poped = (Integer) columnStack.pop(); //뽑힌 인형
            if (!basket.isEmpty() && basket.peek().equals(poped)) { //인형이 같다면
                disappeared += 2; //사라진 인형의 갯수를 추가하고
                basket.pop(); //사라졌으므로 지워준다.
                continue;
            }
            basket.push(poped);
        }

        return disappeared;
    }
}
