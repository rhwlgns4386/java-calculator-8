package calculator.model.positive;

import java.util.List;

public class PositiveUtils {

    private PositiveUtils() {
    }

    public static List<Positive> toPositives(List<String> numbers) {
        return numbers.stream().map(PositiveFactory::from).toList();
    }
}
