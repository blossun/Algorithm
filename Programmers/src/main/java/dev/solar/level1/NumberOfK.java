package dev.solar.level1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class NumberOfK {
    public int[] solution(int[] array, int[][] commands) {
        //TODO
        int[] answer = new int[commands.length];
        for (int i = 0; i < commands.length; i++) {
            List<Integer> tempList = new ArrayList<>();
            for (int j: commands[i]) {
                tempList.add(j);
            }
            int[] copyArray = Arrays.copyOf(array, array.length);
            int[] ints = Arrays.copyOfRange(copyArray, tempList.get(0)-1, tempList.get(1));
            Arrays.sort(ints);
//            System.out.println(tempList.get(2)-1);
            answer[i] = ints[tempList.get(2)-1];
//            for (int z = 0; z < ints.length; z++) {
//                System.out.println(ints[z]);
//            }
        }
        return answer;
    }
}
