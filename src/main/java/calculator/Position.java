package calculator;

import java.math.BigInteger;
import java.util.Objects;
import java.util.Optional;

public class Position {

    public static final Position ZERO = new Position(BigInteger.ZERO);

    private static final PositionCache cache = new PositionCache(30);

    private final BigInteger value;

    private Position(BigInteger value) {
        valid(value);
        this.value = value;
    }

    public Position sum(Position position) {
        return of(value.add(position.value));
    }

    public String stringValue() {
        return value.toString();
    }

    public static Position of(BigInteger value) {
        if(value.equals(BigInteger.ZERO)) {
            return ZERO;
        }
        Optional<Position> findPosition = cache.get(value);
        if (findPosition.isPresent()) {
            return findPosition.get();
        }
        Position position = new Position(value);
        cache.put(value, position);
        return position;
    }

    public static Position of(Long value) {
        return of(BigInteger.valueOf(value));
    }

    public static Position of(String value) {
        try {
            return of(new BigInteger(value));
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("is not a number");
        }
    }

    public static Position zero() {
        return ZERO;
    }

    private static void valid(BigInteger value) {
        if (value.compareTo(BigInteger.ZERO) < 0) {
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
