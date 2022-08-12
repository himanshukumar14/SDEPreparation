package Backtracking;

import java.util.ArrayList;
import java.util.List;

public class GenerateValidIP {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s = "25525511135";
		int n = s.length();
		if (n > 12)
			System.out.println("empty");
		List<String> ans = solve(s, 0, n - 1, 0);
		for (String x : ans) {
			System.out.println(x);
		}
	}

	public static List<String> solve(String s, int l, int r, int level) {
		List<String> res = new ArrayList<>();
		if (l > r)
			return res;
		if (level == 3 && isValid(s.substring(l, r + 1)))
			res.add(s.substring(l, r + 1));

		for (int k = l; k < l + 3 && k < r; ++k) {
			if (isValid(s.substring(l, k + 1))) {
				List<String> temp = solve(s, k + 1, r, level + 1);
				if (temp.size() != 0) {
					for (int j = 0; j < temp.size(); j++) {
						res.add(s.substring(l, k + 1) + "." + temp.get(j));
					}
				}
			}
		}
		return res;
	}

	public static boolean isValid(String s) {
		if (s.equals("0"))
			return true;
		if (s.charAt(0) == '0' || Long.valueOf(s) > 255)
			return false;
		return true;
	}

	// -----------------------------------------------------------------------------------------------

	public List<String> restoreIpAddresses(String s) {
		List<String> res = new ArrayList<String>();
		int len = s.length();
		if (len > 12)
			return res;
		for (int i = 1; i < 4 && i < len - 2; i++) {
			for (int j = i + 1; j < i + 4 && j < len - 1; j++) {
				for (int k = j + 1; k < j + 4 && k < len; k++) {
					String s1 = s.substring(0, i), s2 = s.substring(i, j), s3 = s.substring(j, k),
							s4 = s.substring(k, len);
					if (isValid2(s1) && isValid2(s2) && isValid2(s3) && isValid2(s4)) {
						res.add(s1 + "." + s2 + "." + s3 + "." + s4);
					}
				}
			}
		}
		return res;
	}

	public boolean isValid2(String s) {
		if (s.length() > 3 || s.length() == 0 || (s.charAt(0) == '0' && s.length() > 1) || Integer.parseInt(s) > 255)
			return false;
		return true;
	}
}
