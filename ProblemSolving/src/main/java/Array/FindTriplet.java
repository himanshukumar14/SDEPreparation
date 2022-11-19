package Array;

/*
Given an array of positive integers of size n. Find the maximum product of triplet( ai * aj * ak ) such that 0 <= i < j < k < n and ai < aj < ak.
 */

import java.util.TreeSet;

/*
Simple Approach is to traverse for every triplet with three nested ‘for loops’ and
find update the sum of all triplets one by one. Time complexity of this approach is O(n3)
which is not sufficient for a larger value of ‘n’.

Better approach is to make further optimization in above approach. Instead of traversing
through every triplets with three nested loops, we can traverse through two nested loops.
While traversing through each number(assume as middle element(aj)),
find maximum number(ai) smaller than aj preceding it and maximum number(ak) greater
than aj beyond it. Now after that, update the maximum answer with calculated product of ai * aj * ak
 */

/*
Best and efficient approach is use the concept of maximum suffix-array and binary search.
For finding a maximum number greater than given number beyond it,
we can maintain a maximum suffix-array such that for any number(suffixi)
it would contain maximum number from index i, i+1, … n-1. Suffix array can be calculated in O(n) time.
For finding maximum number smaller than the given number preceding it,
we can maintain a sorted list of numbers before a given number such
we can simply perform a binary search to find a number which is just smaller than the given number.
In C++ language, we can perform this by using set associative container of STL library.
 */
//Time complexity: O(n*log(n))
//Auxiliary space: O(n)

public class FindTriplet {
    public static void main(String[] args) {
        int arr[] = {5,4,3,2,1};
        int n = arr.length;

        System.out.println(maxTripletProduct(arr, n));
    }

    public static int maxTripletProduct(int arr[], int n) {
        int[] rightMaxSuff = new int[n];
        rightMaxSuff[n - 1] = -1;
        for (int i = n - 2; i >= 0; --i) {
            int lmax = Math.max(rightMaxSuff[i + 1], arr[i + 1]);
            rightMaxSuff[i] = lmax;
            if(lmax <= arr[i]) {
                rightMaxSuff[i] = -1;
            }
            System.out.println(rightMaxSuff[i]);
        }

        int max = Integer.MIN_VALUE;
        TreeSet<Integer> leftStore = new TreeSet<>();
        leftStore.add(arr[0]);
        for (int i = 1; i < n - 1; ++i) {
            leftStore.add(arr[i]);
            Integer leftMax = leftStore.lower(arr[i]);
            int rightMax = rightMaxSuff[i];
            if(leftMax != null && rightMax != -1) {
                int ans = leftMax * arr[i] * rightMax;
                max = Math.max(ans, max);
            }
        }
        return max;
    }
}
