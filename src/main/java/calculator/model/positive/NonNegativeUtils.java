package calculator.model.positive;

import java.util.List;

public class NonNegativeUtils {

    private NonNegativeUtils() {
    }

    public static List<NonNegative> toPositives(List<String> numbers) {
        return numbers.stream().map(NonNegativeFactory::from).toList();
    }
}
