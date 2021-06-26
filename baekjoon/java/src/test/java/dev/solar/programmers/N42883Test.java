package dev.solar.programmers;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class N42883Test {

    @Test
    void temp() {
        String number = "1924";
        int[] numbers = number.chars().map(x -> x - '0').toArray();
        int[] expected = {1, 9, 2, 4};
        assertArrayEquals(numbers, expected);
    }

    @Test
    void temp02() {
        String number = "1924";
        int[] numbers = number.chars().map(x -> x - '0').toArray();
        int[] expected = {1, 9, 2, 4};
        assertArrayEquals(numbers, expected);
    }

    @Test
    void temp03() {
        String number = "1924";
        List<Integer> numbers = Stream.of(number.split("")).map(Integer::parseInt).collect(Collectors.toList());
        List<Integer> expected = new ArrayList<>();
        expected.add(1);
        expected.add(9);
        expected.add(2);
        expected.add(4);
        assertThat(numbers).isEqualTo(expected);
    }
}
