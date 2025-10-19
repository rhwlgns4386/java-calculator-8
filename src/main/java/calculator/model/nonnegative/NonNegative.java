package calculator.model.nonnegative;

import java.math.BigInteger;
import java.util.Objects;
import java.util.Optional;

public class NonNegative {

    private static final NonNegative ZERO = new NonNegative(BigInteger.ZERO);

    private static final int CACHE_SIZE = 30;
    private static final NonNegativeCache cache = new NonNegativeCache(CACHE_SIZE);

    private final BigInteger value;

    private NonNegative(BigInteger value) {
        validate(value);
        this.value = value;
    }

    public static NonNegative from(BigInteger value) {
        if (value.equals(BigInteger.ZERO)) {
            return ZERO;
        }
        Optional<NonNegative> cachedValue = cache.get(value);
        if (cachedValue.isPresent()) {
            return cachedValue.get();
        }
        NonNegative nonNegative = new NonNegative(value);
        cache.put(value, nonNegative);
        return nonNegative;
    }

    public static NonNegative zero() {
        return ZERO;
    }

    public NonNegative sum(NonNegative nonNegative) {
        return NonNegative.from(value.add(nonNegative.value));
    }

    public String stringValue() {
        return value.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        NonNegative nonNegative = (NonNegative) o;
        return Objects.equals(value, nonNegative.value);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(value);
    }

    private static void validate(BigInteger value) {
        if (value.compareTo(BigInteger.ZERO) < 0) {
            throw new IllegalArgumentException("Negative value");
        }
    }
}
