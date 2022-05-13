package string;

public class StringMethods {

	public boolean isEmpty(String checkString) throws Exception {
		if (checkString == null) {
			throw new Exception("String is Null");
		}
		return checkString.length() == 0;
	}

	public void checker(String checkString) throws Exception {
		if (checkString == null || isEmpty(checkString)) {
			throw new Exception("String is Null/Empty");
		}
	}

	public String concat(String nowString, String newString) throws Exception {
		checker(nowString);
		checker(newString);
		nowString += newString;
		return nowString;
	}

	public boolean equals(String nowString, String checkString) throws Exception {
		checker(nowString);
		checker(checkString);
		int nowLength = nowString.length();
		if (nowLength != checkString.length()) {
			return false;
		}
		for (int i = 0; i < nowLength; i++) {
			if (nowString.charAt(i) != checkString.charAt(i)) {
				return false;
			}
		}
		return true;
	}

	public boolean equalsIgnoreCase(String nowString, String checkString) throws Exception {
		return equals(nowString.toLowerCase(), checkString.toLowerCase());
	}

	public boolean contains(String nowString, CharSequence checkString) throws Exception {
		checker(nowString);
		int k = 0;
		int nowLength = nowString.length();
		int checkLength = checkString.length();
		for (int i = 0; i < nowLength; i++) {
			if (nowString.charAt(i) == checkString.charAt(k)) {
				k++;
			} else {
				k = 0;
			}
			if (k == checkLength) {
				return true;
			}
		}
		return false;
	}

	public String replace(String nowString, char oldchar, char newChar) throws Exception {
		checker(nowString);
		StringBuilder changeString = new StringBuilder();
		int nowLength = nowString.length();
		for (int i = 0; i < nowLength; i++) {
			char character = nowString.charAt(i);
			if (character == oldchar) {
				changeString.append(newChar);
			} else {
				changeString.append(character);
			}
		}
		return changeString.toString();
	}

	public String substring(String nowString, int beginIndex, int endIndex) throws Exception {
		checker(nowString);
		StringBuilder newString = new StringBuilder();
		if (beginIndex < 0 || endIndex > nowString.length()) {
			throw new Exception("Index Out Of Bounds");
		}
		for (int i = beginIndex; i < endIndex; i++) {
			newString.append(nowString.charAt(i));
		}
		return newString.toString();
	}

	public String substring(String nowString, int beginIndex) throws Exception {
		return substring(nowString, beginIndex, nowString.length());
	}

	public int indexOf(String nowString, char character) throws Exception {
		return indexOf(nowString, character, 0);
	}

	public int indexOf(String nowString, char character, int fromIndex) throws Exception {
		checker(nowString);
		for (int i = fromIndex; i < nowString.length(); i++) {
			if (nowString.charAt(i) == character) {
				return i;
			}
		}
		return -1;
	}

//	public boolean rotate(String str1, String str2) throws Exception {
//		if (str1.length() != str2.length()) {
//			return false;
//		}
//		if (contains(str1 + str1, str2) && !equals(str1, str2)) {
//			return true;
//		}
//		return false;
//	}
}
