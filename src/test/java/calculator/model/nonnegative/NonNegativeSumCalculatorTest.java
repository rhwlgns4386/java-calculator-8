package calculator.model.nonnegative;

import static org.assertj.core.api.Assertions.assertThat;

import java.math.BigInteger;
import java.util.List;
import org.junit.jupiter.api.Test;

public class NonNegativeSumCalculatorTest {

    @Test
    void NonNegative_리스트_합계_계산() {
        NonNegativeSumCalculator nonNegativeSumCalculator = new NonNegativeSumCalculator();
        List<NonNegative> nonNegatives = NonNegativeUtils.toNonNegatives(List.of("1","2"));

        NonNegative result = nonNegativeSumCalculator.sum(nonNegatives);

        assertThat(result).isEqualTo(NonNegative.from(new BigInteger("3")));
    }

    // 빈 리스트 - 테스트 없음!
    @Test
    void 빈_리스트_합계() {
        NonNegative result = new NonNegativeSumCalculator().sum(List.of());
        assertThat(result).isEqualTo(NonNegative.zero());
    }
}
