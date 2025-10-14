package calculator;

import java.math.BigInteger;
import java.util.Objects;
import java.util.Optional;

public class Positive {

    public static final Positive ZERO = new Positive(BigInteger.ZERO);

    private static final PositiveCache cache = new PositiveCache(30);

    private final BigInteger value;

    private Positive(BigInteger value) {
        valid(value);
        this.value = value;
    }

    public Positive sum(Positive positive) {
        return of(value.add(positive.value));
    }

    public String stringValue() {
        return value.toString();
    }

    public static Positive of(BigInteger value) {
        if(value.equals(BigInteger.ZERO)) {
            return ZERO;
        }
        Optional<Positive> findPosition = cache.get(value);
        if (findPosition.isPresent()) {
            return findPosition.get();
        }
        Positive positive = new Positive(value);
        cache.put(value, positive);
        return positive;
    }

    public static Positive of(Long value) {
        return of(BigInteger.valueOf(value));
    }

    public static Positive of(String value) {
        try {
            return of(new BigInteger(value));
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("is not a number");
        }
    }

    public static Positive zero() {
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
        Positive positive = (Positive) o;
        return Objects.equals(value, positive.value);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(value);
    }
}
