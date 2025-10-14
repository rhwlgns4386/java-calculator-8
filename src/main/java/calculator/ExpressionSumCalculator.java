package calculator;

import java.util.ArrayList;
import java.util.List;

public class ExpressionSumCalculator implements SumCalculator<String, Long> {

    private final CustomSeparatorInputParser parser;
    private final SeparatorFactory separatorFactory;

    public ExpressionSumCalculator(CustomSeparatorInputParser parser, SeparatorFactory separatorFactory) {
        this.parser = parser;
        this.separatorFactory = separatorFactory;
    }

    @Override
    public Long sum(String expression) {
        List<String> numbers = analyze(expression);
        List<Position> positions = toPositions(numbers);
        return 0L;
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
