package calculator.model.expression;

import calculator.model.SumCalculator;
import calculator.model.nonnegative.NonNegative;
import calculator.model.nonnegative.NonNegativeFactory;
import calculator.model.nonnegative.NonNegativeUtils;
import java.util.List;

public class ExpressionSumCalculator implements SumCalculator<String, String> {

    private final CustomSeparatorInputParser parser;
    private final SumCalculator<List<NonNegative>, NonNegative> delegate;

    public ExpressionSumCalculator(CustomSeparatorInputParser parser,
                                   SumCalculator<List<NonNegative>, NonNegative> delegate) {
        this.parser = parser;
        this.delegate = delegate;
    }

    @Override
    public String sum(String expression) {
        if(expression.isBlank()){
            return NonNegativeFactory.zero().stringValue();
        }
        List<String> numbers = analyze(expression);
        List<NonNegative> nonNegatives = NonNegativeUtils.toNonNegatives(numbers);
        return delegate.sum(nonNegatives).stringValue();
    }

    private List<String> analyze(String expression) {
        Separator separator = parser.extractSeparator(expression);
        String content = parser.extractContent(expression);
        return separator.separate(content);
    }
}
