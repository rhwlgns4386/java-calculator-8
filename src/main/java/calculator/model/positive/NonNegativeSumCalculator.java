package calculator.model.positive;

import calculator.model.SumCalculator;
import java.util.List;

public class NonNegativeSumCalculator implements SumCalculator<List<NonNegative>, NonNegative> {

    @Override
    public NonNegative sum(List<NonNegative> input) {
        NonNegative result = NonNegativeFactory.zero();
        for (NonNegative nonNegative : input) {
            result = result.sum(nonNegative);
        }
        return result;
    }
}
