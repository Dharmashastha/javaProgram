package test1;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class SumEqualNumber {

	public int sumEqualNumber(int array[], int n, int sum) {
		Map<Integer, Integer> output = new HashMap<>();
		int count = 0;

		for (int i = 0; i < n; i++) {
			int saved = sum - array[i];
			if (output.containsKey(saved)) {
				count += output.get(saved);
			}

			if (output.containsKey(array[i])) {
				output.put(array[i], output.get(array[i]) + 1);
			} else {
				output.put(array[i], 1);
			}
		}
		return count;
	}

	public static void main(String[] args) {

		SumEqualNumber sumCall = new SumEqualNumber();
		Scanner input = new Scanner(System.in);

		System.out.println("Enter the array length");
		int length = Integer.parseInt(input.nextLine());
		int array[] = new int[length];
		System.out.println("Enter the array Elements");
		for (int i = 0; i < length; i++) {
			array[i] = Integer.parseInt(input.nextLine());
		}
		System.out.println("Enter the Sum Value");
		int sum = Integer.parseInt(input.nextLine());

		System.out.println(sumCall.sumEqualNumber(array, length, sum));
		input.close();
	}

}
