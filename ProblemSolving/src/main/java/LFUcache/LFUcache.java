package LFUcache;

import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.Map;

public class LFUcache {
	Map<Integer, Integer> map;
	Map<Integer, LinkedHashSet<Integer>> freqList;
	Map<Integer, Integer> freq;
	int capacity;
	int count;
	int minFreq;

	LFUcache(int capacity) {
		this.capacity = capacity;
		this.count = 0;
		this.minFreq = -1;
		map = new HashMap<>();
		freq = new HashMap<>();
		freqList = new HashMap<>();
	}

	public int get(int key) {
		if (map.containsKey(key)) {
			int count = freq.get(key);
			freq.put(key, count + 1);
			freqList.get(count).remove(key);
			if (count == minFreq && freqList.get(count).size() == 0) {
				freqList.remove(count);
				minFreq++;
			}
			if (!freqList.containsKey(count + 1))
				freqList.put(count + 1, new LinkedHashSet<>());
			freqList.get(count + 1).add(key);
			return map.get(key);
		}
		return -1;
	}

	public void set(int key, int value) {
        if(capacity <= 0)
            return;
		if (map.containsKey(key)) {
			int count = freq.get(key);
			freq.put(key, count + 1);
			freqList.get(count).remove(key);
			if (count == minFreq && freqList.get(count).size() == 0) {
				freqList.remove(count);
				minFreq++;
			}
			if (!freqList.containsKey(count + 1))
				freqList.put(count + 1, new LinkedHashSet<>());
			freqList.get(count + 1).add(key);
			map.put(key, value);
		} else {
			if (count < capacity) {
				count++;
			} else {
				int evict = freqList.get(minFreq).iterator().next();
				freqList.get(minFreq).remove(evict);
				map.remove(evict);
				freq.remove(evict);
			}
			freq.put(key, 1);
			minFreq = 1;
			if (!freqList.containsKey(1))
				freqList.put(1, new LinkedHashSet<>());
			freqList.get(1).add(key);
			map.put(key, value);
		}
	}
}
