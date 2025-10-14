package calculator.model.expression;

import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class Separator {

    private final Set<String> separators;

    public Separator(String... separators) {
        this.separators = Set.of(separators);
    }

    public List<String> separate(String input) {
        return List.of(input.split(getPattern(), -1));
    }

    private String getPattern() {
        return separators.stream()
                .map(Pattern::quote)
                .collect(Collectors.joining("|"));
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Separator separator = (Separator) o;
        return Objects.equals(separators, separator.separators);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(separators);
    }
}
