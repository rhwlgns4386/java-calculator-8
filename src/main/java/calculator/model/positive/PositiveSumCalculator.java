package calculator.model.positive;

import calculator.model.SumCalculator;
import java.util.List;

public class PositiveSumCalculator implements SumCalculator<List<Positive>, Positive> {

    @Override
    public Positive sum(List<Positive> input) {
        Positive result = Positive.zero();
        for (Positive positive : input) {
            result = result.sum(positive);
        }
        return result;
    }
}
