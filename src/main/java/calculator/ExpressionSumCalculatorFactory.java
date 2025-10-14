package calculator;

import java.util.List;

public class ExpressionSumCalculatorFactory {

    private static final String DEFAULT_SEPARATOR_PATTERN = "^//(.*)\\\\n";

    private ExpressionSumCalculatorFactory() {
    }

    public static ExpressionSumCalculator createCalculator() {
        InputParser parser = createParser();
        SumCalculator<List<Position>, Position> delegate = createDelegate();
        return new ExpressionSumCalculator(parser, delegate);
    }

    private static InputParser createParser() {
        return new CustomSeparatorInputParser(DEFAULT_SEPARATOR_PATTERN);
    }

    private static SumCalculator<List<Position>, Position> createDelegate() {
        return new PositionCalculator();
    }
}
