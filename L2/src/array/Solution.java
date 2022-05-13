package array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Solution {

	ArrayList<Long> alternateSort(long arr[] ,int N)
    {
        ArrayList<Long> ans = new ArrayList<>();
        
        Arrays.sort(arr);
        
        int j = N - 1;
        
        for(int i = 0; i < N;i++)
        {
            if(i % 2 == 0)
            {
                ans.add(arr[j]);
                j--;
            }
        }
        j=0;
        for(int i = 0; i < N;i++)
        {
            if(i % 2 == 1)
            {
                ans.add(i,arr[j]);
                j++;
            }
        }
    return ans;    
    }

static int majorityElement(int a[], int size)
    {
        int count = 0;
        int j = size -1;
        for(int i = 0; i < size;)
        {
        	if(a[i] == a[j])
        	{
        		count++;
        		i++;
        	}
        	j--;
        }
        
        if(size/2 < count)
        {
            return count;
        }
        else
        {
            return -1;
        }
}

int getPairsCount(int[] arr, int n, int k) {
    
    int count = 0;
    int ans = 0;
  
    for(int i = 0; i < n; i++)
    {
        for(int j = 0; j < n; j++)
        {
        	if(j > i)
        	{
            ans = arr[i] + arr[j];
            if(ans == k)
            {
                count++;
            }
        	}
        }
    }
return count;    
}

public int numIdenticalPairs(int[] nums) {
    int count = 0;
    int i = 0;
    int j = nums.length - 1;
    
    while(i < j)
    {
        if(nums[i] == nums[j])
        {
            count++;

        }
     
        if(i!=nums.length-1 && i+1==j)
        {
            i++;
            j=nums.length-1;
        }
        j--;
    }
return count;
}

//calculation of weight after balance point 
public String balancePoint(String inp, int len) { 
        int j = 1; 
        if (len == inp.length() - 1) { 
                return "not balanced"; 
        } 
        char ch1 = inp.charAt(len); 
        int out = 0; 
        Map<Character, Integer> map = new HashMap<Character, Integer>(); 
        for (char ch = 'a'; ch <= 'z'; ++ch) { 
                map.put(ch, j); 
                j++; 
        } 
        j = 1; 
        int output = 0; 
        int ind = inp.indexOf(ch1); 
        for (int i = ind + 1; i < inp.length(); i++) { 
                output += j * map.get(inp.charAt(i)); 
                j++; 
        } 
        j = 1; 
        for (int i = 0; i < ind; i++) { 
                out += j * map.get(inp.charAt(i)); 
                j++; 
        } 
        if (output - out == 0) { 
                return "balanced at " + inp.charAt(len); 
        } else { 
                return balancePoint(inp, len + 1); 
        } 
}

public int minimum_difference(int[] nums)
{
    int ans = 0;
    
    List<Integer> out = new ArrayList<>(500);
    
    for(int i = 0; i < nums.length;i++)
    {
        for(int j = i+1; j < nums.length; j++)
        {
                ans = nums[i] - nums[j];
                if(ans < 0)
                {
                	ans = 0 - ans;
                }
                out.add(ans);
            
        }
    }
    Collections.sort(out);
return out.get(0);    
}

void rearrange(int nums[], int n) {
    
    List<Integer> ans = new ArrayList<>();
     for(int i = 0; i < nums.length; i++)
     {
         if(nums[i] >= 0)
         {
            ans.add(nums[i]);
         }
     }
     int j = 1;
     for(int i = 0; i < nums.length; i++)
     {
    	 
    	 if(nums[i] < 0)
         {
    		 ans.add(j,nums[i]);
    		 j = j + 2;
         }
      }     
}

public static int kthSmallest(int[] arr, int l, int r, int k) 
{ 
    Arrays.sort(arr);
    int count = 0;
    int min = Integer.MAX_VALUE;
    for(int i = 0; i < r; i++)
    {
        min = Math.min(arr[i],min);
        count++;
        if(count == k)
        {
            return arr[i];
        }
    }
return 0;
}

int getPairsCount1(int[] arr, int n, int k) {
    
    int count = 0;
    Map<Integer,Integer> ans = new HashMap<>();
    
    for(int i = 0; i < n; i++)
    {
        if(ans.containsKey(k - arr[i]))
        {
            count += ans.get(k - arr[i]);
        }
        
		/*
		 * if(ans.containsKey(arr[i])) { ans.put(arr[i],ans.get(arr[i])+1); }
		 */
		/*
		 * else {
		 */
            ans.put(arr[i],1);
       // }
    }
return count;    
}

long maxSubarraySum(int arr[], int n){
    
    int sum = 0;
    int ans = arr[0];
    for(int i = 0; i < n ;i++)
    {
       if(sum < 0)
       {
            sum = 0;
       }
       sum = sum + arr[i];
       if(sum > ans)
       {
           ans = sum;
       }
   }
   return ans;
}    

	public static void main(String[] args) 
	{
		Scanner sc = new Scanner(System.in); 
		
		Solution solCall = new Solution();
		
		int number = sc.nextInt();
		/*
		 * Scanner sc = new Scanner(System.in);
		 * 
		 * // int length = sc.nextInt();
		 * 
		 * int len = sc.nextInt();
		 * 
		 * int rotate = sc.nextInt();
		 * 
		 * int z = len - 1;
		 * 
		 * int arr[] = new int[len];
		 * 
		 * int temp = 0;
		 * 
		 * for(int j = 0; j < arr.length;j++) { arr[j] = sc.nextInt(); }
		 * System.out.println(Arrays.toString(arr)); int dummy[]=new int[len]; int i=0;
		 * for(int k = rotate; k < len;k++) { dummy[i]=arr[k]; i++; } for(int
		 * k=0;k<rotate;k++) { dummy[i]=arr[k]; i++; }
		 * 
		 * System.out.println(Arrays.toString(dummy));
		 */
		switch(number)
		{
			case 1:
				long arr[] = {7,1,2,3,4,5,6};
				System.out.println(solCall.alternateSort(arr,7));
				break;
				
			case 2:
				int a[] = {3,1,3,3,5};
				System.out.println(Solution.majorityElement(a, 5));
				break;
				
			case 3:
				int a1[] = {1,5,7,1};
				System.out.println(solCall.getPairsCount(a1, 4, 6));
				break;
				
			case 4:
				int a2[] = {1,1,3,5,3,2,2};
				System.out.println(solCall.numIdenticalPairs(a2));
				break;
				
			case 5:
				int a3[] = {3, 10, 8, 6};
				System.out.println(solCall.minimum_difference(a3));
				break;
				
			case 6:
				int b[] = {9, 4, -2, -1, 5, 0, -5, -3, 2};
				solCall.rearrange(b, 9);
				break;
			
			case 7:
				int b1[] = {7,10,4,3,20,15};
				System.out.println(Solution.kthSmallest(b1, 0, 6, 3));
				break;
				
			case 8:
				int b2[] = {1,5,7,-1,5,1,5};
				System.out.println(solCall.getPairsCount1(b2, 7, 6));
				break;
				
			case 9:
				int c[] = {-1,-2,-3,-4};
				System.out.println(solCall.maxSubarraySum(c, 4));
				break;	
		}
	sc.close();	
	}

}
