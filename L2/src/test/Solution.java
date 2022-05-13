package test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Stack;

public class Solution {

	public boolean isSubSequence(String A, String B) {

		int alen = A.length();
		int blen = B.length();
		int i = 0;

		for (int j = 0; i < alen && j < blen; j++) {
			if (A.charAt(i) == B.charAt(j)) {
				i++;
			}

		}
		// System.out.println(i);
		if (i >= alen) {
			return true;
		}
		return false;
	}

	public String removeChars(String string1, String string2) {

		// String saved = "";
		int length1 = string1.length();
		int length2 = string2.length();
		int i = 0;

		for (int j = 0; i < length2 && j < length1; j++) {
			if (string1.charAt(j) == string2.charAt(i)) {
				string1.replace(string1.charAt(j), ' ');
				i++;
			}
		}
		return string1;
	}

	public boolean isValid(String s) {

		String ipv4[] = s.split("\\.");

		int length = ipv4.length;

		boolean ans[] = new boolean[4];

		if (length < 4 || length > 4 || s.charAt(s.length() - 1) == '.') {
			return false;
		}

		for (int i = 0; i < length; i++) {
			if (ipv4[i] == "" || ipv4[i].length() > 1 && ipv4[i].charAt(0) == '0') {
				ans[i] = false;
			} else if (Integer.parseInt(ipv4[i]) <= 255 && Integer.parseInt(ipv4[i]) >= 0 && ipv4[i].length() <= 3) {
				ans[i] = true;

			}

		}
		for (boolean bool : ans) {
			if (!bool) {
				return false;
			}
		}
		return true;
	}

	String modify(String s) {
		String saved = "";
		// StringBuilder ans = new StringBuilder();
		int j = 0;

		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) == 'a' || s.charAt(i) == 'e' || s.charAt(i) == 'i' || s.charAt(i) == 'o'
					|| s.charAt(i) == 'u') {
				saved = s.charAt(i) + saved;
			}
		}

		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) == 'a' || s.charAt(i) == 'e' || s.charAt(i) == 'i' || s.charAt(i) == 'o'
					|| s.charAt(i) == 'u') {
				s = s.replace(s.charAt(i), saved.charAt(j));
				j++;
			}
		}
		return s;
	}

	public int maxChars(String s) {
		int noRep = 0;
		for (int i = 0; i < s.length(); i++) {
			noRep = Math.max(noRep, s.lastIndexOf(s.charAt(i)) - i);
		}
		return noRep - 1;
	}

	static String crossPattern(String S) {

		StringBuilder out = new StringBuilder();

		int len = S.length();
		int count = 0;

		for (int i = 0; i < len; i++) {
			out.append(S);
		}

		for (int i = 0; i < len; i++) {
			for (int j = i * len; j < (i * len) + len; j++) {
				if ((j == i * len + count || j == (i * len) + len - 1 - count) == false) {
					out.setCharAt(j, ' ');
				}
			}
			count++;
		}
		return out.toString();
	}

	public List<String> find_permutation(String S) {

		List<String> permu = new ArrayList<String>();

		permute(S, "", permu);
		Collections.sort(permu);
		return permu;
	}

	private void permute(String S, String out, List<String> permu) {
		if (S.length() == 0) {
			permu.add(out);
			return;
		}

		for (int i = 0; i < S.length(); i++) {
			char ch = S.charAt(i);
			String ans = S.substring(0, i) + S.substring(i + 1);
			permute(ans, out + ch, permu);
		}
	}

	static int x[] = { -1, -1, -1, 0, 0, 1, 1, 1 };
	static int y[] = { -1, 0, 1, -1, 1, -1, 0, 1 };

	public int[][] searchWord(char[][] grid, String word) {
		List<List<Integer>> output = new ArrayList<>();

		for (int row = 0; row < grid.length; row++) {
			for (int col = 0; col < grid[0].length; col++) {
				if (search(grid, row, col, word)) {
					List<Integer> list = new ArrayList<>();
					list.add(row);
					list.add(col);
					output.add(list);
				}
			}
		}

		int[][] ans = new int[output.size()][2];

		for (int i = 0; i < ans.length; i++) {
			ans[i][0] = output.get(i).get(0);
			ans[i][1] = output.get(i).get(1);
		}
		return ans;
	}

	private static boolean search(char[][] grid, int row, int col, String word) {
		if (grid[row][col] != word.charAt(0)) {
			return false;
		}
		for (int i = 0; i < 8; i++) {
			int k;
			int rowd = row + x[i];
			int cold = col + y[i];

			int wordlen = word.length();

			for (k = 1; k < wordlen; k++) {
				if (rowd >= grid.length || rowd < 0 || cold >= grid[0].length || cold < 0) {
					break;
				}

				if (grid[rowd][cold] != word.charAt(k)) {
					break;
				}

				rowd += x[i];
				cold += y[i];
			}
			if (k == wordlen) {
				return true;
			}
		}
		return false;
	}

	public boolean isValid1(String s) {

		Stack<Character> stk = new Stack<>();

		for (int i = 0; i < s.length(); i++) {
			char ch = s.charAt(i);

			switch (ch) {
			case '[':
				stk.push(']');
				break;

			case '(':
				stk.push(')');
				break;

			case '{':
				stk.push('}');
				break;
			default:
				if (stk.isEmpty() || stk.pop() != ch) {
					return false;
				}
			}
		}
		return stk.isEmpty();
	}

	public static boolean areIsomorphic(String str1, String str2) {
		if (str1.length() != str2.length()) {
			return false;
		}

		Map<Character, Character> mapCall = new HashMap<>();

		for (int i = 0; i < str2.length(); i++) {
			char ch1 = str1.charAt(i);
			char ch2 = str2.charAt(i);
			if (mapCall.containsKey(ch1)) {
				if (mapCall.get(ch1) != ch2) {
					return false;
				}
			} else {
				if (mapCall.containsValue(ch2)) {
					return false;
				}
				mapCall.put(ch1, ch2);
			}
		}
		return true;
	}

	static String encryptString(String S) {

		StringBuilder sb = new StringBuilder();
		int count = 1;
		int i = S.length() - 1;

		while (i >= 0) {
			if (0 <= i - 1 && S.charAt(i) == S.charAt(i - 1)) {
				count++;
			} else {
				sb.append(Integer.toHexString(count)).append(S.charAt(i));
			}
			i--;
		}
		return sb.toString();
	}

	public String countAndSay(int n) {

		if (n == 1) {
			return "1";
		}

		StringBuilder ans = new StringBuilder();

		String str = countAndSay(n - 1);

		int count = 0;

		for (int i = 0; i < str.length(); i++) {
			count++;
			if (i == str.length() - 1 || str.charAt(i) != str.charAt(i + 1)) {
				ans.append(count).append(str.charAt(i));
				count = 0;
			}
		}
		return ans.toString();
	}

	public List<String> compareString(String str1, String str2) {

		char saved = 0;
		char dummy = 0;
		List<String> list = new ArrayList<>();
		String out = "";
		for (int i = 0; i < str1.length(); i++) {
			if (str1.charAt(i) != str2.charAt(i)) {
				saved = str1.charAt(i);
				dummy = str2.charAt(i);
				out = saved + "" + dummy;
				list.add(out);
			}

		}

		return list;
	}

	public String removePalindrome(String str) {
		String reverse = "";
		String saved = "";
		String output = "";

		for (int i = 0; i < str.length(); i++) {
			if (str.charAt(i) != ' ') {
				saved += str.charAt(i);
				reverse = str.charAt(i) + reverse;
			} else {
				if (!saved.equals(reverse)) {
					output += saved;
				}
				saved = "";
				reverse = "";
			}
		}
		return output;
	}

	public List<String> findPermutation(int[] arr) {

		List<String> permu = new ArrayList<String>();
		// Arrays.sort(arr);
		String s = "";
		for (int i : arr) {
			s += i + "";
		}
		permute1(s, "", permu);
		Collections.sort(permu);
		// System.out.print(permu);
		return permu;
	}

	private void permute1(String s, String out, List<String> permu) {
		if (out != "" || s.length() == 0) {
			permu.add(out);
		}
		for (int i = 0; i < s.length(); i++) {
			char ch = s.charAt(i);
			String ans = s.substring(0, i) + s.substring(i + 1);
			permute1(ans, out + ch, permu);
		}
	}

	public String firstCharacter(String str) {
		String saved = "";
		for (int i = 0; i < str.length(); i++) {
			char ch = str.charAt(i);
			if (str.lastIndexOf(ch) == str.indexOf(ch)) {
				saved += ch;
			}
		}
		if (saved.isEmpty()) {
			return "no matching character";
		}
		return saved.charAt(0) + "";
	}

	public boolean rotationString(String str1, String str2) {
		if (str1.length() != str2.length()) {
			return false;
		}
		if ((str1.substring(2) + str1.substring(0, 2)).equals(str2)
				|| (str1.substring(str1.length() - 2) + str1.substring(0, str1.length() - 2)).equals(str2)) {
			return true;
		}
		return false;
	}

	public String temp(String inp) throws Exception {
		return subStrings(0, inp.length() - 3, inp);
	}

	public String subStrings(int end, String inp) throws Exception {
		return subStrings(0, end, inp);
	}

	public String subStrings(int start, int end, String inp) throws Exception {
		String output = "";
		if (start > end || start > inp.length() || end > inp.length()) {
			throw new Exception("hi gokul");
		}
		for (int i = start; i < end; i++) {
			output += inp.charAt(i);
		}
		return output;
	}

	int longestUniqueSubsttr(String s) {

		List<Character> list = new ArrayList<>();
		int i = 0, max = 0;

		while (i < s.length()) {
			if (list.contains(s.charAt(i))) {
				list.remove(0);
			} else {
				list.add(s.charAt(i));
				max = Math.max(max, list.size());
				i++;
			}
		}
		return max;
	}

	public String commonFragment(String str1, String str2, String str3) {
		String saved = "";
		String output = "";
		for (int i = 0; i < str1.length(); i++) {

			if (str1.charAt(i) != ' ') {
				saved += str1.charAt(i);
			} else {
				if (str2.contains(saved) && str3.contains(saved)) {
					output += saved + " ";
				}
				saved = "";
			}

		}

		return output;
	}

	public boolean contains(String s1, String s2) {
		int k = 0;
		for (int i = 0; i < s1.length(); i++) {
			if (s1.charAt(i) == s2.charAt(k)) {
				k++;
			} else {
				k = 0;
			}
			if (k == s2.length()) {
				return true;
			}
		}
		return false;
	}

	public String convertEnglish(int number) {

		int length = Integer.toString(number).length();

		if (length == 0) {
			return "The number is empty";
		}

		if (length > 4) {
			return "The given number has more than 4 digits";
		}

		String output = "";
		String num = Integer.toString(number);
		StringBuilder ob = new StringBuilder(num);
		String t = ob.reverse().toString();
		int z = 0;
		int k = 0;
		String ans = "";

		String onePos[] = { "Zero", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine" };

		String twoPos[] = { "Ten", "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen",
				"Eighteen", "Nineteen" };

		String threePos[] = { "", "", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety" };

		String lastPos[] = { "Hundred", "Thousand" };

		String hunPos[] = { "", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine" };

		for (int i = 0; i < t.length(); i++) {
			if (i == 0) {
				k = Integer.parseInt(t.charAt(i) + "");
				z = k;
				output += onePos[k];
				ans = output;
			}

			if (i == 1) {
				if (t.charAt(i) == '1') {
					output = twoPos[z];
				} else {
					k = Integer.parseInt(t.charAt(i) + "");
					if (k != 0) {
						output = threePos[k] + ans;
						ans = output;
					} else {
						output = "And" + ans;
					}

				}
			}

			if (i == 2) {
				k = Integer.parseInt(t.charAt(i) + "");
				if (k != 0) {
					output = hunPos[k] + lastPos[0] + "And" + ans;
				}
				ans = output;
			}

			if (i == 3) {
				k = Integer.parseInt(t.charAt(i) + "");
				if (k != 0) {
					output = hunPos[k] + lastPos[1] + ans;
				}

			}
		}

		return output;
	}

	public boolean magicalString(String str1, String str2) {
		if (str1.length() != str2.length()) {
			return false;
		}

		Map<Character, Character> ans = new HashMap<>();
		char ch1 = 'z';
		for (char ch = 'a'; ch <= 'z'; ch++) {
			ans.put(ch, ch1);
			ch1--;
		}

		for (int i = 0; i < str1.length(); i++) {
			if (ans.get(str1.charAt(i)) != str2.charAt(i)) {
				return false;
			}
		}

		return true;
	}

	public List<String> phoneDigit(String number) {
		List<String> list = new ArrayList<>();
		mapping(number, "", list);
		return list;
	}

	public void mapping(String str, String output, List<String> list) {

		String[] words = { "", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz" };

		if (str.length() == 0) {
			list.add(output);
			return;
		}

		int digit = str.charAt(0) - '0';

		for (int i = 0; i < words[digit].length(); i++) {
			char ch = words[digit].charAt(i);
			String ans = str.substring(1);
			mapping(ans, output + ch, list);
		}
	}

	public static void main(String[] args) {

		Solution solCall = new Solution();

		Scanner scan = new Scanner(System.in);

		int number = scan.nextInt();

		switch (number) {
		case 1:
			boolean check = solCall.isSubSequence("gksrek", "geeksforgeeks");
			System.out.println(check);
			break;

		case 2:
			String ans = solCall.removeChars("occurrance", "car");
			System.out.println(ans);
			break;

		case 3:
			boolean check1 = solCall.isValid("0.0.0.0.");
			System.out.println(check1);
			break;

		case 4:
			String output = solCall.modify("practice");
			System.out.println(output);
			break;

		case 5:
			int out = solCall.maxChars("for");
			System.out.println(out);
			break;

		case 6:
			String str = Solution.crossPattern("hqghumeaylnlfdxfircvscxggbwkfnqduxwfnfozvs");
			System.out.println(str);
			break;

		case 7:
			List<String> output1 = solCall.find_permutation("abc");
			System.out.println(output1);
			break;

		case 8:
			char grid[][] = { { 'a', 'b', 'c' }, { 'd', 'r', 'f' }, { 'g', 'h', 'i' } };
			int ans1[][] = solCall.searchWord(grid, "abc");
			System.out.println(ans1);
			break;

		case 9:
			boolean out1 = solCall.isValid1("(){}}{");
			System.out.println(out1);
			break;

		case 10:
			boolean out2 = Solution.areIsomorphic("aabc", "xxyy");
			System.out.println(out2);
			break;

		case 11:
			String str1 = Solution.encryptString("abbc");
			System.out.println(str1);
			break;

		case 12:
			String str2 = solCall.countAndSay(4);
			System.out.println(str2);
			break;

		case 13:
			System.out.println(solCall.compareString("abcddefgilom", "abdcdeffgklm"));
			break;

		case 14:
			System.out.println(solCall.removePalindrome("He did a good deed"));
			break;

		case 15:
			int ch[] = { 1, 2, 3, 4 };
			System.out.println(solCall.findPermutation(ch));
			break;

		case 16:
			System.out.println(solCall.firstCharacter("abcabc"));
			break;

		case 17:
			System.out.println(solCall.rotationString("Hello from here", "erHello from he"));
			break;

		case 18:
			System.out.println(solCall.longestUniqueSubsttr("geeksforgeeks"));
			break;

		case 19:
			System.out.println(solCall.commonFragment("Every morning I want to do exercise regularly",
					"Every morning I want to do meditation without fail",
					"It is important that I want to be happy always"));
			break;

		case 20:
			System.out.println(solCall.convertEnglish(9923));
			break;

		case 21:
			System.out.println(solCall.magicalString("bda", "ywz"));
			break;

		case 22:
			// System.out.println(solCall.phoneDigit("23"));
			try {
				System.out.println(solCall.temp("gokul"));
			} catch (Exception e) {
				e.printStackTrace();
			}
			break;

		case 23: {
			String str23 = "dharma";
			String str24 = "ra";
			System.out.println(solCall.contains(str23, str24));
			break;
		}
		}
		scan.close();
	}

}
