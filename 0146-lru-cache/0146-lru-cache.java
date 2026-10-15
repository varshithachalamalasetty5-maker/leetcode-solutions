
import java.util.*;

class LRUCache {
    private int capacity;
    private LinkedHashMap<Integer, Integer> map;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        map = new LinkedHashMap<>(capacity, 0.75f, true);
    }

    public int get(int key) {
        return map.getOrDefault(key, -1);
    }

    public void put(int key, int value) {
        map.put(key, value);

        if (map.size() > capacity) {
            int oldestKey = map.keySet().iterator().next();
            map.remove(oldestKey);
        }
    }
}
