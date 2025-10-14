package calculator;

import java.math.BigInteger;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Optional;

public class PositiveCache {

    private final LinkedHashMap<BigInteger, Positive> cache;
    private final int size;

    public PositiveCache(int size) {
        this.size = size;
        this.cache = new LinkedHashMap<>(16, 0.75f, true) {
            @Override
            protected boolean removeEldestEntry(Map.Entry<BigInteger, Positive> eldest) {
                return size() > PositiveCache.this.size;
            }
        };
    }

    public Optional<Positive> get(BigInteger value) {
        return Optional.ofNullable(cache.get(value));
    }

    public void put(BigInteger value, Positive positive) {
        cache.put(value, positive);
    }
}
