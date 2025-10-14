package calculator;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SeparatorFactory {

    private static final Pattern CUSTOM_SEPARATOR_PATTERN = Pattern.compile("//(.*)\\n");

    private static final String[] DEFAULT_SEPARATORS = {",", ":"};

    public Separator extract(String input) {
        return new Separator(getSeparators(input));
    }

    private String[] getSeparators(String input) {
        Matcher matcher = CUSTOM_SEPARATOR_PATTERN.matcher(input);
        if (matcher.find()) {
            return new String[]{matcher.group(1)};
        }
        return Arrays.copyOf(DEFAULT_SEPARATORS, DEFAULT_SEPARATORS.length);
    }
}
