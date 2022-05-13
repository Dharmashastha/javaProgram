package test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution {

	public List<String> sumEqual(int array[], int n, int sum) {
		Map<Integer, Integer> output = new HashMap<>();
		List<String> dummy = new ArrayList<>();
		String temp = "";
		int count = 0;

		for (int i = 0; i < n; i++) {
			int answer = sum - array[i];
			if (output.containsKey(answer)) {
				temp = "(" + answer + " ," + array[i] + ")";
				dummy.add(temp);
				count += output.get(answer);
			}
			if (output.containsKey(array[i])) {
				output.put(array[i], output.get(array[i]) + 1);
			} else {
				output.put(array[i], 1);
			}
		}
		System.out.println(count);
		return dummy;
	}

	public boolean isvaild(String value) throws Exception {
		if (value == null || value.isEmpty()) {
			throw new Exception("String can't be null or Empty");
		}
		List<Character> dummy = new ArrayList<>();
		// Stack<Character> saved = new Stack<>();
		int length = value.length();
		
		
		for (int i = 0; i < length; i++) {
			char temp = value.charAt(i);

			switch (temp) {
			case '(': {
				dummy.add(')');
				break;
			}
			case '{': {
				dummy.add('}');
				break;
			}
			case '[': {
				dummy.add(']');
				break;
			}
			default: {
				int size = dummy.size();
				if (dummy.isEmpty() || dummy.remove(size - 1) != temp) {
					return false;
				}
			}
			}
		}
		return dummy.isEmpty();
	}

	public List<Integer> merge(int array1[], int array2[], int n, int m) {
		int i = n - 1;
		int j = 0;
		int temp = 0;
		List<Integer> ans = new ArrayList<>();

		while (i >= 0 && j < m) {
			if (array1[i] > array2[j]) {
				temp = array1[i];
				array1[i] = array2[j];
				array2[j] = temp;
			}
			i--;
			j++;
		}
		Arrays.sort(array1);
		Arrays.sort(array2);

		for (int k = 0; k < array1.length; k++) {
			ans.add(array1[k]);
		}
		int z = array2.length - 1;
		for (int k = 0; k < 2 * array2.length; k++) {
			if (k % 2 == 1) {
				ans.add(k, array2[z--]);
			}
		}
		return ans;
	}
}
