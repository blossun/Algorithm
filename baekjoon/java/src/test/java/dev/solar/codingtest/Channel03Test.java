package dev.solar.codingtest;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Comparator;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class Channel03Test {
    Channel03 channel03 = new Channel03();

    @Test
    void temp() {
        String[] example = {"0", "zzz", "abc"};
//        Arrays.sort(example, Comparator.reverseOrder());
        Arrays.sort(example);
        System.out.println(Arrays.toString(example));

        String str1 = "0";
        String str2 = "abc";
        String str3 = "zzz";
        System.out.println(str1.compareTo(str2)); //-49
        System.out.println(str2.compareTo(str1)); //49
        System.out.println(str2.compareTo(str3)); //-25
        System.out.println(str2.compareTo(str2)); //0
        //오름차순 기준 : 올바른 순서면 음수, 아니면 양수
        //왼쪽값이 오른쪽 값을 기준으로 얼마나 떨어져 있는 위치인다. 음수면 왼쪽, 양수면 오른쪽
    }

    @Test
    void case01() {
        String letters = "zbgaj";
        int k = 3;
        String expected = "zgj";
        String actual = channel03.solution(letters, k);
        assertThat(actual).isEqualTo(expected);
    }

    @Test
    void case02() {
        String letters = "azbzgazj";
        int k = 3;
        String expected = "zzz";
        String actual = channel03.solution(letters, k);
        assertThat(actual).isEqualTo(expected);
    }

    @Test
    void case03() {
        String letters = "azbzgazaj";
        int k = 4;
        String expected = "zzzj";
        String actual = channel03.solution(letters, k);
        assertThat(actual).isEqualTo(expected);
    }

    @Test
    void case04() {
        String letters = "abcdzefghijklmnopqrs";
        int k = 4;
        String expected = "zqrs";
        String actual = channel03.solution(letters, k);
        assertThat(actual).isEqualTo(expected);
    }
}
