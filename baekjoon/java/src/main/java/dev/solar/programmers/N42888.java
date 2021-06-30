package dev.solar.programmers;

import java.util.HashMap;
import java.util.LinkedList;

public class N42888 {
    public String[] solution(String[] record) {
        // O(n^2) 시간 초과
        HashMap<String, String> nickName = new HashMap<>();
        LinkedList<String[]> logging = new LinkedList<>();
        for (String str : record) {
            String[] words = str.split(" ");
            String command = words[0];
            switch (command) {
                case "Enter":
                    nickName.put(words[1], words[2]);
                    logging.add(new String[]{"Enter", words[1]});
                    break;
                case "Leave":
                    logging.add(new String[]{"Leave", words[1]});
                    break;
                case "Change":
                    nickName.put(words[1], words[2]);
            }
        }
        String[] answer = new String[logging.size()];
        for (int i = 0; i < logging.size(); i++) {
            String[] line = logging.get(i);
            StringBuilder sb = new StringBuilder();
            sb.append(nickName.get(line[1])).append("님이 ");
            if (line[0] == "Enter") {
                sb.append("들어왔습니다.");
            } else {
                sb.append("나갔습니다.");
            }
            answer[i] = sb.toString();
        }
        return answer;
    }
}
