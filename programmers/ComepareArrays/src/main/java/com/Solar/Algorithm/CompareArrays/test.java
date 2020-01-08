package com.Solar.Algorithm.CompareArrays;

public class test {
    public static void main(String[] args) {
        CompareArrays test = new CompareArrays();

        String[] participant = { "mislav", "stanko", "mislav", "ana" };
        String[] completion = { "stanko", "ana", "mislav" };

        String result = test.solution( participant, completion );
        System.out.println("result : " + result);
    }
}
