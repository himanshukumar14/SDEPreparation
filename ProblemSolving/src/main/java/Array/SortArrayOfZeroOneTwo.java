package Array;

public class SortArrayOfZeroOneTwo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = new int[] { 0, 1, 0, 0, 0, 1, 1, 0, 1, 1 };
		arr = sortZeroOneTwo(arr);
		for (int x : arr) {
			System.out.println(x);
		}
	}

	public static int[] sortZeroOneTwo(int[] arr) {
		int n = arr.length;

		int i = 0;
		int k = 0;
		int j = n - 1;

		while (k < j) {
			if (arr[k] == 0) {
				int temp = arr[i];
				arr[i] = arr[k];
				arr[k] = temp;
				i++;
				k++;
			} else if (arr[k] == 2) {
				int temp = arr[j];
				arr[j] = arr[k];
				arr[k] = temp;
				j--;
			} else {
				k++;
			}
		}
		return arr;
	}

}
