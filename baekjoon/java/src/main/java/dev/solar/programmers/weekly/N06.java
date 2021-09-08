package dev.solar.programmers.weekly;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class N06 {
    public int[] solution(int[] weights, String[] head2head) {
        List<Player> players = new ArrayList<>();
        for (int i = 0; i < weights.length; i++) {
            players.add(new Player(i, weights[i]));
        }
        for (int i = 0; i < head2head.length; i++) {
            Player player = players.get(i);
            String record = head2head[i];
            int n = record.length();
            int winCount = 0;
            int totalCount = 0;
            for (int idx = 0; idx < n; idx++) {
                if (idx == i || record.charAt(idx) == 'N') continue;
                // 총 경기 횟수가 선수마다 다를 수 있다. 이를 계산 해야 한다.
                totalCount++;
                if (record.charAt(idx) != 'W') continue;
                // 이긴 경우만 확인
                winCount++;
                Player opponent = players.get(idx);
                if (player.weight < opponent.weight) {
                    player.numberOfWinBigger++;
                }
            }
            if (winCount != 0) {
                player.winningRate = (double) winCount / totalCount;
                System.out.println(player.winningRate);
            }
        }
        Collections.sort(players);
        return players.stream().mapToInt(p -> p.id + 1).toArray();
    }

    class Player implements Comparable<Player> {
        int id;
        int weight;
        double winningRate = 0.0;
        int numberOfWinBigger = 0;

        public Player(final int id, final int weight) {
            this.id = id;
            this.weight = weight;
        }

        @Override
        public int compareTo(final Player o) {
            if (this.winningRate != o.winningRate) {
                return Double.compare(o.winningRate, this.winningRate);
            }
            if (this.numberOfWinBigger != o.numberOfWinBigger) {
                return o.numberOfWinBigger - this.numberOfWinBigger;
            }
            if (this.weight != o.weight) {
                return o.weight - this.weight;
            }
            return this.id - o.id;
        }
    }
}
