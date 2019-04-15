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

Follow-up: what if you can't use division?

-------------------------------------------------------
 Algorithm Explanation 
-------------------------------------------------------

Basic Idea: Get the product of the array. Then, iterate through and divide that product
by the current value to get the product of all elements execpt self. Place at index and continue. 



*/


import java.util.Arrays;

public class ICanDoThings_ProdNoti{

     public static void main(String []args){
       
      
        int [] A = {3,2,1,0};
        
        
        for(int i=0; i<A.length; i++){
            System.out.println(prodNoti_MASTER_OF_ZEROS(A)[i]);
        }
        
     
        
     }
     
     
     //3 Can take zero in A (BETTER)
     
     // If one zero is present, all other indices in output will
     // contain 0, except for the index of original Array that contained 
     // the zero
     
     // Also, if more than one zero is present, all entries in output are zero
     
    static int [] prodNoti_MASTER_OF_ZEROS(int [] A){
         
         int prod = 1;
         int [] B = new int[A.length];
         
         
         // CHECK FOR THOSE PROGRAM-BREAKING ZERO BASTARDS
         int zeroCount = 0;
         for(int i=0; i<A.length; i++){
             
             if ( A[i]==0 ){
                 zeroCount++;
                 continue;
             }
         }
         
         
         // FOR THE NONZERO GOOD TIMES
         if (zeroCount==0){
             
             for(int i=0; i<A.length; i++){
                 prod = prod*A[i];
             }
         
             for(int i=0; i<A.length; i++){
                 B[i] = prod/A[i]; 
             }
             
         }
         
         
         // FOR THE SINGLE ZERO TIMES
         else if (zeroCount==1){
             
             for(int i=0; i<A.length; i++){
                 
                 if(A[i]==0){
                     continue;
                 }
                 else{
                     prod = prod*A[i];
                 }
             }
             
             for(int i=0; i<A.length; i++){
             
                 if (A[i]!=0){
                     B[i] = 0;
                 }
                 else{
                     B[i] = prod;
                 }
             }
         }
         
         
         // FOR THE MULTI FUCKIN ZERO TIMEZZZZ
         else{
             
             for(int i=0; i<A.length; i++){
                 B[i] = 0;
             }
         }
         
         
         return B;
     }
     
}
