package test1;

import java.util.Objects;
//import java.util.Arrays;
import java.util.Scanner;

public class Anagram {

	public void checker(String saved) throws Exception {
		if (Objects.isNull(saved) || saved.isEmpty()) {
			throw new Exception("String is Empty/Null");
		}
	}

	public int isAnagram(String str1, String str2) throws Exception {
		checker(str1);
		checker(str2);
		if (str1.length() != str2.length()) {
			return 0;
		}
		//str1.toCharArray();
		//str2.toCharArray();
		char[] ch1 = toCharArray(str1);
		char[] ch2 = toCharArray(str2);
		int count = 0;

//		Arrays.sort(ch1);
//		Arrays.sort(ch2);

		ch1 = mergeSort(ch1);
		ch2 = mergeSort(ch2);

		for (int i = 0; i < ch1.length; i++) {
			if (ch1[i] != ch2[i]) {
				count++;
			}
		}
		return count;
	}

	public char[] mergeSort(char[] array) {
		if (array.length == 1) {
			return array;
		}

		int midValue = array.length / 2;
		// Arrays.copyOfRange(array, 0, midValue);
		// Arrays.copyOfRange(array, midValue, array.length)
		char left[] = mergeSort(copyOfRange(array, 0, midValue));
		char right[] = mergeSort(copyOfRange(array, midValue, array.length));

		return merge(left, right);
	}

	public char[] merge(char left[], char right[]) {
		char saved[] = new char[left.length + right.length];
		int i = 0, j = 0, k = 0;

		while (i < left.length && j < right.length) {
			if (left[i] < right[j]) {
				saved[k++] = left[i++];
			} else {
				saved[k++] = right[j++];
			}
		}

		while (i < left.length) {
			saved[k++] = left[i++];
		}

		while (j < right.length) {
			saved[k++] = right[j++];
		}

		return saved;
	}

	public char[] copyOfRange(char[] array, int fromIndex, int endIndex) {
		char[] saved = new char[endIndex - fromIndex];
		int k = 0;
		for (int i = fromIndex; i < endIndex; i++) {
			saved[k++] = array[i];
		}
		return saved;
	}

	public char[] toCharArray(String nowString) throws Exception {
		checker(nowString);
		int length = nowString.length();
		char[] newChar = new char[length];
		for (int i = 0; i < length; i++) {
			newChar[i] = nowString.charAt(i);
		}
		return newChar;
	}

	public static void main(String[] args) {

		Scanner input = new Scanner(System.in);

		Anagram anaCall = new Anagram();

		System.out.println("Enter the String1");
		String str1 = input.nextLine();
		System.out.println("Enter the String2");
		String str2 = input.nextLine();
		try {
			System.out.println(anaCall.isAnagram(str1, str2));
		} catch (Exception e) {
			System.out.println(e.getMessage());
			// e.printStackTrace();
		}
		input.close();
	}

}
