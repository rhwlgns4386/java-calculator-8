package calculator.model.expression;

import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegexExpressionParser implements ExpressionParser {

    private static final int EXPECTED_GROUP_COUNT = 2;
    private static final String SEPARATOR_GROUP_NAME = "separator";
    private static final String CONTEXT_GROUP_NAME = "context";

    private final Pattern pattern;

    public RegexExpressionParser(String pattern) {
        this.pattern = Pattern.compile(pattern);
        Map<String, Integer> namedGroups = this.pattern.namedGroups();
        validateRequiredGroupExists(namedGroups, SEPARATOR_GROUP_NAME);
        validateRequiredGroupExists(namedGroups, CONTEXT_GROUP_NAME);
        validateTotalGroupCount(namedGroups);
    }

    @Override
    public Expression parse(String expression) {
        Matcher matcher = pattern.matcher(expression);
        boolean matches = matcher.matches();
        if (matches) {
            return createExpression(matcher.group(SEPARATOR_GROUP_NAME), matcher.group(CONTEXT_GROUP_NAME));
        }
        return createExpression("", expression);
    }

    private Expression createExpression(String separator, String context) {
        return new Expression(separator, context);
    }

    private void validateRequiredGroupExists(Map<String, Integer> groups, String groupName) {
        if (!groups.containsKey(groupName)) {
            throw new IllegalArgumentException(
                    String.format("Pattern must contain '%s' named group", groupName)
            );
        }
    }

    private void validateTotalGroupCount(Map<String, Integer> groups) {
        if (groups.size() != EXPECTED_GROUP_COUNT) {
            throw new IllegalArgumentException(
                    String.format("Pattern must have exactly %d groups, but found %d",
                            EXPECTED_GROUP_COUNT, groups.size())
            );
        }
    }
}
