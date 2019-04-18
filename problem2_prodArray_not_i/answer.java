 /*
-------------------------------------------------------
 Question
-------------------------------------------------------
Good morning! Here's your coding interview problem for today.

This problem was asked by Uber.

Given an array of integers, return a new array such that each element at index i 
of the new array is the product of all the numbers in the original array except the one at i.

For example, if our input was [1, 2, 3, 4, 5], the expected output would be 
[120, 60, 40, 30, 24]. If our input was [3, 2, 1], the expected output would be [2, 3, 6].

Follow-up: what if you can't use division?. 

-------------------------------------------------------
 Algorithm Explanation 
-------------------------------------------------------

The idea is to get the product of all the left side values,
the product of all the right side values,
and then multipuly them together

[1, 2, 3, 4] 

[23,12,8,6] - Output

[1,1,2,6] - Product of Left Side Elts

[24, 12, 4, 1] - Product of Right Side Elts

[24,12,8,6] - Output

**TAKE AWAY**
It is super helpful to try to frame the problem in as many ways as you can.


*/
 
 public int[] productExceptSelf(int[] nums) {
    	int n = nums.length;
    	int[] res = new int[n];
    	int right=1,left=1;
        for(int i=0;i<n;i++){
            res[i]=1;
        }
    	for (int i=0;i<n;i++) {
    		res[i]*=left;
    		left*=nums[i];
    	}
    	for(int i=n-1;i>=0;i--) {
    		res[i]*=right;
    		right*=nums[i];
    	}
    	return res;
    }
