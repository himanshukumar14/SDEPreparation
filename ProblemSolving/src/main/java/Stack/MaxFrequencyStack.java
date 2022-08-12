package Stack;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class MaxFrequencyStack {

	private Map<Integer, Stack<Integer>> stackMap = null;
	private Map<Integer, Integer> freqMap = null;
	private int maxFreq = 0;

	public MaxFrequencyStack() {
		stackMap = new HashMap<>();
		freqMap = new HashMap<>();
	}

	public void push(int val) {
		freqMap.put(val, freqMap.getOrDefault(val, 0) + 1);
		int freq = freqMap.get(val);
		maxFreq = Math.max(maxFreq, freq);

		Stack<Integer> freqStack = stackMap.getOrDefault(freq, new Stack<>());
		freqStack.push(val);
		stackMap.put(freq, freqStack);
	}

	public int pop() {
		Stack<Integer> stack = stackMap.get(maxFreq);
		int num = stack.pop();
		if (stack.isEmpty()) {
			stackMap.remove(maxFreq);
			maxFreq--;
		}
		freqMap.put(num, freqMap.getOrDefault(num, 0) - 1);
		return num;
	}

}
