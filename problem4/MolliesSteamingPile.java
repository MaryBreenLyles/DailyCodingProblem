// https://www.tutorialspoint.com/compile_java_online.php

// This bullshit is only O(n^2) time....O(4) space? :'(

public class Problem4_FUCKINBULLSHIT{

     public static void main(String []args){
        
        int [] A = {3,4,-1,2,2,1};
        
        System.out.print(LowestMissingPos(A));
        
        
     }
     
     // FIND THE LOWEST POSITIVE INTEGER THAT DOESN'T EXIST IN ARRAY
     static int LowestMissingPos(int [] A){
         
         // FIND MAX TO USE AS INITIAL MIN
         int max = getMax(A);
         
         // FIND POSITIVE MIN (including 0)
         int min = getMin(A, max);
         
         
         // SEARCH min++ OR RETURN 1
         if(min<=1){    // if it's 1 or 0
             
             // CHECK FOR min++ UNTIL NO LONGER THERE*** (***PLACEHOLDER, DOESN'T ACTUALLY WORK in O(n)***)
             for(int i=0; i<A.length; i++){
             
                 if(existsPlusOne(A, min) == true){
                     min++;
                 }
             }
             
             return min+1;
         }
         
         else{
             return 1;
         }
         
     }
     
     
     static boolean existsPlusOne(int [] A, int k){
         for(int i=0; i<A.length; i++){
             if(A[i]==k+1){
                 return true;
             }
         }
         
         return false;
     }
     
     
     // FIND MAX METHOD
     static int getMax(int [] A){
         
         int max = A[0];
         
         for(int i=0; i<A.length; i++){
             
             if( A[i]>max ){
                 max = A[i];
             }
         }
         return max;
     }
     
     // FIND POSITIVE MIN GIVEN MAX METHOD
     static int getMin(int [] A, int max){
         
         int min = max;
         for(int i=0; i<A.length; i++){
             
             if( A[i]>=0 & A[i]<min ){
                 min = A[i];
             }
         }
         return min;
     }
     
     
}






