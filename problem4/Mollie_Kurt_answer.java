public class Problem4 {
  
    
    public static int findLowestPositiveMissingNumber(int[] A){
        //Put all values into corresponding array index
        for (int i = 0; i < A.length; i++){ 
            //Only place value into index when it is:
            //  - within the array length
            //  - greater than 0
            //  - and not already in place*
            while(A[i] < A.length && A[i] > 0 && A[i] != i+1){
                
                //*if value appears more than once and is already
                // in place, ignore (duplicate case)
                if (A[i] == A[A[i]-1]){
                    A[i] = 0;
                    break;
                }
                
                //Put value into corresponding index by swapping.
                int temp1 = A[i];
                int temp2 = A[A[i]-1];
                A[A[i]-1] = temp1;
                A[i] = temp2;
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
