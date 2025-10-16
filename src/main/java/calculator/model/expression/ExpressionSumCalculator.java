package calculator.model.expression;

import calculator.model.SumCalculator;
import calculator.model.nonnegative.NonNegative;
import calculator.model.nonnegative.NonNegativeFactory;
import calculator.model.nonnegative.NonNegativeUtils;
import java.util.List;

public class ExpressionSumCalculator implements SumCalculator<String, String> {

    private final ExpressionParser expressionParser;
    private final SumCalculator<List<NonNegative>, NonNegative> delegate;

    public ExpressionSumCalculator(ExpressionParser expressionParser,
                                   SumCalculator<List<NonNegative>, NonNegative> delegate) {
        this.expressionParser = expressionParser;
        this.delegate = delegate;
    }

    @Override
    public String sum(String expressionInput) {
        if (expressionInput.isBlank()) {
            return NonNegativeFactory.zero().stringValue();
        }
        Expression expression = expressionParser.parse(expressionInput);
        List<NonNegative> nonNegatives = NonNegativeUtils.toNonNegatives(expression.getTokens());
        return delegate.sum(nonNegatives).stringValue();
    }
}
