package calculator.model.expression;

import calculator.model.positive.Positive;
import calculator.model.SumCalculator;
import calculator.model.positive.PositiveUtils;
import java.util.List;

public class ExpressionSumCalculator implements SumCalculator<String, String> {

    private final CustomSeparatorInputParser parser;
    private final SumCalculator<List<Positive>, Positive> delegate;

    public ExpressionSumCalculator(CustomSeparatorInputParser parser,
                                   SumCalculator<List<Positive>, Positive> delegate) {
        this.parser = parser;
        this.delegate = delegate;
    }

    @Override
    public String sum(String expression) {
        List<String> numbers = analyze(expression);
        List<Positive> positives = PositiveUtils.toPositives(numbers);
        return delegate.sum(positives).stringValue();
    }

    private List<String> analyze(String expression) {
        Separator separator = parser.extractSeparator(expression);
        String content = parser.extractContent(expression);
        return separator.separate(content);
    }
}
