package Array;
import java.util.ArrayList;
import java.util.List;

/**
 * 
 * Given an integer numRows, return the first numRows of Pascal's triangle.
 * 
 * In Pascal's triangle, each number is the sum of the two numbers directly
 * above it as shown:
 *
 */

public class PascalTriangle {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public static List<List<Integer>> getPascalTriangle(int a) {
		List<List<Integer>> ans = new ArrayList<>();
		if (a == 0)
			return ans;

		ans.add(new ArrayList<>());
		ans.get(0).add(1);

		for (int i = 1; i < a; ++i) {
			List<Integer> prev = ans.get(i - 1);
			List<Integer> inner = new ArrayList<>();
			inner.add(1);
			for (int j = 1; j < prev.size(); ++j) {
				inner.add(prev.get(j) + prev.get(j - 1));
			}
			inner.add(1);
			ans.add(inner);
		}
		return ans;
	}
}
