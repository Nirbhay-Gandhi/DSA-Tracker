/******************************************************************************
Given an array of integers, the task is to find the maximum difference between any two elements 
such that larger element appears after the smaller number.  We mainly need to find maximum difference 
in an inversion (larger before smaller)
Note: If no such pair exists, return -1.

Input : arr = [2, 3, 10, 6, 4, 8, 1]
Output : 8
Explanation : The maximum difference is between 10 and 2.


Input : arr = [7, 9, 5, 6, 3, 2]
Output : 2
Explanation : The maximum difference is between 9 and 7.


Input: arr = [4, 3, 3, 2, 1]
Output: -1
Explanation: No such pair exists such that i < j and arr[i] < arr[j].
*******************************************************************************/

public class Main
{
    
    public static int findDiff_on2(int[] arr)
    {
        int maxDiff = -1;
        
        for(int i=0; i<arr.length; i++)
        {
            for(int j=i+1; j<arr.length; j++)
            {
                if(arr[j] > arr[i])
                {
                    maxDiff = Math.max(maxDiff, arr[j]-arr[i]);
                }
            }
        }
        
        return maxDiff;
    }
    
    public static int findDiff_on1(int[] arr)
    {
        int maxDiff = -1;
        
        int minSeenSoFar = arr[0];
        
        for(int i=1; i<arr.length; i++)
        {
            if(arr[i] <= minSeenSoFar)
            {
                minSeenSoFar = arr[i];
            }
            else
            {
                maxDiff = Math.max(maxDiff, arr[i] - minSeenSoFar);    
            }
        }
        
        return maxDiff;
    }
    
    public static int findDiff_on(int[] arr)
    {
        //using kadene's algo
        /**      12 12 12  12  7  7  4  4
         * idea: [9, 5, 8, 12, 2, 3, 7, 4] 
         * if at every point, I get the maximum valued element 
         * after that, than it should work... 
         */
        
        int maxDiff = -1;
        int n = arr.length;
        int suffixMax = arr[n-1];
        
        for(int i=n-2; i>=0; i--)
        {
            if(arr[i] >= suffixMax)
            {
                suffixMax = arr[i];
            }
            else
            {
                maxDiff = Math.max(maxDiff,suffixMax-arr[i]);
            }
        }
        return maxDiff;
    }
    
	public static void main(String[] args) 
	{
// 		int[] arr = {7, 9, 5, 6, 3, 2};
// 		int[] arr = {2, 3, 10, 6, 4, 8, 1};
		int[] arr = {4, 3, 3, 2, 1};
		
		int diff1 = findDiff_on2(arr);
		int diff2 = findDiff_on1(arr);
		int diff3 = findDiff_on(arr);
		System.out.println(diff1);
		System.out.println(diff2);
		System.out.println(diff3);
		
	}
}
