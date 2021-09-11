package dev.solar.kakao;

import java.util.*;

public class N01 {
    static int criterion;
    public int[] solution(String[] id_list, String[] report, int k) {
        criterion = k;
        HashMap<String, Person> hashMap = new HashMap<>();
        for (String id : id_list) {
            hashMap.put(id, new Person(id));
        }

        for (String s : report) {
            String[] info = s.split(" ");
            Person reporter = hashMap.get(info[0]);
            if (reporter.reportPerson.contains(info[1])) { //이미 신고한 전적이 있는 사람인 경우
                continue;
            }
            reporter.reportPerson.add(info[1]); //신고한 사람에 추가
            Person opponent = hashMap.get(info[1]);
            opponent.reported(); //신고당한 횟수 추가
        }

        int[] answer = new int[id_list.length];
        for (int i = 0; i < answer.length; i++) {
            Person person = hashMap.get(id_list[i]);
            HashSet<String> reportPerson = person.reportPerson;
            int cnt = 0;
            for (String name : reportPerson) {
                if (hashMap.get(name).isStopped()) {
                    cnt++;
                }
            }
            answer[i] =  cnt;
        }
        return answer;
    }

    class Person {
        public String name;
        public HashSet<String> reportPerson = new HashSet<>(); //신고한 사람
        public int reportedNumber; //신고당한 횟수
        public boolean isStopped;

        public Person(final String name) {
            this.name = name;
        }

        public void reported() {
            this.reportedNumber++;
            if (this.reportedNumber >= criterion) {
                isStopped = true;
            }
        }

        public boolean isStopped() {
            return isStopped;
        }
    }
}
