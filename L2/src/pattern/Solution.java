package pattern;

public class Solution 
{
	
public void pyramidPattern(int row)
{
	for(int i = row-1 ; i >=0 ; i--) 
	{
		for(int j = 0 ; j < row ; j++) 
		{
			if(i <= j) 
			{
				System.out.print("* ");
			}
			else 
			{
				System.out.print(" ");
			}
		}
		System.out.println();
	}
}

public void rightTrianglePattern(int row)
{
	for(int i = 0; i < row; i++)
	{
		for(int j = 0; j <= i; j++)
		{
			System.out.print("* ");
		}
		System.out.println();
	}
}

public void leftTrianglePattern(int row)
{
	for(int i = row-1 ; i >=0 ; i--) 
	{
		for(int j = 0 ; j < row ; j++) 
		{
			if(i <= j) 
			{
				System.out.print("*");
			}
			else 
			{
				System.out.print(" ");
			}
		}
		System.out.println();
	}
}

public void diamondShapePattern(int row)
{
	int space = row - 1;
	for(int i = 1 ; i <= row ; i++) 
	{
		for(int j = 1 ; j <= space ; j++) 
		{
			System.out.print(" ");
		}
		
		space--;
		
		for(int j = 0; j < 2 * i - 1;j++)
		{
			System.out.print("*");
		}
		System.out.println();
	}
	
	space = 1;
	
	for(int i = 1 ; i < row ; i++) 
	{
		for(int j = 1 ; j <= space ; j++) 
		{
			System.out.print(" ");
		}
		
		space++;
		
		for(int j = 0; j < 2 * (row-i) - 1;j++)
		{
			System.out.print("*");
		}
		System.out.println();
	}
}

public void rightPascalTriangle(int row)
{
	for(int i = 0; i < row;i++)
	{
		for(int j = 0; j <= i; j++)
		{
			System.out.print("* ");
		}
		System.out.println();
	}
	
	for(int i = row - 1; i >= 0;i--)
	{
		for(int j = 0; j < i; j++)
		{
			System.out.print("* ");
		}
		System.out.println();
	}
	
}

public void sandglassPattern(int row)
{
	for(int i = 0 ; i < row ; i++) 
	{
		for(int j = 0 ; j < row ; j++) 
		{
			if(i <= j) 
			{
				System.out.print("* ");
			}
			else 
			{
				System.out.print(" ");
			}
		}
		System.out.println();
	}
	
	for(int i = row-1 ; i >=0 ; i--) 
	{
		for(int j = 0 ; j < row ; j++) 
		{
			if(i <= j) 
			{
				System.out.print("* ");
			}
			else 
			{
				System.out.print(" ");
			}
		}
		System.out.println();
	}
}

public void trianglePattern(int row)
{
	for(int i = 1; i <= row; i++)
	{
		for(int j = i; j < row;j++)
		{
			System.out.print(" ");
		}
		
		for(int k = 1; k <= (2*i-1);k++)
		{
			if(k == 1 || i == row || k == (2*i-1))
			{
				System.out.print("*");
			}
			else
			{
				System.out.print(" ");
			}
		}
		System.out.println();
	}
}

public void diamondPattern(int row)
{
	for(int i = 1; i <= row; i++)
	{
		for(int j = i; j < row;j++)
		{
			System.out.print(" ");
		}
		
		for(int k = 1; k <= (2*i-1);k++)
		{
			if(k == 1 || k == (2*i-1))
			{
				System.out.print("*");
			}
			else
			{
				System.out.print(" ");
			}
		}
		System.out.println();
	}
	
	for(int i = row - 1; i >= 0; i--)
	{
		for(int j = i; j < row;j++)
		{
			System.out.print(" ");
		}
		
		for(int k = 1; k <= (2*i-1);k++)
		{
			if(k == 1 || k == (2*i-1))
			{
				System.out.print("*");
			}
			else
			{
				System.out.print(" ");
			}
		}
		System.out.println();
	}
}

public void simpleNumberPattern(int row)
{
	
	for(int i = 1; i <= row; i++)
	{
		for(int j = 1; j <= i;j++)
		{
			System.out.print(j+" ");
//			if(j == 0)
//			{
//				System.out.print(j+1+" ");
//			}
//			else if(j == 1) 
//			{
//			   System.out.print(j+1+" "); 
//			}
//			else if(j == 2) 
//			{
//			   System.out.print(j+1+" "); 
//			}
//			else if(j == 3) 
//			{
//			   System.out.print(j+1+" "); 
//			}
//			else 
//			{
//			   System.out.print(j+1+" "); 
//			}
		}
		System.out.println();
	}
}

public void PascalTriangleProgram(int row)
{
	int count = 1,i,j;
	
	for(i = 0; i < row;i++)
	{
		for(j = row - i; j > 0;j--)
		{
			System.out.print(" ");
		}
		
		for(j = 0; j <= i; j++)
		{
			if(i == 0 || j == 0)
			{
				count = 1;
			}
			else
			{
				count = count * (i - j + 1) / j;
			}
			System.out.print(count+" ");
		}
		System.out.println();
	}
}

public void diamondPatternProblem(int row)
{
	int space = row - 1;
	for(int i = 1 ; i <= row ; i++) 
	{
		for(int j = 1 ; j <= space ; j++) 
		{
			System.out.print(" ");
		}
		
		space--;
		
		for(int j = 0; j < 2 * i - 1;j++)
		{
			System.out.print(j);
		}
		System.out.println();
	}
	
	space = 1;
	
	for(int i = 1 ; i < row ; i++) 
	{
		for(int j = 1 ; j <= space ; j++) 
		{
			System.out.print(" ");
		}
		
		space++;
		
		for(int j = 0; j < 2 * (row-i) - 1;j++)
		{
			System.out.print(j);
		}
		System.out.println();
	}
}

public void zPattern(int row)
{
	for (int i = 1; i <= row; i++) 
	{
        for (int j = row; j >= 1; j--) 
        {
           if (i == 1 || i == row || i == j) 
           {
              System.out.print("* ");
           }
           else
           {
              System.out.print("  ");
           }
        } 
        System.out.println(); 
     } 
}

public void spiralPattern(int n)
{
	int dummy = 2 * n - 1;
	for(int i = 1; i <= dummy; i++)
	{
		for(int j = 1; j <= dummy;j++) 
		{
			System.out.print(Math.max(Math.abs(i - n), Math.abs(j - n))+ 1 +" ");
		}
		System.out.println();
	}
}


public void spiralPatternWithModification(int size) 
{	
	int i, j, k;
	int[][] board = new int[size][size];
	int left, top;
	left = 0;
	top = size - 1;
	k = 1;
	for (i = 1; i <= size / 2; i++, left++, top--) 
	{
		for (j = left; j <= top; j++, k++) 
		{
			board[left][j] = k;
		}
		for (j = left + 1; j <= top; j++, k++) 
		{
			board[j][top] = k;
		}
		for (j = top - 1; j >= left; j--, k++) 
		{
			board[top][j] = k;
		}
		for (j = top - 1; j >= left + 1; j--, k++) 
		{
			board[j][left] = k;
		}
	}
	
	for (i = 0; i < size; i++) 
	{
		for (j = 0; j < size; j++) 
		{
			System.out.printf("%-5d", board[i][j]);
		}
		System.out.printf("\n");
	}
}

public void characterPattern(char[] arr) {
	int i = 0;
	int j = arr.length - 1;
	while (i < j) 
	{
		System.out.print(arr[i] + " " + arr[j]);
		System.out.println();
		i++;
		j--;
	}
	System.out.print(arr[i]);
	System.out.println();
	i--;
	j++;
	while (i >= 0) 
	{
		System.out.print(arr[i] + " " + arr[j]);
		System.out.println();
		i--;
		j++;
	}
}

public void alternatingRectangle(int row)
{
	int dummy = 2 * row - 1;
	for(int i = 1; i <= dummy; i++)
	{
		for(int j = 1; j <= dummy;j++) 
		{
			if((Math.max(Math.abs(i - row), Math.abs(j - row)) + 1)  % 2 == 0)
			{
				System.out.print("O ");
			}
			else
			{
				System.out.print("X ");
			}
		}
		System.out.println();
	}
}

public String countAndSay(int n) {
    
    if(n == 1)
    {
        return "1";
    }
    
    StringBuilder ans = new StringBuilder();
    
    String str = countAndSay(n - 1);
    
    int count = 0;
    
    for(int i = 0; i < str.length();i++)
    {
        count++;
        if(i == str.length() - 1 || str.charAt(i) != str.charAt(i+1))
        {
            ans.append(count).append(str.charAt(i));
            count = 0;
        }    
    }
return ans.toString();     
}

}
