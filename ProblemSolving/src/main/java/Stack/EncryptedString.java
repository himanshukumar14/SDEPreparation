package Stack;

import java.util.Stack;

public class EncryptedString {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public static String solve(String A, int B) {
		Stack<String[]> store = new Stack<>();
		int len = 0;
		int n = A.length();

		int i = 0;
		while (i < n) {
			char ch = A.charAt(i);
			if (Character.isAlphabetic(ch)) {
				store.push(new String[] { String.valueOf(A.charAt(i)), String.valueOf(++len) });
				i++;
			} else {
				StringBuilder sb = new StringBuilder();
				while (i < n && Character.isDigit(ch)) {
					sb.append(ch);
					i++;
				}
				len = len * Integer.valueOf(sb.toString());
			}
		}

		String[] temp = store.pop();
		int l = Integer.valueOf(temp[1]);
		String c = temp[0];
		int k = B;

		while (k % l != 0) {
			k = k % l;
			temp = store.pop();
			l = Integer.valueOf(temp[1]);
			c = temp[0];
		}
		return c;

	}

}
