package calculator.model.expression;

import calculator.model.nonnegative.NonNegative;
import calculator.model.nonnegative.NonNegativeSumCalculator;
import calculator.model.SumCalculator;
import java.util.List;

public class ExpressionSumCalculatorFactory {

    private static final String DEFAULT_SEPARATOR_PATTERN = "^//(.*)\\\\n";

    private ExpressionSumCalculatorFactory() {
    }

    public static ExpressionSumCalculator createCalculator() {
        CustomSeparatorInputParser parser = createParser();
        SumCalculator<List<NonNegative>, NonNegative> delegate = createDelegate();
        return new ExpressionSumCalculator(parser, delegate);
    }

    private static CustomSeparatorInputParser createParser() {
        return new CustomSeparatorInputParser(DEFAULT_SEPARATOR_PATTERN);
    }

    private static SumCalculator<List<NonNegative>, NonNegative> createDelegate() {
        return new NonNegativeSumCalculator();
    }
}
