package DP;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class BoxStacking {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public int stackBoxes(int[][] boxes) { // l,w,h     l should be strictly greater than w
		List<Box> possibleBoxes = new ArrayList<>();
		int n = boxes.length;
		for (int i = 0; i < n; ++i) {
			generatePossibleBoxes(boxes[i], possibleBoxes);
		}
		Collections.sort(possibleBoxes, new Comparator<Box>() {
			public int compare(Box b1, Box b2) {
				return (b2.l * b2.w) - (b1.l * b1.w);
			}
		});
		n = possibleBoxes.size();
		int[] dp = new int[n];
		for (int i = 0; i < n; ++i) {
			dp[i] = possibleBoxes.get(i).h;
		}
		int max = 0;
		for (int i = 1; i < n; ++i) {
			for (int j = 0; j < i; ++j) {
				if (possibleBoxes.get(j).l > possibleBoxes.get(i).l
						&& possibleBoxes.get(j).w > possibleBoxes.get(i).w) {
					dp[i] = Math.max(dp[i], dp[j] + possibleBoxes.get(i).h);
				}
			}
			max = Math.max(max, dp[i]);
		}
		return max;
	}

	public void generatePossibleBoxes(int[] box, List<Box> boxes) {
		int l = box[0];
		int w = box[1];
		int h = box[2];
		// only three permutations possible
		boxes.add(new Box(l, w, h));
		boxes.add(new Box(l, h, w));
		boxes.add(new Box(Math.max(w, h), Math.min(w, h), l));
	}

	class Box {
		int l;
		int w;
		int h;

		public Box(int l, int w, int h) {
			this.l = l;
			this.w = w;
			this.h = h;
		}
	}
}
