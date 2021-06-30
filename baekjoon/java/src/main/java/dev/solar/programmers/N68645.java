package dev.solar.programmers;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class N68645 {
    static int[][] board;
    static int number = 1;
    static int end;
    static int x = 1;
    static int y = 0;
    static int row;

    public int[] solution(int row) {
        board = new int[row + 1][row + 1];
        end = row * (row + 1) / 2;
        this.row = row;
        for (int i = 0; i <= row; i++) {
            Arrays.fill(board[i], -1);
        }
        while (number <= end) {
            y += 1;
            fillIncreaseY(row);
            x += 1;
            fillIncreaseX(row);
            x -= 1;
            y -= 1;
            fillDecreaseXY(row);
        }
        List<Integer> result = new LinkedList<>();
        for (int x = 1; x <= row; x++) {
            for (int y = 1; y <= row; y++) {
                if (board[y][x] == -1) {
                    continue;
                }
                result.add(board[y][x]);
            }
            }
        return result.stream().mapToInt(i -> i).toArray();
    }

    private void fillDecreaseXY(int row) {
        for (; x > 0; ) {
            if (board[x][y] != -1) {
                x += 1;
                y += 1;
                return;
            }
            board[x--][y--] = number++;
        }

    }

    private void fillIncreaseX(int row) {
        for (; x <= row; x++) {
            if (board[x][y] != -1) {
                x -= 1;
                return;
            }
            board[x][y] = number++;
        }
        x -= 1;
        return;
    }

    private void fillIncreaseY(int row) {
        for (; y <= row; y++) {
            if (board[x][y] != -1) {
                y -= 1;
                return;
            }
            board[x][y] = number++;
        }
        y -= 1;
        return;
    }
}
