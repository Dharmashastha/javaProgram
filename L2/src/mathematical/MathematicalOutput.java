package mathematical;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;


public class MathematicalOutput {

	public static void main(String[] args) 
	{
Solution solCall = new Solution();
		
		Scanner inputCall = new Scanner(System.in);
		
		int number = inputCall.nextInt();
		
		switch (number) 
		{
		
		case 1:
		{
			System.out.println(solCall.palindrome(155));
			break;
		}
			
//		case 2:
//		{	
//			int arr[]= {1,2,3,4,5};
//			System.out.println(solCall.sumClosestValue(arr, 5, 10));
//			break;	
//		}
//		case 3:
//		{
//			int arr[] = {1,2,3,4,5};
//			int out[] = solCall.rotateOnePosition(arr, 5);
//			for(int saved:out)
//			{
//				System.out.print(saved+" ");
//			}
//			
//			break;
//		}	
//		case 4:
//		{	
//			char arr1[] = {'a','b','c','d','e','f','g','h','i'};
//			char arr2[] = {'a','b','d','e','e','g','g','i','i'};
//			System.out.println(solCall.mismatchPair(arr1, arr2));
//			break;
//		}	
//		case 5:
//		{	
//			int arr[] = {10, 9, 5, 9, 0, 10, 2, 10, 1, 9};
//			System.out.println(solCall.sumIsEqualNumber(arr, 10, 12));
//			break;
//		}	
//		case 6:
//		{
//			int arr[] = {1,2,3,4,5};
//			int[] output = solCall.rotateArrayPosition(arr, 5);
//			for(int saved:output)
//			{
//				System.out.print(saved+" ");
//			}
//			break;
//		}	
//		case 7:
//		{
//			List<Integer> array1 = new ArrayList<>(Arrays.asList(1,2,5,3,8,9));
//			List<Integer> array2 = new ArrayList<>(Arrays.asList(1,7,5,8,8));
//			solCall.unionExceptIntersect(array1, array2);
//			break;
//		}	
//		case 8:
//		{
//			int arr[] = {2,3,6,2,2,1,6};
//			System.out.println(solCall.duplicateCount(arr, 7));
//			break;
//		}	
//		case 9:
//		{
//			int arr[] = {1,5,2,3,4};
//			System.out.println(solCall.longestSubSequence(arr, 5));
//			break;
//		}	
//		case 10:
//		{
//			int arr[] = {10,5,1};
//			System.out.println(solCall.nonDecreasingArray(arr, 3));
//			break;
//		}	
//		case 11:
//		{
//			int arr[] = {15,5,20,10,35,15,10};
//			System.out.println(solCall.multiSetSum(arr, 7));
//			break;
//		}	
//		case 12:
//		{
//			int arr[] = {-10,-10,5,2};
//			System.out.println(solCall.multiplyMaxValue(arr, 4));
//			break;
//		}
		}
	inputCall.close();
	}

}
