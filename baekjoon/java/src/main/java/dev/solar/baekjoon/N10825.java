package dev.solar.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class N10825 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());
        List<Score> scoreList = new ArrayList<>();
        while (N-- > 0) {
            st = new StringTokenizer(br.readLine());
            scoreList.add(new Score(st.nextToken(), Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
        }
        Collections.sort(scoreList);
        Iterator<Score> it = scoreList.iterator();
        while (it.hasNext()) {
            sb.append(it.next().name).append('\n');
        }
        System.out.println(sb);



    }

    public static class Score implements Comparable<Score> {
        public String name;
        public int korean;
        public int english;
        public int math;

        public Score(String name, int korean, int english, int math) {
            this.name = name;
            this.korean = korean;
            this.english = english;
            this.math = math;
        }

        @Override
        public int compareTo(Score o) {
            if (korean != o.korean)
                return o.korean - korean; // 감소하는 순서로
            if (english != o.english)
                return english - o.english; // 증가하는 순서로
            if (math != o.math)
                return o.math - math; // 감소하는 순서로
            return name.compareTo(o.name);
        }
    }
}
