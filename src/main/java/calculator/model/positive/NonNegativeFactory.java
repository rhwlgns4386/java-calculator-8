package calculator.model.positive;

import java.math.BigInteger;
import java.util.Optional;

public class NonNegativeFactory {

    private static final NonNegative ZERO = new NonNegative(BigInteger.ZERO);

    private static final int CACHE_SIZE = 30;
    private static final NonNegativeCache cache = new NonNegativeCache(CACHE_SIZE);

    private NonNegativeFactory() {
    }

    public static NonNegative from(BigInteger value) {
        if(value.equals(BigInteger.ZERO)) {
            return ZERO;
        }
        Optional<NonNegative> findNonNegative = cache.get(value);
        if (findNonNegative.isPresent()) {
            return findNonNegative.get();
        }
        NonNegative nonNegative = new NonNegative(value);
        cache.put(value, nonNegative);
        return nonNegative;
    }

    public static NonNegative from(String value) {
        try {
            return from(new BigInteger(value));
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("is not a number");
        }
    }

    public static NonNegative zero() {
        return ZERO;
    }
}
