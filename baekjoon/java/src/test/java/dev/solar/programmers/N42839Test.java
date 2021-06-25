package dev.solar.programmers;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

class N42839Test {

    N42839 n42839 = new N42839();

    @Test
    void case01() {
        assertThat(n42839.solution("17")).isEqualTo(3);
    }

    @Test
    void case02() {
        assertThat(n42839.solution("011")).isEqualTo(2);
    }

    @Test
    @DisplayName("String \"12345\" -> int[] {1, 2, 3, 4, 5}")
    void temp() {
        String numbers = "12345";
        int[] ints = numbers.chars().toArray();
        for (int anInt : ints) {
            System.out.println(anInt - '0');
        }
        int[] numbersArray = Arrays.stream(numbers.chars().toArray()).map(i -> i - '0').toArray();
        int[] expected = {1, 2, 3, 4, 5};
        assertThat(numbersArray).isEqualTo(expected);
    }
}
