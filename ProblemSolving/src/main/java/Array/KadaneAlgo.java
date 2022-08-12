package Array;

public class KadaneAlgo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public int kadaneAlgo(int[] arr) {
		int maxSum = Integer.MIN_VALUE;
		int n = arr.length;
		
		int sum = 0; 
		for(int i = 0; i < n; ++i) {
			sum += arr[i];
			maxSum = Math.max(sum, maxSum);
			if(sum < 0)
				sum = 0;
		}
		return maxSum;
	}

}
