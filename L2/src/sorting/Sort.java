package sorting;

import java.util.ArrayList;
import java.util.Arrays;

public class Sort 
{

public static int[] selectionSort(int array[])
{
	int i,j,temp,minIndex;
	for(i = 0; i < array.length; i++)
	{
		minIndex = i;
		for(j = i+1; j < array.length; j++)
		{
			if(array[j] < array[minIndex])
			{
				minIndex = j;
			}
		}
		temp = array[i];
		array[i] = array[minIndex];
		array[minIndex] = temp;
	}
return array;
}

public static int[] bubbleSort(int array[])
{
	int i,j,temp;
	boolean flag;
	for(i = 1; i < array.length; i++)
	{
		flag = false;
		for(j = 0; j < array.length - i; j++)
		{
			if(array[j] > array[j+1])
			{
				flag = true;
				temp = array[j];
				array[j] = array[j+1];
				array[j+1] = temp;
			}
		}
		if(!flag)
		{
			break;
		}
	}
return array;	
}

public static int[] insertionSort(int array[])
{
	int i,j,temp;
	for(i = 1; i < array.length; i++)
	{
		for(j = i; j > 0; j--)
		{
			if(array[j] < array[j - 1])
			{
				temp = array[j];
				array[j] = array[j - 1];
				array[j - 1] = temp;
			}
			else
			{
				break;
			}
		}
	}
return array;	
}

public static int[] mergeSort(int array[])
{
	if(array.length == 1)
	{
		return array;
	}
	
	int midValue = array.length/2;
	
	int left[] = mergeSort(Arrays.copyOfRange(array,0,midValue));
	int right[] = mergeSort(Arrays.copyOfRange(array, midValue, array.length));
	
	return merge(left,right);
}

public static int[] merge(int left[],int right[])
{
	int saved[] = new int[left.length+right.length];
	int i = 0,j = 0,k = 0;
	
	while(i < left.length && j < right.length)
	{
		if(left[i] < right[j])
		{
			saved[k++] = left[i++];
		}
		else
		{
			saved[k++] = right[j++];
		}
	}
	
	while(i < left.length)
	{
		saved[k++] = left[i++];
	}
	while(j < right.length)
	{
		saved[k++] = right[j++];
	}
return saved;	
}

public static int closestToZero (int arr[], int n)
{
      arr = mergeSort(arr);
      int ans = arr[0] + arr[n - 1];
      int start = 0,end = n - 1;
      
      while(start < end)
      {
          int sum = arr[start] + arr[end];
          
          if(sum == 0)
          {
              return 0;
          }
          
          if(sum < 0)
          {
              start++;
          }
          else
          {
              end--;
          }
          if(Math.abs(sum) < Math.abs(ans))
          {
              ans = sum;
          }
          if(Math.abs(sum) == Math.abs(ans))
          {
              ans = Math.max(ans,sum);
          }
      }
return ans;      
}

public static void bitonicGenerator(long arr[], int n)
{
    int j = 0;
    long saved[] = new long[n];
    
    
    for(int i = 0; i < n; i++)
    {
        if(i % 2 == 0)
        {
            saved[j++] = arr[i];
        }
    }
    //System.out.println(j);
    
    for(int i = n - 1; i >= 0; i--)
    {
        if(i % 2 == 1)
        {
            saved[j++] = arr[i];
        }
    }
    
    for(int i = 0; i < n; i++)
    {
        arr[i] = saved[i];
    }
}

public static ArrayList<Integer> candyStore(int candies[],int N,int K){
    
    ArrayList<Integer> ans = new ArrayList<>();
    Arrays.sort(candies);
    
    int min = 0;
    int max = 0;
    
    for(int i = 0; i < N; i++)
    {
        min += candies[i];
        N = N-K;
    }
    
    int saved = 0;
    for(int i = candies.length - 1; i >= saved; i--)
    {
        max += candies[i];
        saved += K;
    }
    
    ans.add(min);
    ans.add(max);
    
    return ans;
}

}
