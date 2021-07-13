package dev.solar.programmers;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

public class N42840 {
    public int[] solution(int[] answers) {
        int[] answerOfOne = {1, 2, 3, 4, 5};
        int[] answerOfTwo = {2, 1, 2, 3, 2, 4, 2, 5};
        int[] answerOfThree = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5};
        Queue<Integer> one = new ConcurrentLinkedQueue<>();
        Queue<Integer> two = new ConcurrentLinkedQueue<>();
        Queue<Integer> three = new ConcurrentLinkedQueue<>();
        Arrays.stream(answerOfOne).forEach(one::offer);
        Arrays.stream(answerOfTwo).forEach(two::offer);
        Arrays.stream(answerOfThree).forEach(three::offer);

        int[] countOfAnswer = new int[4];
        for (int answer : answers) {
            int num = one.poll();
            if (num == answer) {
                countOfAnswer[1]++;
            }
            one.offer(num);
            num = two.poll();
            if (num == answer) {
                countOfAnswer[2]++;
            }
            two.offer(num);
            num = three.poll();
            if (num == answer) {
                countOfAnswer[3]++;
            }
            three.offer(num);
        }

        int max = 0;
        List<Integer> result = new LinkedList<>();
        for (int i = 1; i < countOfAnswer.length; i++) {
            if (countOfAnswer[i] == max) {
                result.add(i);
                max = countOfAnswer[i];
            } else if (countOfAnswer[i] > max) {
                result.clear();
                result.add(i);
                max = countOfAnswer[i];
            }
        }

        return result.stream().mapToInt(i->i).toArray();
    }
}
