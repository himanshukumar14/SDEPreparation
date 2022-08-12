package TwoPointers;

public class RainWaterTrapping {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public int trap(int[] height) {
		int[] leftMax = new int[height.length];
		int[] rightMax = new int[height.length];

		for (int i = 0; i < height.length; ++i) {
			if (i == 0)
				leftMax[i] = Integer.MIN_VALUE;
			else if (i > 0)
				leftMax[i] = Math.max(leftMax[i - 1], height[i - 1]);
		}

		for (int i = height.length - 1; i >= 0; --i) {
			if (i == height.length - 1)
				rightMax[i] = Integer.MIN_VALUE;
			else if (i < height.length - 1)
				rightMax[i] = Math.max(rightMax[i + 1], height[i + 1]);
		}

		int water = 0;

		for (int i = 1; i < height.length - 1; ++i) {
			water = water + Math.max(0, Math.min(leftMax[i], rightMax[i]) - height[i]);
		}
		return water;
	}

}
