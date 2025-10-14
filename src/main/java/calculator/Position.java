package calculator;

public class Position {

    private final Long value;

    private Position(Long value) {
        if(value < 0) {
            throw new IllegalArgumentException("Negative value");
        }
        this.value = value;
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
}
