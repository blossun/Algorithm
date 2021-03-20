package dev.solar.line;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

public class Test1 {
    public String solution(String[] table, String[] languages, int[] preference) {
        List<Occupation> occupations = new ArrayList<>();

        for (int i = 0; i < 5; i++) {
            String[] str = table[i].split(" ");
            Occupation occupation = new Occupation(str[0]);
            int score = 5;
            for (int j = 1; j < 6; j++) {
                occupation.addScore(str[j], score--);
            }
            occupations.add(occupation);
        }

        int length = languages.length;
        for (int i = 0; i < length; i++) {
            for (Occupation occupation : occupations) {
                if (occupation.jobScore.containsKey(languages[i])) { //직업군 후보에 있다면
                    Integer score = occupation.jobScore.get(languages[i]);
                    occupation.totalScore += preference[i] * score;
                }
            }
        }

        // 제일 높은 점수를 가진 job
        Collections.sort(occupations);
        return occupations.get(0).job;
//        Occupation maxScoreJob = occupations.get(0);
//        for (Occupation occupation : occupations) {
//            if (occupation.totalScore >= maxScoreJob.totalScore) {
//                maxScoreJob = occupation;
//            }
//        }

//        return maxScoreJob.job;
    }

    private static class Occupation implements Comparable<Occupation> {
        public String job;
        public HashMap<String, Integer> jobScore = new HashMap<>();
        public int totalScore;

        public Occupation(String job) {
            this.job = job;
            totalScore = 0;
        }

        public void addScore (String language, Integer score) {
            jobScore.put(language, score);
        }

        @Override
        public int compareTo(Occupation o) {
            if (o.totalScore == this.totalScore) {
                return this.job.compareTo(o.job);
            }
            return o.totalScore - this.totalScore;
        }
    }
}
