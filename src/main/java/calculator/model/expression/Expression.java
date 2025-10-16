package calculator.model.expression;

import java.util.List;
import java.util.Objects;

public class Expression {

    private final Separator separator;
    private final String context;

    public Expression(String separator, String context) {
        this.separator = getSeparator(separator);
        this.context = context;
    }

    public List<String> getTokens() {
        return separator.separate(context);
    }

    public Separator getSeparator() {
        return separator;
    }

    public String getContext() {
        return context;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Expression that = (Expression) o;
        return Objects.equals(separator, that.separator) && Objects.equals(context, that.context);
    }

    @Override
    public int hashCode() {
        return Objects.hash(separator, context);
    }

    private static Separator getSeparator(String separator) {
        if (separator != null && !separator.isBlank()) {
            return SeparatorFactory.customSeparator(separator);
        }
        return SeparatorFactory.defaultSeparator();
    }
}
