package dev.solar.naver;

import java.util.Queue;
import java.util.Stack;
import java.util.concurrent.ConcurrentLinkedQueue;

public class Webtoon02 {
    public String[] solution(String s) {
        // 순서를 중간에 넣어줘야하니깐 left는 큐로, right는 스택으로 나눠 넣고 합쳐준다.
        Queue<String> left = new ConcurrentLinkedQueue<>();
        Stack<String> right = new Stack<>();
        while (!s.isEmpty()) {
            char firstChar = s.charAt(0);
            int lastCharIndex = s.lastIndexOf(firstChar);//뒤에서부터 찾아냄
            if (lastCharIndex == 0) { //일치하는게 없는 경우
                left.offer(s);
                s = "";
                continue;
            }
            String word = s.substring(lastCharIndex); //일치하는 단어를 찾아냄
            s = s.substring(0, lastCharIndex);
            s = s.substring(word.length());
            left.offer(word);
            right.push(word);
        }

        String[] answer = new String[left.size() + right.size()];
        int index = 0;
        while (!left.isEmpty()) {
            answer[index++] = left.poll();
        }
        while (!right.isEmpty()) {
            answer[index++] = right.pop();
        }

        return answer;
    }
}
