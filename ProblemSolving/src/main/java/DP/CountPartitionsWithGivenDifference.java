package DP;

/**
 * 
 * Given an array ‘ARR’, partition it into two subsets (possibly empty) such
 * that their union is the original array. Let the sum of the elements of these
 * two subsets be ‘S1’ and ‘S2’. Given a difference ‘D’, count the number of
 * partitions in which ‘S1’ is greater than or equal to ‘S2’ and the difference
 * between ‘S1’ and ‘S2’ is equal to ‘D’. Since the answer may be too large,
 * return it modulo ‘10^9 + 7’. If ‘Pi_Sj’ denotes the Subset ‘j’ for Partition
 * ‘i’. Then, two partitions P1 and P2 are considered different if: 1) P1_S1 !=
 * P2_S1 i.e, at least one of the elements of P1_S1 is different from P2_S2. 2)
 * P1_S1 == P2_S2, but the indices set represented by P1_S1 is not equal to the
 * indices set of P2_S2. Here, the indices set of P1_S1 is formed by taking the
 * indices of the elements from which the subset is formed. Refer to the example
 * below for clarification. Note that the sum of the elements of an empty subset
 * is 0. For Example : If N = 4, D = 3, ARR = {5, 2, 5, 1} There are only two
 * possible partitions of this array. Partition 1: {5, 2, 1}, {5}. The subset
 * difference between subset sum is: (5 + 2 + 1) - (5) = 3 Partition 2: {5, 2,
 * 1}, {5}. The subset difference between subset sum is: (5 + 2 + 1) - (5) = 3
 * These two partitions are different because, in the 1st partition, S1 contains
 * 5 from index 0, and in the 2nd partition, S1 contains 5 from index 2.
 *
 * 
 */

public class CountPartitionsWithGivenDifference {

	// based on subset sum //give count of two subsets S1 and S2 with S1 - S2 = D
	/**
	 * s1 - s2 = D Total sum = s1 + s2
	 * 
	 * s1 = (Totalsum + D) / 2 s2 = (TotalSum - D) / 2 so question boils down to
	 * find the count of subset with sum = k
	 * 
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n = 4;
		int a[] = { 3, 3, 3, 3 };
		int d = 3;

		int total = 0;
		for (int i = 0; i < n; ++i) {
			total += a[i];
		}

		System.out.print(subsetSum(a, n, (total - d) / 2));
	}

	public static int subsetSum(int a[], int n, int sum) {
		int tab[][] = new int[n + 1][sum + 1];
		tab[0][0] = 1;

		for (int i = 1; i <= sum; i++)
			tab[0][i] = 0;

		for (int i = 1; i <= n; i++) {
			for (int j = 0; j <= sum; j++) {
				if (j - a[i - 1] >= 0) {
					tab[i][j] = tab[i - 1][j] + tab[i - 1][j - a[i - 1]];
				} else {
					tab[i][j] = tab[i - 1][j];
				}
			}
		}
		return tab[n][sum];
	}

}
