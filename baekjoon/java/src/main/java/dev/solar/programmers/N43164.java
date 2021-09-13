package dev.solar.programmers;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.PriorityQueue;

public class N43164 {
    boolean[] visited;
    ArrayList<String> answers; //정답 후도들
    public String[] solution(String[][] tickets) {
        answers = new ArrayList<>();
        visited = new boolean[tickets.length];
        // bfs로 경로 확인
        bfs(0, "ICN", "ICN", tickets);
        Collections.sort(answers);
        String[] answer = answers.get(0).split(" ");
        return answer;
    }

    private void bfs(final int cur, final String present, String answer, final String[][] tickets) {
        if (cur == tickets.length) {
            answers.add(answer);
            return;
        }

        for (int i = 0; i < tickets.length; i++) {
            String from = tickets[i][0];
            String to = tickets[i][1];
            if (!visited[i] && from.equals(present)) {
                visited[i] = true;
                bfs(cur + 1, to, answer + " " + to, tickets);
                visited[i] = false;
            }
        }
    }

}
