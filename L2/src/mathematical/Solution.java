package mathematical;

public class Solution 
{
	int count = 0;
public int palindrome(int number)
{
	return getPalindrome(number, 10);
}

public int getPalindrome(int number,int value)
{	
	StringBuilder ans = new StringBuilder(value+"");

	if(Integer.parseInt(ans.reverse().toString()) == value)
	{
		count++;
	}
	
	if(number == count)
	{
		return value;
	}
	
return getPalindrome(number, value+1);	
}

}
