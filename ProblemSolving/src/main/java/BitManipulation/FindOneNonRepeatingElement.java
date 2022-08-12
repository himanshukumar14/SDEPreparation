package BitManipulation;

public class FindOneNonRepeatingElement {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = new int[] { 2, 3, 7, 9, 11, 2, 3, 11, 9 };
		int n = arr.length;
		UniqueNumbers(arr, n);
	}
	public static void UniqueNumbers(int[] arr, int n) {
		int sum = 0;
		for (int i = 0; i < n; i++) {
			sum = sum ^ arr[i]; // xor of the array
		}
	

		// print the the two unique numbers
		System.out.println("The non-repeating elements are " + sum);
	}
}
