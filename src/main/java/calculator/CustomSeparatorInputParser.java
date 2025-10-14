package calculator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CustomSeparatorInputParser implements InputParser {

    private static final Pattern PATTERN = Pattern.compile("^//(.*)\\n");

    @Override
    public String extractSeparator(String input) {
        Matcher matcher = PATTERN.matcher(input);
        if (matcher.find()) {
            return matcher.group(0);
        }
        return "";
    }

    @Override
    public String extractContent(String input) {
        Matcher matcher = PATTERN.matcher(input);
        if (matcher.find()) {
            return input.substring(matcher.end());
        }
        return input;
    }
}
