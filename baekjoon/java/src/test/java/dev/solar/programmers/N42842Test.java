package dev.solar.programmers;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class N42842Test {

    N42842 n42842 = new N42842();

    @ParameterizedTest
    @MethodSource("paramsForTest")
    void case01(int brown, int yellow, int[] result) {
        int[] actual = n42842.solution(brown, yellow);

        assertThat(actual).isEqualTo(result);
    }

    private static Stream<Arguments> paramsForTest() {
        return Stream.of(
                Arguments.of(10, 2, new int[]{4, 3}),
                Arguments.of(8, 1, new int[]{3, 3}),
                Arguments.of(24, 24, new int[]{8, 6})
        );
    }
}
