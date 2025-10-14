package calculator;

import java.math.BigInteger;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Optional;

public class PositionCache {

    private final LinkedHashMap<BigInteger, Position> cache;
    private final int size;

    public PositionCache(int size) {
        this.size = size;
        this.cache = new LinkedHashMap<>(16, 0.75f, true) {
            @Override
            protected boolean removeEldestEntry(Map.Entry<BigInteger, Position> eldest) {
                return size() > PositionCache.this.size;
            }
        };
    }

    public Optional<Position> get(BigInteger value) {
        return Optional.ofNullable(cache.get(value));
    }

    public void put(BigInteger value, Position position) {
        cache.put(value, position);
    }
}
