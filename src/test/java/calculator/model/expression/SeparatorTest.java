package calculator.model.expression;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

public class SeparatorTest {

    @ParameterizedTest
    @MethodSource(value = "provideSeparateTestCases")
    void 구분자에_맞게_문자분리(List<String> separators, String input, List<String> expected) {
        Separator separator = new Separator(separators.toArray(new String[0]));

        List<String> result = separator.separate(input);

        assertThat(result).isEqualTo(expected);
    }

    private static Stream<Arguments> provideSeparateTestCases() {
        return Stream.of(
                Arguments.of(List.of(",", ":"), "a:b,c", List.of("a", "b", "c")),
                Arguments.of(List.of("우테코 화이팅"), "a우테코 화이팅b우테코 화이팅c", List.of("a", "b", "c")),
                Arguments.of(List.of(","), "1,2,3", List.of("1", "2", "3")),
                Arguments.of(List.of("."), "a.b.c", List.of("a", "b", "c")),
                Arguments.of(List.of(","), "", List.of("")),
                Arguments.of(List.of(","), "abc", List.of("abc")),
                Arguments.of(List.of(","), "1,,3", List.of("1", "", "3")),
                Arguments.of(List.of(","), ",1,2,", List.of("", "1", "2", ""))
        );
    }
}
