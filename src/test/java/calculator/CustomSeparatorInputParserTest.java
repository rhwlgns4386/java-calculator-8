package calculator;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

public class CustomSeparatorInputParserTest {

    private static final String PATTEN = "^//(.*)\\\\n";

    @ParameterizedTest
    @MethodSource("provideSeparatorCases")
    void 구분자_패턴_추출(String input, Separator expected) {
        CustomSeparatorInputParser parser = new CustomSeparatorInputParser(PATTEN);

        Separator result = parser.extractSeparator(input);

        assertThat(result).isEqualTo(expected);
    }

    @ParameterizedTest
    @MethodSource("provideContentCases")
    void 본문_내용_추출(String input, String expected) {
        CustomSeparatorInputParser parser = new CustomSeparatorInputParser(PATTEN);

        String result = parser.extractContent(input);

        assertThat(result).isEqualTo(expected);
    }

    private static Stream<Arguments> provideSeparatorCases() {
        return Stream.of(
                Arguments.of("//-\\n1;2;3", SeparatorFactory.customSeparator("-")),
                Arguments.of("//;\\n1;2;3", SeparatorFactory.customSeparator(";")),
                Arguments.of("1,2,3", SeparatorFactory.defaultSeparator()),
                Arguments.of("", SeparatorFactory.defaultSeparator())
        );
    }

    private static Stream<Arguments> provideContentCases() {
        return Stream.of(
                Arguments.of("//-\\n1;2;3", "1;2;3"),
                Arguments.of("//;\\n1;2;3", "1;2;3"),
                Arguments.of("1,2,3", "1,2,3"),
                Arguments.of("", "")
        );
    }
}
