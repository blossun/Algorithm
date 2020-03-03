package com.Solar.Algorithm.CompareArrays;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class CompareArrays {
    public String solution(String[] participant, String[] completion) {
        String answer = "";

//        List<String> list = Arrays.asList(completion);
        List<String> list = new LinkedList<String>(Arrays.asList(participant));

//        System.out.println(list.toString());

        for( int i=0; i < completion.length; i++ ) {
            if( list.contains(completion[i]) ) {
                int idx = list.indexOf(completion[i]);
                if ( idx != -1 ) list.remove(idx);
            }
        }
        answer = list.get(0);
        return answer;
    }
}
