package calculator.model.expression;

import calculator.model.SumCalculator;
import calculator.model.nonnegative.NonNegative;
import calculator.model.nonnegative.NonNegativeSumCalculator;
import java.util.List;

public class ExpressionSumCalculatorFactory {

    private static final String DEFAULT_EXPRESSION_PATTERN = "^//(?<separator>.*)\\\\n(?<context>.*)$";

    private ExpressionSumCalculatorFactory() {
    }

    public static ExpressionSumCalculator createCalculator() {
        ExpressionParser expressionParser = createExpressionParser();
        SumCalculator<List<NonNegative>, NonNegative> delegate = createDelegate();
        return new ExpressionSumCalculator(expressionParser, delegate);
    }

    private static ExpressionParser createExpressionParser() {
        return new RegexExpressionParser(DEFAULT_EXPRESSION_PATTERN);
    }

    private static SumCalculator<List<NonNegative>, NonNegative> createDelegate() {
        return new NonNegativeSumCalculator();
    }
}
