/*
Given an array of integers, find the first missing positive integer in linear time and constant space. In other words, 
find the lowest positive integer that does not exist in the array. The array can contain duplicates and negative numbers
as well.

For example, the input [3, 4, -1, 1] should give 2. The input [1, 2, 0] should give 3.

You can modify the input array in-place.
*/

public class Problem4 {
    
    public static int findLowestPositiveMissingNumber(int[] A){
        //Put all values into corresponding array index
        for (int i = 0; i < A.length; i++){ 
            //At each index, we contually swap the current value with the value in its corresponding index.
            //We continue doing this as long as the current value is:
            //  - within the array length
            //  - greater than 0
            //  - and not already in place* (equal to the current index)
            while(A[i] < A.length && A[i] > 0 && A[i] != i+1){
                
                //*if value appears more than once and is already
                // in place, ignore and mark 0 so its never swapped again (duplicate case)
                if (A[i] == A[A[i]-1]){
                    A[i] = 0;
                    break;
                }
                
                //Put value into corresponding index by swapping.
                int temp1 = A[i];
                int temp2 = A[A[i]-1];
                A[A[i]-1] = temp1;
                A[i] = temp2;

                //Continue the while loop on this index in case we swapped with another number we can 
                //put in its correct place.
            }
        }
        
        //Climb sorted positive numbers until we find a hole and return its "ideal" value; 
        //meaning that number doesn't exist, otherwise it would be at its index.
        for (int i = 0; i < A.length; i++){ 
            if (A[i] != i+1){
                return i+1;
            }
        }
        
        //When all indexes are in place, return one plus the highest value
        return A.length+1;
    }
  
    public static void main(String args[]) {
        
        int[] nums = {1,2,3,4,5,6};
        int answer = findLowestPositiveMissingNumber(nums);        
    
    }
}
