package calculator.model.nonnegative;

import calculator.utils.BigIntegerConverter;
import java.math.BigInteger;
import java.util.List;

public class NonNegativeUtils {

    private NonNegativeUtils() {
    }

    public static List<NonNegative> toNonNegatives(List<String> numbers) {
        List<BigInteger> bigIntegers = BigIntegerConverter.toBigIntegers(numbers);
        return bigIntegers.stream().map(NonNegative::from).toList();
    }
}
