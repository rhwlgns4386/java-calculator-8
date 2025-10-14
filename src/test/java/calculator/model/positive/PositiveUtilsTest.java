package calculator.model.positive;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.Test;

class PositiveUtilsTest {

    @Test
    void 문자열_리스트를_Positive_리스트로_변환() {
        List<String> input = List.of("1", "100", "12");

        List<Positive> positives = PositiveUtils.toPositives(input);

        assertThat(positives).extracting(Positive::stringValue).containsExactly("1", "100", "12");
    }
}