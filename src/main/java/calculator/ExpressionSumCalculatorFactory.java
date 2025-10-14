package calculator;

import java.util.List;

public class ExpressionSumCalculatorFactory {

    private static final String DEFAULT_SEPARATOR_PATTERN = "^//(.*)\\\\n";

    private ExpressionSumCalculatorFactory() {
    }

    public static ExpressionSumCalculator createCalculator() {
        CustomSeparatorInputParser parser = createParser();
        SumCalculator<List<Positive>, Positive> delegate = createDelegate();
        return new ExpressionSumCalculator(parser, delegate);
    }

    private static CustomSeparatorInputParser createParser() {
        return new CustomSeparatorInputParser(DEFAULT_SEPARATOR_PATTERN);
    }

    private static SumCalculator<List<Positive>, Positive> createDelegate() {
        return new PositiveSumCalculator();
    }
}
