package dev.solar.programmers;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class N12933Test {

    N12933 n12933 = new N12933();

    @Test
    void temp() {
        int n = 118372;
        List<Integer> numbers = new ArrayList<>();
        while (n > 0) {
            numbers.add((int) n % 10);
            n /= 10;
        }
        List<Integer> expected = new ArrayList<>();
        expected.add(2);
        expected.add(7);
        expected.add(3);
        expected.add(8);
        expected.add(1);
        expected.add(1);
        assertThat(numbers.equals(expected)).isTrue();
    }

    @Test
    void case01() {
        long n = 12345;
        long expected = 54321;
        long actual = n12933.solution(n);
        assertThat(actual).isEqualTo(expected);
    }

    @Test
    void case02() {
        long n = 0;
        long expected = 0;
        long actual = n12933.solution(n);
        assertThat(actual).isEqualTo(expected);
    }

    @Test
    void case03() {
        long n = 11111;
        long expected = 11111;
        long actual = n12933.solution(n);
        assertThat(actual).isEqualTo(expected);
    }

    @Test
    void case04() {
        long n = 10101;
        long expected = 11100;
        long actual = n12933.solution(n);
        assertThat(actual).isEqualTo(expected);
    }
}
