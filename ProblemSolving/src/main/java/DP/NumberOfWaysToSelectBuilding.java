package DP;

/**
 * You are given a 0-indexed binary string s which represents the types of buildings along a street where:
 *
 * s[i] = '0' denotes that the ith building is an office and
 * s[i] = '1' denotes that the ith building is a restaurant.
 * As a city official, you would like to select 3 buildings for random inspection. However, to ensure variety, no two consecutive buildings out of the selected buildings can be of the same type.
 *
 * For example, given s = "001101", we cannot select the 1st, 3rd, and 5th buildings as that would form "011" which is not allowed due to having two consecutive buildings of the same type.
 * Return the number of valid ways to select 3 buildings.
 *
 * Example 1:
 *
 * Input: s = "001101"
 * Output: 6
 * Explanation:
 * The following sets of indices selected are valid:
 * - [0,2,4] from "001101" forms "010"
 * - [0,3,4] from "001101" forms "010"
 * - [1,2,4] from "001101" forms "010"
 * - [1,3,4] from "001101" forms "010"
 * - [2,4,5] from "001101" forms "101"
 * - [3,4,5] from "001101" forms "101"
 * No other selection is valid. Thus, there are 6 total ways.
 * Example 2:
 *
 * Input: s = "11100"
 * Output: 0
 * Explanation: It can be shown that there are no valid selections.
 *
 *
 * Constraints:
 *
 * 3 <= s.length <= 105
 * s[i] is either '0' or '1'.
 */

public class NumberOfWaysToSelectBuilding {
    public static void main(String[] args) {

    }

    /**
     *
     * The only valid combinations possible are 101 and 010.
     * So, lets traverse the string and consider the current character as the centeral character of the combination.
     *
     * This means, if the current character is '0', then all we need to do it find the number of 1 before this 0
     * and number of 1 after this 0 and multiply them to add them to the answer.
     * We do the same for the central character as '1' and count the number of 0 before and after this one.
     */
    public long numberOfWays(String s) {
        int n = s.length();
        int[] numZero = new int[n];
        int[] numOne = new int[n];
        long ans = 0;

        if(s.charAt(0) == '0')
            numZero[0] = 1;
        else
            numOne[0] = 1;

        for(int i = 1; i < n; ++i) {
            if(s.charAt(i) == '0') {
                numZero[i] = numZero[i - 1] + 1;
                numOne[i] = numOne[i - 1];
            } else {
                numOne[i] = numOne[i - 1] + 1;
                numZero[i] = numZero[i - 1];
            }
        }

        for(int i = 1; i < n - 1; ++i) {
            if(s.charAt(i) == '0') {
                ans += numOne[i - 1] * (numOne[n - 1] - numOne[i]);
            } else {
                ans += numZero[i - 1] * (numZero[n - 1] - numZero[i]);
            }
        }
        return ans;
    }
}
