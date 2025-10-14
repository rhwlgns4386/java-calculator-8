package calculator.model.expression;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CustomSeparatorInputParser {

    private final Pattern pattern;

    public CustomSeparatorInputParser(String pattern) {
        this.pattern = Pattern.compile(pattern);
    }

    public Separator extractSeparator(String input) {
        Matcher matcher = pattern.matcher(input);
        if (matcher.find()) {
            return SeparatorFactory.customSeparator(matcher.group(1));
        }
        return SeparatorFactory.defaultSeparator();
    }

    public String extractContent(String input) {
        Matcher matcher = pattern.matcher(input);
        if (matcher.find()) {
            return input.substring(matcher.end());
        }
        return input;
    }
}
