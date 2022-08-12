package Matrix;

public class RotateMatrix {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int arr[][] = { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } };
		System.out.println("UnRotated Image");
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr.length; j++) {
				System.out.print(arr[i][j] + " ");
			}
			System.out.println();
		}
		rotate(arr);
		System.out.println("Rotated Image");
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr.length; j++) {
				System.out.print(arr[i][j] + " ");
			}
			System.out.println();
		}
	}

	public static void rotate(int[][] matrix) {
		int n = matrix.length;
		int m = matrix[0].length;
		transpose(matrix);
		reverse(matrix);
	}

	public static void reverse(int[][] matrix) {
		int n = matrix.length;
		int m = matrix[0].length;

		for (int i = 0; i < n; ++i) {
			int l = 0;
			int r = m - 1;
			while (l < r) {
				int temp = matrix[i][l];
				matrix[i][l] = matrix[i][r];
				matrix[i][r] = temp;
				l++;
				r--;
			}
		}
	}

	public static void transpose(int[][] matrix) {
		int n = matrix.length;
		int m = matrix[0].length;

		for (int k = 1; k <= m; ++k) {
			for (int i = 0; i < n - k + 1; ++i) {
				int j = i + k - 1;
				if(i == j)
					continue;
				int temp = matrix[i][j];
				matrix[i][j] = matrix[j][i];
				matrix[j][i] = temp;
			}
		}
	}

}
