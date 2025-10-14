package calculator;

import java.math.BigInteger;
import java.util.Objects;

public class Position {

    public static final Position ZERO = of(BigInteger.ZERO);

    private final BigInteger value;

    private Position(BigInteger value) {
        valid(value);
        this.value = value;
    }

    public Position sum(Position position){
        return of(value.add(position.value));
    }

    public Long toLong() {
        return value.longValue();
    }

    public static Position of(BigInteger value) {
        return new Position(value);
    }

    public static Position of(Long value) {
        return of(BigInteger.valueOf(value));
    }

    public static Position of(String value) {
        try {
            return of(new BigInteger(value));
        }catch (NumberFormatException e) {
            throw new IllegalArgumentException("is not a number");
        }
    }

    private static void valid(BigInteger value) {
        if(value.compareTo(BigInteger.ZERO) < 0) {
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
