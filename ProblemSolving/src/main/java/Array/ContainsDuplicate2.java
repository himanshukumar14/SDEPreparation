package Array;

import java.util.HashMap;
import java.util.Map;

public class ContainsDuplicate2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public boolean containsNearbyDuplicate(int[] nums, int k) {
		Map<Integer, Integer> map = new HashMap<>();
		int n = nums.length;
		boolean flag = false;
		for (int i = 0; i < n; ++i) {
			if (map.containsKey(nums[i])) {
				int index = map.get(nums[i]);
				flag = i - index <= k ? true : false;
			}
			map.put(nums[i], i);
			if (flag)
				break;
		}
		return flag;
	}

}
