package calculator.utils;

import java.math.BigInteger;
import java.util.List;

public class BigIntegerConverter {

    private BigIntegerConverter() {
    }

    public static List<BigInteger> toBigIntegers(List<String> values) {
        return values.stream().map(BigIntegerConverter::toBigInteger).toList();
    }

    public static BigInteger toBigInteger(String value) {
        try {
            return new BigInteger(value);
        }catch (NumberFormatException e) {
            throw new IllegalArgumentException("is not a number");
        }
    }
}
