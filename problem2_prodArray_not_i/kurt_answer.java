//https://www.jdoodle.com/online-java-compiler

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

public class Problem2 {

    
    private static int[] getAnswer(int[] ints){
        
        int intsProduct = 1;
        int[] answer = new int[ints.length];

        
        /*We can solve the 0 problem by knowing:
            - An input array with one zero will return an array of 0s,
                 except where the 0 was in the input; Its value will be the product of the rest.
            - An input array with more than one zero will return an array of 0s.
        */  
        
        int firstZeroIndex = -1;     //The index of the first 0 found
        
        for (int i = 0; i < ints.length; i++){
            
            //If current value isn't 0 or a 0 has been found, it will create the product.
            if (ints[i] != 0 || firstZeroIndex != -1){
                intsProduct *= ints[i];
            }else{
                //We found a zero. Save its position.
                firstZeroIndex = i;
            }
        }

        //If a zero was found we have the answer: 
        //  its either an array of 0s, or an array with the product we previously built at the single 0s index
        if (firstZeroIndex != -1){
            //We set the answer of the first 0 to the product.
            //It
            answer[firstZeroIndex] = intsProduct;
            return answer;
        }

        
        for (int i = 0; i < ints.length; i++){
            answer[i] = intsProduct/ints[i];
        }

        return answer;
    }
    
    public static void main(String args[]){
        
        int[] input = {1,0,3,2,6,5,5,2,8};
        int[] answer = getAnswer(input);
        
        for (int ans : answer){
            System.out.print(ans + ",");
        }
    }
}

// Things I Messed Up
//  - initialized my array with the wrong sytnax
//  - didnt account for zero but now i do
