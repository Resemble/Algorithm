package tenth;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @author ranbo
 * @version V1.0
 * @Title:
 * @Package tenth
 * @Description: 146. LRU缓存机制 使用 LinkedHashMap 实现
 * @date 2019-11-02 15:24
 */
public class LRUCache {

    private int capacity;
    private Map<Integer, Integer> map = new LinkedHashMap<>();

    public LRUCache(int capacity) {
        this.capacity = capacity;
    }

    public int get(int key) {
        if (map.get(key) != null) {
            int value = map.get(key);
            map.remove(key);
            /** 放到末尾 */
            map.put(key, value);
            return value;
        }
        return -1;
    }

    public void put(int key, int value) {
        if (map.get(key) != null) {
            map.remove(key);
        } else if (map.size() == capacity) {
            int firstKey = map.entrySet().iterator().next().getKey();
            map.remove(firstKey);
        }

        map.put(key, value);
    }


}
