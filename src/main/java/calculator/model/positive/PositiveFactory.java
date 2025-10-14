package calculator.model.positive;

import java.math.BigInteger;
import java.util.Optional;

public class PositiveFactory {

    public static final Positive ZERO = new Positive(BigInteger.ZERO);

    private static final PositiveCache cache = new PositiveCache(30);

    private PositiveFactory() {
    }

    public static Positive from(BigInteger value) {
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

    public static Positive from(String value) {
        try {
            return from(new BigInteger(value));
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("is not a number");
        }
    }
}
