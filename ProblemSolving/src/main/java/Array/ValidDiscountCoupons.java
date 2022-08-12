package Array;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 * At Amazon’s annual sale, employees are tasked with generating valid discount
 * coupons for loyal customers. However, there are some used/invalid coupons in
 * the mix, and the challenge in this task is to determine whether a given
 * discount coupon is valid or not.
 * 
 * The validity of a discount coupon is determined as follows:
 * 
 * An empty discount coupon is valid. If a discount coupon A is valid, then a
 * discount coupon C made by adding one character x to both the beginning of A
 * and the end of A is also valid (i.e the discount coupon C = xAx is valid). If
 * two discount coupons A and Bare valid, then the concatenation of B and A is
 * also valid (i.e the coupons AB and BA are both valid). Given n discount
 * coupons, each coupon consisting of only lower case English characters, where
 * the i-th discount coupon is denoted discounts[i], determine if each discount
 * coupon is valid or not. A valid coupon is denoted by 1 in the answer array
 * while an invalid coupon is denoted by 0.
 * 
 * Example discounts = [‘tabba’; ‘abca’]
 * 
 * Check if this coupon code can be constructed within the rules of a valid
 * coupon. Checking ‘abba’: • The empty string is valid per the first rule. •
 * Under the second rule, the same character can be added to the beginning and
 * end of a valid coupon code. Add ‘b’ to the beginning and end of the empty
 * string to have ‘bb’, a valid code. • Using the same rule, ‘a’ is added to the
 * beginning and end of the ‘bb’ coupon string. Again, the string is valid.
 * 
 * The string is valid, so the answer array is [1].
 * 
 * Checking ‘abca’: • Using rule 2, a letter can be added to both ends of a
 * string without altering its validity. The ‘a’ added to the beginning and end
 * of ‘bc’ does not change its validity. • The remaining string ‘Ix’, is not
 * valid. There is no rule allowing the addition of different characters to the
 * ends of a string.
 * 
 * Since the string is invalid, append 0 to the answer array. There are no more
 * strings to test, so return [1,0]
 * 
 * Function Description
 * 
 * Complete the function find ValidDiscountCoupons in the editor below.
 * 
 * find ValidDiscountCoupons has the following parameter: string discounts[n]:
 * the discount coupons to validate
 * 
 * Returns int[n]: each element i is 1 if the coupon discounts[il is valid and 0
 * otherwise
 *
 */

public class ValidDiscountCoupons {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public List<Integer> isValidCoupons(List<String> coupons) {
		int n = coupons.size();
		List<Integer> result = new ArrayList<>();
		for(int i = 0; i < n; ++i) {
			String coupon = coupons.get(i);
			int m = coupon.length();
			boolean[][] pal = new boolean[m][m];
			setPalindrome(coupon, pal);
			if(coupon.length() == 0) {
				result.add(1);
			} else if(coupon.length() % 2 == 1) {
				result.add(0);
			} else if(isPalindrome(0, n - 1, pal)) {
				result.add(1);
			} else if(isPalindromeCombo(coupon, pal)) {
				result.add(1);
			} else {
				result.add(0);
			}
		}
		return result;
	}
	
	public boolean isPalindromeCombo(String word, boolean[][] pal) {
		int n = word.length();
		for(int k = 1; k < n - 2; ++k) {
			if(pal[0][k] && pal[k + 1][n - 1])
				return true;
		}
		return false;
	}
	
    public boolean[][] setPalindrome(String word, boolean[][] pal) {
        int n = word.length();
        for(int k = 1; k <= n; ++k) {
            for(int i = 0; i < n - k + 1; ++i) {
                int j = i + k - 1;
                if(word.charAt(i) == word.charAt(j) && (j == i || j == i + 1 || pal[i + 1][j - 1]))
                    pal[i][j] = true;
                else
                    pal[i][j] = false;
            }
        }
        return pal;
    }
    
    public boolean isPalindrome(int i, int j, boolean[][] isPal) {
        return isPal[i][j];
    }

}
