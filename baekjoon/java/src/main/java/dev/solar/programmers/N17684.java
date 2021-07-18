package dev.solar.programmers;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public class N17684 {
    public int[] solution(String msg) {
        Dictionary dic = new Dictionary();
        List<Integer> result = new LinkedList<>();

        int i = 0;
        while (i < msg.length()) {
            StringBuilder sb = new StringBuilder();
            sb.append(msg.charAt(i));
            while (true) {
                if (!dic.dictionary.containsKey(sb.toString())) { //더 이상 존재하지 않으면 단어를 추가하면 된다.
                    break;
                }
                if (i + 1 < msg.length()) {
                    sb.append(msg.charAt(++i));
                } else {
                    i++;
                    break;
                }
            }
            if (i >= msg.length()) { //마지막 단어인 경우 - sb에 마지막 글자까지 조회해서 넣어야 하므로 조건 분리
                result.add(dic.dictionary.get(sb.toString()));
                continue;
            }
            //사전에 새롭게 추가
            dic.addWord(sb.toString());
            //찾은 단어 index 저장 (마지막 글자는 빼서 조회해야 한다.)
            result.add(dic.dictionary.get(sb.deleteCharAt(sb.length() - 1).toString()));
        }
        return result.stream().mapToInt(n -> n).toArray();
    }

    class Dictionary {
        int indexNumber = 1;
        HashMap<String, Integer> dictionary = new HashMap<>();

        public Dictionary() {
            initialize();
        }

        private void initialize() {
            for (char ch = 'A'; ch <= 'Z'; ch++) {
                dictionary.put(String.valueOf(ch), indexNumber++);
            }
        }

        public void addWord(String word) {
            dictionary.put(word, indexNumber);
            indexNumber++;
        }
    }
}
