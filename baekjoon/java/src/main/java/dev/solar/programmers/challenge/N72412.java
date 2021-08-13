package dev.solar.programmers.challenge;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class N72412 {
    public int[] solution(String[] info, String[] query) {
        List<Applicant> applicants = new ArrayList<>();
        for (String personInfo : info) {
            String[] split = personInfo.split(" ");
            applicants.add(
                    new Applicant(split[0], split[1], split[2], split[3], Integer.parseInt(split[4]))
            );
        }

        List<Integer> answer = new LinkedList<>();
        for (String q : query) {
            String[] split = q.replace(" and ", " ").split(" ");
            answer.add((int) applicants.parallelStream()
                    .filter(applicant -> {
                        if (split[0].equals("-")) {
                            return true;
                        }
                        return applicant.getLanguage().equals(split[0]);
                    })
                    .filter(applicant -> {
                        if (split[1].equals("-")) {
                            return true;
                        }
                        return applicant.getJobGroup().equals(split[1]);
                    })
                    .filter(applicant -> {
                        if (split[2].equals("-")) {
                            return true;
                        }
                        return applicant.getCareer().equals(split[2]);
                    })
                    .filter(applicant -> {
                        if (split[3].equals("-")) {
                            return true;
                        }
                        return applicant.getFood().equals(split[3]);
                    })
                    .filter(applicant -> {
                        if (split[4].equals("-")) {
                            return true;
                        }
                        return applicant.getScore() >= Integer.parseInt(split[4]);
                    })
                    .count());
        }

        return answer.stream().mapToInt(i -> i).toArray();
    }

}

class Applicant {
    String language;
    String jobGroup;
    String career;
    String food;
    int score;

    public Applicant(final String language, final String jobGroup, final String career, final String food, final int score) {
        this.language = language;
        this.jobGroup = jobGroup;
        this.career = career;
        this.food = food;
        this.score = score;
    }

    public String getLanguage() {
        return language;
    }

    public String getJobGroup() {
        return jobGroup;
    }

    public String getCareer() {
        return career;
    }

    public String getFood() {
        return food;
    }

    public int getScore() {
        return score;
    }
}
