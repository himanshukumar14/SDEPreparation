package Heaps;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.PriorityQueue;

public class TopKFrequentWords {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public List<String> getKFrequent(String[] words, int k) {
		List<String> result = new ArrayList<>();
		Map<String, Integer> map = new HashMap<>();
		PriorityQueue<Store> pq = new PriorityQueue<>(new Comparator<Store>() {
			public int compare(Store s1, Store s2) {
				if(s1.count == s2.count) {
					return s1.word.compareTo(s2.word);
				}
				return s2.count - s1.count;
			}
		});
		
		int n = words.length;
		for(int i = 0; i < n; ++i) {
			map.put(words[i], map.getOrDefault(words[i], 0) + 1);
		}
		
		for(Entry<String, Integer> e : map.entrySet()) {
			pq.add(new Store(e.getKey(), e.getValue()));
		}
		for(int i = 0; i < k; ++i) {
			result.add(pq.poll().word);
		}
		return result;
	}

	class Store {
		String word;
		int count;

		Store(String word, int count) {
			this.word = word;
			this.count = count;
		}
	}
}
