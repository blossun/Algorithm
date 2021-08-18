package dev.solar.programmers.challenge;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class N72412 {
    static HashMap<String, ArrayList<Integer>> allInfo = new HashMap<>();
    static ArrayList<Integer> scoreList;

    public int[] solution(String[] info, String[] query) {
        int[] result = new int[query.length];

        //1. info로 나올 수 있는 모든 경우의 수 : allInfo
        // key : 경우 문자열, value : 해당
        for (String infoString : info) {
            dfs("", 0, infoString.split(" "));
        }

        //2. allInfo의 scoreList를 오름차순 정렬
        for (String key : allInfo.keySet()) {
            ArrayList<Integer> scoreList = allInfo.get(key);
            Collections.sort(scoreList);
        }

        //3. 점수 이분 탐색
        for (int i = 0; i < query.length; i++) {
            query[i] = query[i].replace(" and ", "");
            String[] str = query[i].split(" ");
            result[i] = search(str[0], Integer.parseInt(str[1]));
        }

        return result;
    }

    //이분 탐색
    private int search(final String str, final Integer score) {
        if (!allInfo.containsKey(str)) return 0;
        ArrayList<Integer> scoreList = allInfo.get(str);
        int start = 0;
        int end = scoreList.size() - 1;
        while (start <= end) {
            int mid = (start + end) / 2;
            if (scoreList.get(mid) < score) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }

        return scoreList.size() - start;
    }

    private void dfs(String pos, final int depth, final String[] info) {
        if (depth == 4) {
            if (!allInfo.containsKey(pos)) { //이미 있는 경우의 수라면
                scoreList = new ArrayList<>();
                scoreList.add(Integer.parseInt(info[4]));
                allInfo.put(pos, scoreList);
            } else {
                allInfo.get(pos).add(Integer.valueOf(info[4]));
            }
            return ;
        }

        //해당 자리에 문자열을 넣거나 안넣거나 2가지 경우임
        dfs(pos+"-", depth+1, info);
        dfs(pos+info[depth], depth+1, info);
    }

    public int[] solution01(String[] info, String[] query) {
        List<Applicant> applicants = new ArrayList<>();
        for (String personInfo : info) {
            String[] split = personInfo.split(" ");
            applicants.add(
                    new Applicant(split[0], split[1], split[2], split[3], Integer.parseInt(split[4]))
            );
        }

        List<Integer> answer = new LinkedList<>();
        IntStream
                .range(0, query.length)
                .mapToObj(index -> {
                    List<String> collect = Stream.of(query[index].replace(" and ", " ").split(" "))
                            .collect(Collectors.toList());
                    collect.add(String.valueOf(index));
                    return collect;
                })
                .forEach(split ->
                        answer.add(Integer.parseInt(split.get(5)), (int) applicants.parallelStream()
                                .filter(applicant -> {
                                    if (split.get(0).equals("-")) {
                                        return true;
                                    }
                                    return applicant.getLanguage().equals(split.get(0));
                                })
                                .filter(applicant -> {
                                    if (split.get(1).equals("-")) {
                                        return true;
                                    }
                                    return applicant.getJobGroup().equals(split.get(1));
                                })
                                .filter(applicant -> {
                                    if (split.get(2).equals("-")) {
                                        return true;
                                    }
                                    return applicant.getCareer().equals(split.get(2));
                                })
                                .filter(applicant -> {
                                    if (split.get(3).equals("-")) {
                                        return true;
                                    }
                                    return applicant.getFood().equals(split.get(3));
                                })
                                .filter(applicant -> {
                                    if (split.get(4).equals("-")) {
                                        return true;
                                    }
                                    return applicant.getScore() >= Integer.parseInt(split.get(4));
                                })
                                .count())
                );

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
