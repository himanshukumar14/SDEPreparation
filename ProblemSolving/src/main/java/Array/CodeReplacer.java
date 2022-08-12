package Array;

import java.util.ArrayList;
import java.util.List;

public class CodeReplacer {

	public static void main(String[] args) {
		List<String[]> x = new ArrayList<>();
		x.add(new String[] { "0", "foo", "String" });
		x.add(new String[] { "4", "num", "bar" });
		System.out.println(replaceText("foo num", x));
	}

	public static String replaceText(String text, List<String[]> replacements) {
		StringBuilder sb = new StringBuilder();
		int len = text.length();
		int previndex = -1;
		int prevbeforelen = -1;
		
		if(replacements.size() == 0)
			return text;

		for (int i = 0; i < replacements.size(); ++i) {
			int index = Integer.valueOf(replacements.get(i)[0]);
			String before = replacements.get(i)[1];
			String after = replacements.get(i)[2];

			if (index < 0 || index >= len)
				return "";
			for (int j = 0; j < before.length(); ++j) {
				if (before.charAt(j) != text.charAt(index + j))
					return "";
			}
			int start = 0;
			if (previndex != -1)
				start = previndex + prevbeforelen;

			sb.append(text.substring(start, index));
			sb.append(after);
			previndex = index;
			prevbeforelen = before.length();
		}
		sb.append(text.substring(previndex + prevbeforelen, len));
		return sb.toString();
	}
}
