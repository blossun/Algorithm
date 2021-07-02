package dev.solar.programmers;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class N17686 {
    public String[] solution(String[] files) {
        List<FileName> fileNames = new LinkedList<>();
        for (String file : files) {
            fileNames.add(new FileName(file));
        }
        Collections.sort(fileNames);
        String[] answer = new String[fileNames.size()];
        for (int i = 0; i < fileNames.size(); i++) {
            answer[i] = fileNames.get(i).fullName;
        }
        return answer;
    }

    private class FileName implements Comparable<FileName> {
        private String fullName;
        private String head;
        private Integer number;

        public FileName(String file) {
            int stIndex = 0;
            while (stIndex < file.length()) {
                char ch = file.charAt(stIndex);
                if ('0' <= ch && ch <= '9') {
                    break;
                }
                stIndex++;
            }
            int endIndex = stIndex;
            while (endIndex < file.length()) {
                char ch = file.charAt(endIndex);
                if (!('0' <= ch && ch <= '9')) {
                    break;
                }
                endIndex++;
            }
            endIndex = (endIndex - stIndex > 5) ? stIndex + 5 : endIndex;
            this.fullName = file;
            this.head = file.substring(0, stIndex).toLowerCase();
            this.number = Integer.parseInt(file.substring(stIndex, endIndex));
        }

        @Override
        public int compareTo(FileName o) {
            // 1. head 정렬 - 대소문자 구분 X
            // 2. number 정렬 - 9 < 10 < 0011 < 012 < 13 < 014 숫자값이 작은 순서로
            // 3. 1-2 가 같다면 입력받은 순
            if (!this.head.equals(o.head)) {
                return this.head.compareTo(o.head);
            }
            if (this.number != o.number) {
                return this.number - o.number;
            }
            return 0;
        }
    }
}
