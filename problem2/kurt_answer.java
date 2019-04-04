//https://www.jdoodle.com/online-java-compiler

public class Problem2 {

    
    private static int[] getAnswer(int[] ints){
        
        int intsProduct = 1;
        int[] answer = new int[ints.length];

        
        /*We can solve the 0 problem by knowing:
            - An array with one zero will be an array of 0s, expect the 0. It will be the product of the rest.
            - An array with more than one zero will be an array of 0s.
        */  
        
        int firstZeroIndex = -1;     //The index of the first 0 found
        
        for (int i = 0; i < ints.length; i++){
            
            //If it isn't 0 or a 0 has been found, it will create the product.
            if (ints[i] != 0 || firstZeroIndex != -1){
                intsProduct *= ints[i];
            }else{
                //We found a zero. Save its position.
                firstZeroIndex = i;
            }
        }

        //If a zero was found we have the answer already. 
        if (firstZeroIndex != -1){
            //We set the answer of the first 0 to the product.
            //If there is one zero, it is the correct answer; otherwise it is all 0s because we only skipped the first 0 in our product series. 
            answer[firstZeroIndex] = intsProduct;
            return answer;
        }

        
        for (int i = 0; i < ints.length; i++){
            answer[i] = intsProduct/ints[i];
        }

        return answer;
    }
    
    
    public static void main(String args[]){
        
        //int[] input = {1,2,3,2,0,5,5,2,8};
        int[] input = {};
        int[] answer = getAnswer(input);
        
        for (int ans : answer){
            System.out.print(ans + ",");
        }
    }
}

// Things I Messed Up
//  - initialized my array with the wrong sytnax
//  - didnt account for zero but now i do
