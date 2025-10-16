package calculator.model.nonnegative;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.Test;

class NonNegativeUtilsTest {

    @Test
    void 문자열_리스트를_NonNegative_리스트로_변환() {
        List<String> input = List.of("1", "100", "12");

        List<NonNegative> nonNegatives = NonNegativeUtils.toNonNegatives(input);

        assertThat(nonNegatives).extracting(NonNegative::stringValue).containsExactly("1", "100", "12");
    }
}