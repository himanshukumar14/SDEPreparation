package BinarySearch;

/**
 * 
 * Given an array of integers A of size N and an integer B.
 * 
 * The College library has N books. The ith book has A[i] number of pages.
 * 
 * You have to allocate books to B number of students so that the maximum number
 * of pages allocated to a student is minimum.
 * 
 * A book will be allocated to exactly one student. Each student has to be
 * allocated at least one book. Allotment should be in contiguous order, for
 * example: A student cannot be allocated book 1 and book 3, skipping book 2.
 * Calculate and return that minimum possible number.
 * 
 * NOTE: Return -1 if a valid assignment is not possible.
 * 
 * Problem Constraints 1 <= N <= 105 1 <= A[i], B <= 105
 * 
 * Input Format The first argument given is the integer array A. The second
 * argument given is the integer B.
 * 
 * Output Format Return that minimum possible number.
 * 
 * Example Input A = [12, 34, 67, 90] B = 2
 * 
 * Example Output 113
 * 
 * Example Explanation There are two students. Books can be distributed in
 * following fashion :
 * 
 * 1) [12] and [34, 67, 90] Max number of pages is allocated to student 2 with
 * 34 + 67 + 90 = 191 pages 2) [12, 34] and [67, 90] Max number of pages is
 * allocated to student 2 with 67 + 90 = 157 pages 3) [12, 34, 67] and [90] Max
 * number of pages is allocated to student 1 with 12 + 34 + 67 = 113 pages Of
 * the 3 cases, Option 3 has the minimum pages = 113.
 * 
 */

public class AllocateBooks {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public int books(int[] A, int B) {
		if (B > A.length)
			return -1;
		long min = 0;
		long max = 0;
		int ans = Integer.MAX_VALUE;

		for (int i = 0; i < A.length; ++i) {
			max += A[i];
			min = Math.max(min, A[i]);
		}

		while (min <= max) {
			int mid = (int) (min + (max - min) / 2);
			if (isPossible(A, B, mid)) {
				ans = mid;
				max = mid - 1;
			} else {
				min = mid + 1;
			}
		}
		return ans;
	}

	public boolean isPossible(int[] A, int B, int size) {
		int sum = 0;
		int stud = 1;
		for (int i = 0; i < A.length; ++i) {
			if (A[i] > size)
				return false;
			sum = sum + A[i];
			if (sum > size) {
				stud++;
				sum = A[i];
			}
		}
		return stud <= B;
	}
	
	//try dp solution as well

}
