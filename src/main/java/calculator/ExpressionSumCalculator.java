package calculator;

import java.util.ArrayList;
import java.util.List;

public class ExpressionSumCalculator implements SumCalculator<String, Long> {

    private final InputParser parser;
    private final SeparatorFactory separatorFactory;
    private final SumCalculator<List<Position>,Position> delegate;

    public ExpressionSumCalculator(InputParser parser, SeparatorFactory separatorFactory, SumCalculator<List<Position>,Position> delegate) {
        this.parser = parser;
        this.separatorFactory = separatorFactory;
        this.delegate = delegate;
    }

    @Override
    public Long sum(String expression) {
        List<String> numbers = analyze(expression);
        List<Position> positions = toPositions(numbers);
        return delegate.sum(positions).toLong();
    }

    private List<String> analyze(String expression) {
        Separator separator = separatorFactory.extract(parser.extractSeparator(expression));
        String content = parser.extractContent(expression);
        return separator.separate(content);
    }

    private List<Position> toPositions(List<String> numbers) {
        return numbers.stream().map(Position::of).toList();
    }
}
