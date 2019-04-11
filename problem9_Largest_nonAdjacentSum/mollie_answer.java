
import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;

public class Problem9_LargestNonAdjSum{

// Returns Final Answer: Sum of largest non adjacent integers
public static int largestNonAdjSum(ArrayList<Integer> listNums){
    ArrayList<Integer> ans = findLargeNonAdj(listNums);
    return sumList(ans);
}

// Helper, returns List of all the largest non-adjacent integers from a given List
public static ArrayList<Integer> findLargeNonAdj(ArrayList<Integer> listNums){
    ArrayList<Integer> ans = new ArrayList<Integer>();
    ArrayList<Integer> maxPlaceList = new ArrayList<Integer>();
    
    // FIX
    Object[] listNumsArr = new Integer[0];
    listNumsArr = listNums.toArray(); //listNums array is now Integer array?
    
    while(!listNums.isEmpty()){ //useful to keep as list so can use while loop
        // FIX
        Integer max = findMax(listNumsArr);
        Integer maxPlace = findMaxPlace(listNumsArr);
        // FIX
        // If we don't have anything that was next to it already in ans, append
        if (max>0 && !maxPlaceList.contains(valueOf(maxPlace.intValue() + 1)) && !maxPlaceList.contains(valueOf(maxPlace.intValue() - 1))){
                
                ans.add(max);                   // append num to answer list
                maxPlaceList.add(maxPlace);     // append place of num 
                
                listNumsArr[maxPlace.intValue()] = 0;      // get out of the way
                listNums.remove(indexOf(max));  // remove from original list
            
        }else{
            listNumsArr[maxPlace.intValue()] = 0;          // get out of the way
            listNums.remove(indexOf(max));      // remove from original list
        }
    }
  
  return ans;
}

// Helper, returns sum of a List
public static int sumList(ArrayList<Integer> ans){
    Object[] answer = new Integer[0];
    answer = ans.toArray(); //problematic?
    int sum = 0;
    
    for(int i=0; i<answer.length; i++){
        sum += answer[i].intValue();
    }
    return sum;
}


// Helper, returns max
public static Integer findMax(Integer A[]){
    Integer max = A[0];
    
    for(int i=0; i<A.length; i++){
        if(A[i]>max){
            max = A[i];
        }
    }
    return max;
}
// Helper, returns location of max
public static Integer findMaxPlace(Integer A[]){
    Integer maxi = 0;
    
    for(int i=0; i<A.length; i++){
        if(A[i]>A[maxi.intValue()]){
            maxi = i;
        }
    }
    return maxi;
}




     public static void main(String []args){
        
        
        ArrayList<Integer> A = new ArrayList<Integer>();
        A.add(5);
        A.add(1);
        A.add(1);
        A.add(5);
        
        
        System.out.print(largestNonAdjSum(A));
        
        
     }
}

