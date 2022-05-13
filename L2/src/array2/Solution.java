package array2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

import sorting.Sort;

public class Solution {

	public int minimumGetValue(int arr[], int m) {
		Arrays.sort(arr);
		int min = Integer.MAX_VALUE;
		return minimunGetValueSum(arr, 0, m - 1, min);
	}

	public int minimunGetValueSum(int arr[], int start, int end, int min) {
		min = Math.min((Math.abs(arr[end] - arr[start])), min);

		if (end == arr.length - 1) {
			return min;
		}
		return minimunGetValueSum(arr, start + 1, end + 1, min);
	}

	public String sumClosestValue(int arr[], int n, int x) {
		int min = Integer.MAX_VALUE;
		int temp = 0;
		String saved = "";
		for (int i = 0; i < n; i++) {
			for (int j = i + 1; j < n; j++) {
				temp = Math.abs(x - (arr[i] + arr[j]));
				if (temp < min) {
					min = Math.min(temp, min);
					saved = arr[i] + " " + arr[j];
				}
			}
		}

		return saved;
	}

	public int[] rotateOnePosition(int arr[], int n) {
		int temp = arr[n - 1];
		for (int i = n - 1; i > 0; i--) {
			arr[i] = arr[i - 1];
		}
		arr[0] = temp;
		return arr;
	}

	public List<String> mismatchPair(char arr1[], char arr2[]) {
		if (arr1.length != arr2.length) {
			return null;
		}

		List<String> ans = new ArrayList<>();
		String output = "";
		String saved = "";

		for (int i = 0; i < arr1.length - 1; i++) {
			while (arr1[i] != arr2[i] && arr1[i + 1] != arr2[i + 1]) {
				output = arr1[i] + "" + arr1[i + 1];
				saved = arr2[i] + "" + arr2[i + 1];
				ans.add(output);
				ans.add(saved);
				i++;
			}
			if (arr1[i] != arr2[i]) {
				output = arr1[i] + "";
				saved = arr2[i] + "";
				ans.add(output);
				ans.add(saved);
			}
		}
		return ans;
	}

	public List<String> sumIsEqualNumber(int array[], int n, int sum) {
		Map<Integer, Integer> ans = new HashMap<>();
		String saved = "";
		List<String> output = new ArrayList<>();

		for (int i = 0; i < n; i++) {
			int temp = sum - array[i];
			if (ans.containsKey(temp)) {
				saved = "(" + array[i] + "," + temp + ")";
				output.add(saved);
			}
			if (ans.containsKey(array[i])) {
				ans.put(array[i], ans.get(array[i]) + 1);
			} else {
				ans.put(array[i], 1);
			}
		}

		return output;
	}

	public int[] rotateArrayPosition(int array[], int n) {
		int temp = 0;
		int loop = 1;
		while (loop > 0) {
			for (int i = 0; i < n - 1; i++) {
				temp = array[i];
				array[i] = array[i + 1];
				array[i + 1] = temp;
			}
			loop--;
		}
		return array;
	}

	public void unionExceptIntersect(List<Integer> array1, List<Integer> array2) {
		List<Integer> union = new ArrayList<>();
		List<Integer> except = new ArrayList<>();
		List<Integer> intersect = new ArrayList<>();

		for (int i = 0; i < array1.size(); i++) {
			Integer dummy = (Integer) array1.get(i);

			if (!union.contains(dummy)) {
				union.add(dummy);
			}

			if (dummy % 2 == 0) {
				except.add(dummy);
			}

			if (array2.contains(dummy) && !intersect.contains(dummy)) {
				intersect.add(dummy);
			}
		}

		for (int i = 0; i < array2.size(); i++) {
			Integer dummy = (Integer) array2.get(i);

			if (!union.contains(dummy)) {
				union.add(dummy);
			}

			if (dummy % 2 == 1) {
				except.add(dummy);
			}

			if (array1.contains(dummy) && !intersect.contains(dummy)) {
				intersect.add(dummy);
			}
		}

		System.out.println(union);
		System.out.println(except);
		System.out.println(intersect);
	}

	public Map<Integer, Integer> duplicateCount(int array[], int n) {
		Map<Integer, Integer> ans = new HashMap<>();

		for (int i = 0; i < n; i++) {
			if (ans.containsKey(array[i])) {
				ans.put(array[i], ans.get(array[i]) + 1);
			} else {
				ans.put(array[i], 1);
			}
		}
		return ans;
	}

	public int longestSubSequence(int arr[], int n) {
		List<Integer> ans = new ArrayList<>();

		for (int i = 0; i < n - 1; i++) {
			if (arr[i] < arr[i + 1]) {
				ans.add(arr[i]);
			}
		}
		if (arr[n - 1] > arr[n - 2]) {
			ans.add(arr[n - 1]);
		}
		return ans.size();
	}

	public boolean nonDecreasingArray(int arr[], int n) {
		int count = 0;
		for (int i = 0; i < n - 1; i++) {
			if (arr[i] > arr[i + 1]) {
				count++;
			}
		}
		if (1 >= count) {
			return true;
		}
		return false;
	}

	public boolean multiSetSum(int arr[], int n) {
		arr = Sort.mergeSort(arr);
		return sumDigitArray(arr, 0, 1, n);
	}

	public boolean sumDigitArray(int arr[], int start, int end, int n) {
		int ans1 = 0;
		int ans2 = 0;

		for (int i = 0; i < end; i++) {
			ans1 += arr[i];
		}
		for (int i = end; i < n; i++) {
			ans2 += arr[i];
		}
		if (ans1 == ans2) {
			return true;
		}
		if (end == n - 1) {
			return false;
		}
		return sumDigitArray(arr, start, end + 1, n);
	}

	public int multiplyMaxValue(int arr[], int n) {
		int max = Integer.MIN_VALUE;

		for (int i = 0; i < n; i++) {
			for (int j = i + 1; j < n; j++) {
				for (int k = j + 1; k < n; k++) {
					max = Math.max(max, Math.abs((arr[i]) * arr[j] * arr[k]));
				}
			}
		}
		return max;
	}

	public int sumOfDigits(int number) {
		int sum = 0, digit = 0;

		while (number > 0) {
			digit = number % 10;
			sum += digit;
			number /= 10;
		}
		return sum;
	}

	public String getPerfectNumber(int number) {
		int saved = 0;

		saved = sumOfDigits(number);

		saved = 10 - saved;

		return number + "" + saved;
	}

	public int[] rotateArraySizePosition(int array[], int n, int rotate) {
		int temp = 0;

		while (rotate > 0) {
			for (int i = 0; i < n - 1; i++) {
				temp = array[i];
				array[i] = array[i + 1];
				array[i + 1] = temp;
			}
			rotate--;
		}
		return array;
	}

	public int[] ascendingOrder(int arr[], int n) {

		TreeMap<Integer, List<Integer>> ans = new TreeMap<>();
		int dummy = 0;
		List<Integer> output = null;
		for (int i = 0; i < n; i++) {
			dummy = sumOfDigits(arr[i]);
			if (ans.get(dummy) == null) {
				output = new ArrayList<>();
				output.add(arr[i]);
			} else {
				output = ans.get(dummy);
				output.add(arr[i]);
			}
			ans.put(dummy, output);
		}
		int k = 0;
		int temp[] = new int[n];
		for (int saved : ans.keySet()) {
			List<Integer> list = ans.get(saved);
			for (int i = 0; i < list.size(); i++) {
				temp[k++] = list.get(i);
			}
		}
		return temp;
//		int dummy = 0;
//		int min = Integer.MAX_VALUE;
//		int j = 0;

//		for (int i = 0; i < n; i++) {
//			dummy = sumOfDigits(arr[i]);
//			if (dummy < min) {
//				min = Math.min(min, dummy);
//				arr[j] = arr[i];
//			}
//		
	}

	public String closestNumberPair(int arr[], int n) {
		int min = Integer.MAX_VALUE;
		int dummy = 0;
		String saved = "";

		for (int i = 0; i < n; i++) {
			for (int j = i + 1; j < n; j++) {
				dummy = Math.abs(arr[i] - arr[j]);
				if (min > dummy) {
					min = Math.min(dummy, min);
					saved = arr[j] + "," + arr[i];
				}
			}
		}
		return saved;
	}

	public void patternOutput(int arr[], int n) {
		for (int i = 0; i < n; i++) {
			for (int j = 0; j <= i; j++) {
				if (j == 0) {
					System.out.print(arr[i] + " ");
				} else if (j == 1) {
					System.out.print(arr[i + 4] + " ");
				} else if (j == 2) {
					System.out.print(arr[i + 7] + " ");
				} else if (j == 3) {
					System.out.print(arr[i + 9] + " ");
				} else {
					System.out.print(arr[i + 10] + " ");
				}
			}
			System.out.println();
		}
	}

	public int[][] maximumNumberOne(int arr[][], int n, int m) {
		int count = 0;
		int index = 0;
		int max = Integer.MIN_VALUE;

		for (int i = 0; i < n; i++) {
			int row[] = arr[i];
			for (int j = 0; j < m; j++) {
				if (row[j] == 1) {
					count++;
				}
					if (max < count) {
						max = Math.max(max, count);
						index = i;
					}
			}
			count = 0;
		}
		for (int j = 0; j < m; j++) {
			arr[index][j] = 0;
		}
		return arr;
	}

	public void sorting(int arr[][]) {

		for (int i = 0; i < arr[0].length; i++) {
			int row[] = arr[i];
			Arrays.sort(row);
			arr[i] = row;
		}
		System.out.println(Arrays.deepToString(arr));
	}

	public void setZeroes(int[][] matrix) {

		Set<Integer> row = new HashSet<>();
		Set<Integer> col = new HashSet<>();

		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[0].length; j++) {
				if (matrix[i][j] == 0) {
					row.add(i);
					col.add(j);
				}
			}
		}

		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[0].length; j++) {
				if (row.contains(i) || col.contains(j)) {
					matrix[i][j] = 0;
				}
			}
		}

		System.out.println(Arrays.deepToString(matrix));
	}

	int tour(int petrol[], int distance[]) {
		int start = 0;
		int reqdFuel = 0;
		int availFuel = 0;

		for (int i = 0; i < petrol.length; i++) {
			availFuel += petrol[i] - distance[i];
			if (availFuel < 0) {
				reqdFuel += availFuel;
				availFuel = 0;
				start = i + 1;
			}
		}
		if (reqdFuel + availFuel >= 0) {
			return start;
		}
		return -1;
	}

}