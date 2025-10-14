package calculator.model.positive;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.Test;

public class NonNegativeSumCalculatorTest {

    @Test
    void Position_리스트_합계_계산() {
        NonNegativeSumCalculator nonNegativeSumCalculator = new NonNegativeSumCalculator();
        List<NonNegative> nonNegatives = List.of(NonNegativeFactory.from("1"), NonNegativeFactory.from("2"));

        NonNegative result = nonNegativeSumCalculator.sum(nonNegatives);

        assertThat(result).isEqualTo(NonNegativeFactory.from("3"));
    }
}
