package test;

import java.util.Scanner;

public class Controller {

	public static void main(String[] args) {
		
		Scanner input = new Scanner(System.in);
		Solution solCall = new Solution();
		boolean flag = false;
		
		while(!flag)
		{
			System.out.println("Enter Your Choice");
			int number = 0;
			try {
			number = Integer.parseInt(input.nextLine());
			}
			catch (Exception e) {
				System.out.println(e.getMessage());
			}
			
			switch(number)
			{
				case 1:
				{
					System.out.println("Enter Your Array Length");
					int length = Integer.parseInt(input.nextLine());
					int array[] = new int[length];
					System.out.println("Enter Your Array Values");
					
					for(int i = 0; i < length; i++)
					{
						array[i] = Integer.parseInt(input.nextLine());
					}
					System.out.println("Enter Your Sum Value");
					
					int sum = Integer.parseInt(input.nextLine());
					
					System.out.println(solCall.sumEqual(array, length, sum));
					break;
				}
				case 2:
				{
					System.out.println("Enter Your String Parentheses");
					String dummy = input.nextLine();
					try {
						System.out.println(solCall.isvaild(dummy));
					} catch (Exception e) {
						System.out.println(e.getMessage());
						//e.printStackTrace();
					}
					break; 
				}
				case 3:
				{
					System.out.println("Enter Your Array1 Length");
					int length1 = Integer.parseInt(input.nextLine());
					int array1[] = new int[length1];
					System.out.println("Enter Your Array1 Values");
					
					for(int i = 0; i < length1; i++)
					{
						array1[i] = Integer.parseInt(input.nextLine());
					}
					
					System.out.println("Enter Your Array2 Length");
					int length2 = Integer.parseInt(input.nextLine());
					int array2[] = new int[length2];
					System.out.println("Enter Your Array2 Values");
					
					for(int i = 0; i < length2; i++)
					{
						array2[i] = Integer.parseInt(input.nextLine());
					}
					System.out.println(solCall.merge(array1, array2, length1, length2));
					break;
				}
				case 4:
				{
					flag = true;
					break;
				}
			}
		}
	input.close();	
	}

}
