package calculator;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.Test;

public class PositiveSumCalculatorTest {

    @Test
    void Position_리스트_합계_계산() {
        PositiveSumCalculator positiveSumCalculator = new PositiveSumCalculator();
        List<Positive> positives = List.of(Positive.of(1L), Positive.of(2L));

        Positive result = positiveSumCalculator.sum(positives);

        assertThat(result).isEqualTo(Positive.of(3L));
    }
}
