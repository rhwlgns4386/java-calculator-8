package calculator;

import java.util.List;

public class ExpressionSumCalculatorFactory {
    private ExpressionSumCalculatorFactory() {
    }

    public static ExpressionSumCalculator createCalculator() {
        InputParser parser = createParser();
        SeparatorFactory separatorFactory = createSeparatorFactory();
        SumCalculator<List<Position>, Position> delegate = createDelegate();
        return new ExpressionSumCalculator(parser, separatorFactory, delegate);
    }

    private static InputParser  createParser() {
        return new CustomSeparatorInputParser();
    }

    private static SeparatorFactory createSeparatorFactory() {
        return new SeparatorFactory();
    }

    private static SumCalculator<List<Position>, Position> createDelegate() {
        return new PositionCalculator();
    }
}
