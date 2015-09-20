import java.util.LinkedHashMap;

public class LRUCache {
    
    private final LinkedHashMap<Integer, Integer> cache;
    
    public LRUCache(int capacity) {
        int cacheCapacity = (int)Math.ceil(capacity / 0.75f) + 1;
        cache = new LinkedHashMap<Integer, Integer>(cacheCapacity, 0.75f, true) {
            @Override
            protected boolean removeEldestEntry(Map.Entry eldest) {
                return cache.size() > capacity;
            }
        };
    }
    
    public int get(int key) {
        Integer val = cache.get(key);
        if(val == null) {
            return -1;
        }
        return val.intValue();
    }
    
    public void set(int key, int value) {
        cache.put(key, value);
    }
}