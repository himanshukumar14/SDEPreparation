package Array;
import java.util.ArrayList;
import java.util.List;

public class KthRowPascalTriangle {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public static List<Integer> getPascalRow(int a) {
		List<Integer> prevRow = new ArrayList<>();

		for (int i = 0; i <= a; ++i) {
			List<Integer> tempRow = new ArrayList<>();

			for (int j = 0; j <= i; ++j) {
				if(j == 0 || j == i)
					tempRow.add(1);
				else
					tempRow.add(prevRow.get(j - 1) + prevRow.get(j));
			}
			prevRow = tempRow;
		}
		return prevRow;
	}

}
