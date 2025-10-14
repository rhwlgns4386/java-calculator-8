package calculator;

import java.util.Objects;

public class Position {

    private final Long value;

    private Position(Long value) {
        valid(value);
        this.value = value;
    }

    public Long toLong() {
        return value;
    }

    public static Position of(Long value) {
        return new Position(value);
    }

    public static Position of(String value) {
        try {
            return new Position(Long.parseLong(value));
        }catch (NumberFormatException e) {
            throw new IllegalArgumentException("is not a number");
        }
    }

    private static void valid(Long value) {
        if(value < 0) {
            throw new IllegalArgumentException("Negative value");
        }
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Position position = (Position) o;
        return Objects.equals(value, position.value);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(value);
    }
}
