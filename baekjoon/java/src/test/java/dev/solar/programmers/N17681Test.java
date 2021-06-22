package dev.solar.programmers;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class N17681Test {

    @Test
    void temp() {
        int[] arr1 = {9, 20, 28, 18, 11};
        int n = arr1.length;
        for (int i = 0; i < arr1.length; i++) {
//            System.out.println(Integer.toBinaryString(arr1[i]).toCharArray());
            char[] chars1 = String.format("%"+ n + "s", Integer.toBinaryString(arr1[i])).replaceAll(" ", "0").toCharArray();
            System.out.println(chars1);

        }
//        char[] chars1 = Integer.toBinaryString(arr1[1]).toCharArray();
    }

}
