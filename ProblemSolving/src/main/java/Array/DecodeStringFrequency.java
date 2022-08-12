package Array;

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
