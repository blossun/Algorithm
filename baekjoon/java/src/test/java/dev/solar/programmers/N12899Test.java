package dev.solar.programmers;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class N12899Test {

    N12899 n12899 = new N12899();

    @ParameterizedTest
    @MethodSource("paramsForTest")
    void name(int number, String result) {
        String actual = n12899.solution(number);

        assertThat(actual).isEqualTo(result);
    }

    private static Stream<Arguments> paramsForTest() { // argument source method
        return Stream.of(
                Arguments.of(1, "1"),
                Arguments.of(2, "2"),
                Arguments.of(3, "4"),
                Arguments.of(4, "11"),
                Arguments.of(5, "12"),
                Arguments.of(6, "14"),
                Arguments.of(7, "21"),
                Arguments.of(8, "22"),
                Arguments.of(9, "24"),
                Arguments.of(10, "41")
        );
    }
}
