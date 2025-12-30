package assertj.sp1ta4le2ex5;

import java.util.HashMap;
import java.util.Map;

public class MyMap {
    private Map<String, Integer> map;

    public MyMap() {
        this.map = new HashMap<>();
    }

    public void addEntry(String key, Integer value) {
        if (key != null) {
            map.put(key, value);
        }
    }

    public boolean containsKey(String key) {
        return map.containsKey(key);
    }

    public Integer getValue(String key) {
        return map.get(key);
    }

    public Integer removeEntry(String key) {
        return map.remove(key);
    }
}