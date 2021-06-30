package dev.solar.programmers;

import java.util.HashMap;
import java.util.LinkedList;

public class N42888 {
    public String[] solution(String[] record) {
        HashMap<String, String> nickName = new HashMap<>();
        LinkedList<String> answer = new LinkedList<>();
        for (String str : record) {
            String[] words = str.split(" ");
            String command = words[0];
            // 최종 닉네임만 먼저 업데이트 해놓는다.
            switch (command) {
                case "Enter":
                    nickName.put(words[1], words[2]);
                    break;
                case "Change":
                    nickName.put(words[1], words[2]);
            }
        }
        for (String str : record) {
            String[] words = str.split(" ");
            String command = words[0];
            String uid = words[1];
            // 로그 기록
            switch (command) {
                case "Enter":
                    answer.add(nickName.get(uid) + "님이 들어왔습니다.");
                    break;
                case "Leave":
                    answer.add(nickName.get(uid) + "님이 나갔습니다.");
            }

        }
        return answer.toArray(new String[0]);
    }
}
