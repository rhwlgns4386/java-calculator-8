package calculator;

import java.util.List;

public class ExpressionSumCalculator implements SumCalculator<String, String> {

    private final CustomSeparatorInputParser parser;
    private final SumCalculator<List<Position>, Position> delegate;

    public ExpressionSumCalculator(CustomSeparatorInputParser parser,
                                   SumCalculator<List<Position>, Position> delegate) {
        this.parser = parser;
        this.delegate = delegate;
    }

    @Override
    public String sum(String expression) {
        List<String> numbers = analyze(expression);
        List<Position> positions = toPositions(numbers);
        return delegate.sum(positions).stringValue();
    }

    private List<String> analyze(String expression) {
        Separator separator = parser.extractSeparator(expression);
        String content = parser.extractContent(expression);
        return separator.separate(content);
    }

    private List<Position> toPositions(List<String> numbers) {
        return numbers.stream().map(Position::of).toList();
    }
}
