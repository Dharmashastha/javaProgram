package pattern;

import java.util.Arrays;
import java.util.Scanner;

import sorting.Sort;


public class PatternOutput {

	public static void main(String[] args) {
		
		Scanner input = new Scanner(System.in);
		Solution solCall = new Solution();
		
		int number = input.nextInt();
		
		switch(number)
		{
		
		case 1:
		{
			solCall.pyramidPattern(5);
			break;
		}
		
		case 2:
		{
			solCall.rightTrianglePattern(5);
			break;
		}
		
		case 3:
		{
			solCall.leftTrianglePattern(5);
			break;
		}
		
		case 4:
		{
			solCall.diamondShapePattern(5);
			break;
		}
		
		case 5:
		{
			solCall.rightPascalTriangle(5);
			break;
		}
		
		case 6:
		{
			solCall.sandglassPattern(5);
			break;
		}
		
		case 7:
		{
			solCall.trianglePattern(5);
			break;
		}
		
		case 8:
		{
			solCall.diamondPattern(5);
			break;
		}
		
		case 9:
		{
			solCall.simpleNumberPattern(5);
			break;
		}
		
		case 10:
		{
			solCall.PascalTriangleProgram(5);
			break;
		}
		
		case 11:
		{
			solCall.diamondPatternProblem(4);
			break;
		}
		
		case 12:
		{
			solCall.zPattern(5);
			break;
		}
		
		case 13:
		{
			solCall.spiralPattern(4);
			break;
		}
		
		case 14:
		{
			solCall.spiralPatternWithModification(5);
			break;
		}
		
		case 15:
		{
			char arr[] = {'P','R','O','G','R','A','M'};
			//char arr[] = {'O','D','D'};
			solCall.characterPattern(arr);
			break;
		}
		
		case 16:
		{
			solCall.alternatingRectangle(3);
			break;
		}
		
		case 17:
		{
			System.out.println(solCall.countAndSay(4));
			break;
		}
		
		case 18:
		{
			int arr[] = {3,2,4,1};
			//Sort.bitonicGenerator(arr, 8);
			System.out.println(Sort.candyStore(arr, 4, 2));
			break;
		}
		
		}
input.close();
}
}	