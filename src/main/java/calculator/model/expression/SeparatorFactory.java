package calculator.model.expression;

import java.util.Arrays;

public class SeparatorFactory {

    private static final String[] DEFAULT_SEPARATORS = {",", ":"};

    private SeparatorFactory() {
    }

    public static Separator customSeparator(String separator) {
        String[] separators = Arrays.copyOf(DEFAULT_SEPARATORS, DEFAULT_SEPARATORS.length + 1);
        separators[DEFAULT_SEPARATORS.length] = separator;
        return new Separator(separators);
    }

    public static Separator defaultSeparator() {
        return new Separator(Arrays.copyOf(DEFAULT_SEPARATORS, DEFAULT_SEPARATORS.length));
    }
}
