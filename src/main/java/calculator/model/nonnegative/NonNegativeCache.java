package calculator.model.nonnegative;

import java.math.BigInteger;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Optional;

public class NonNegativeCache {

    private final LinkedHashMap<BigInteger, NonNegative> cache;
    private final int size;

    public NonNegativeCache(int size) {
        this.size = size;
        this.cache = new LinkedHashMap<>(16, 0.75f, true) {
            @Override
            protected boolean removeEldestEntry(Map.Entry<BigInteger, NonNegative> eldest) {
                return size() > NonNegativeCache.this.size;
            }
        };
    }

    public Optional<NonNegative> get(BigInteger value) {
        return Optional.ofNullable(cache.get(value));
    }

    public void put(BigInteger value, NonNegative nonNegative) {
        cache.put(value, nonNegative);
    }
}
