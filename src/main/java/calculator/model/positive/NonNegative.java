package calculator.model.positive;

import java.math.BigInteger;
import java.util.Objects;

public class NonNegative {

    private final BigInteger value;

    NonNegative(BigInteger value) {
        validate(value);
        this.value = value;
    }

    public NonNegative sum(NonNegative nonNegative) {
        return NonNegativeFactory.from(value.add(nonNegative.value));
    }

    public String stringValue() {
        return value.toString();
    }

    private static void validate(BigInteger value) {
        if (value.compareTo(BigInteger.ZERO) < 0) {
            throw new IllegalArgumentException("Negative value");
        }
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
}
