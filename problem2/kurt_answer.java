//https://www.jdoodle.com/online-java-compiler

public class Problem2 {

    
    private static int[] getAnswer(int[] ints){
        
        int intsProduct = 1;
        for (int num : ints){
            intsProduct *= num;
        }

        int[] answer = new int[ints.length];
        for (int i = 0; i < ints.length; i++){
            answer[i] = intsProduct/ints[i];
        }

        return answer;
    }
    
    
    public static void main(String args[]){
        
        int[] input = {1,2,3,4,5};
        int[] answer = getAnswer(input);
        
        for (int ans : answer){
            System.out.print(ans + ",");
        }
    }
}

// Things I Messed Up
//  - initialized my array with the wrong sytnax 
