package Array;

/*
Amazon Web Services (AWS) is working on a new security feature to help encode text.
Consider a string that consists of lowercase English alphabetic letters (i.e., [a-z]) only. The following rules are used to encode all of its characters into string s:

a is encoded as 1, b is encoded as 2, c is encoded as 3, ..., and i is encoded as 9.
j is encoded as 10#, k is encoded as 11#, l is encoded as 12#, ..., and z is encoded as 26#.
If there are two or more consecutive occurrences of any character, then the character count is written within parentheses (i.e., (c),
where c is an integer denoting the count of consecutive occurrences being encoded) immediately following the encoded character.
For example, consider the following string encodings:
String "abzx" encoded as s = "1226#24#".
String "aabccc" is encoded as s = "1(2)23(3)".
String "bajj" is encoded as s = "2110#(2)".
String "wwxyzwww" is encoded as s = "23#(2)24#25#26#23#(3)".
Given an encoded string s, determine the character counts for each letter of the original, decoded string.
Return an integer array of length 26 where index 0 contains the number of 'a' characters, index 1 contains the number of 'b' characters and so on.
 */

public class DecodeStringFrequency {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] ans = decode("1(2)23(3)");
		for(int i = 0; i<26;++i) {
			if(ans[i] > 0) {
				System.out.println((char)('a' + i) + " - " + ans[i]);
			}
		}
	}
	
	
	public static int[] decode(String word) {
		int n = word.length();
		int[] ans = new int[26];
		int i = 0;
		int j = 1;
		while(j < n) {
			if(word.charAt(j) == '(') {
				if(word.charAt(j - 1) == '#') {
					int prev = j - 4;
					int num = (word.charAt(j - 3) - '0') * 10 + (word.charAt(j - 2) - '0');
					int repeat = 0;
					j++;
					while(word.charAt(j) != ')') {
						repeat = (repeat * 10) + (word.charAt(j++) -'0');
					}
					ans[num - 1] += repeat;
					process(i, prev, word, ans);
					j++;
					i = j;
				} else {
					int prev = j - 2;
					int num = word.charAt(j - 1) - '0';
					int repeat = 0;
					j++;
					while(word.charAt(j) != ')') {
						repeat = (repeat * 10) + (word.charAt(j++) -'0');
					}
					ans[num - 1] += repeat;
					process(i, prev, word, ans);
					j++;
					i = j;
				}
			} else {
				j++;
			}
		}
		if(i != j)
			process(i, j - 1, word, ans);
		return ans;
	}
	
	public static void process(int i, int j, String word, int[] ans) {
		while(i <= j) {
			if(word.charAt(j) == '#') {
				int num = (word.charAt(j - 2) - '0') * 10 + (word.charAt(j - 1) - '0');
				ans[num - 1]++;
				j = j - 3;
			} else {
				int num = word.charAt(j) - '0';
				ans[num - 1]++;
				j = j - 1;
			}
		}
	}

}
