package calculator.model.positive;

import java.math.BigInteger;
import java.util.Objects;

public class Positive {

    private final BigInteger value;

    Positive(BigInteger value) {
        valid(value);
        this.value = value;
    }

    public Positive sum(Positive positive) {
        return PositiveFactory.from(value.add(positive.value));
    }

    public String stringValue() {
        return value.toString();
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
