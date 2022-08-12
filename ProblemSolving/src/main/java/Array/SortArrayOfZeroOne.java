package Array;

//Dutch National Flag
public class SortArrayOfZeroOne {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = new int[] { 1, 1, 0, 0, 0, 1, 1, 0, 1, 1 };
		arr = sortZeroOne(arr);
		for (int x : arr) {
			System.out.println(x);
		}
	}

	public static int[] sortZeroOne(int[] arr) {
		int n = arr.length;

		int i = 0;
		int j = n - 1;

		while (i < j) {
			if (arr[i] == 0) {
				i++;
			} else {
				int temp = arr[j];
				arr[j] = arr[i];
				arr[i] = temp;
				j--;
			}
		}
		return arr;
	}

}
