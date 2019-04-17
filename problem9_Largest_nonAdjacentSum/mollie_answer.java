
import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;
//import java.lang.Object
//java.lang.Number
//java.lang.Integer


public class Problem9_LargestNonAdjSum{

// Returns Final Answer: Sum of largest non adjacent integers
public static int largestNonAdjSum(int[] listNums){
    List<Integer> ans = findLargeNonAdj(listNums);
    return sumOfList(ans);
}

// Helper, returns List of all the largest non-adjacent integers from a given List
public static List<Integer> findLargeNonAdj(int[] listNums){
    
  // create two lists: one to store the values of the non-adjacent maxes
  // and another to store the index of those maxes
  	List<Integer> ans = new ArrayList<Integer>();
    List<Integer> maxPlaceList = new ArrayList<Integer>();
  
  	Integer[] listNumsObj = Arrays.stream( listNums ).boxed().toArray( Integer[]::new );
    List<Integer> listNumsList = Arrays.asList(listNumsObj); //useful to keep as list so can use while loop
  
    // While there's still stuff inside the listNums List
    while(!listNumsList.isEmpty()){ 
        
        int max = findMax(listNums);
        int maxPlace = findMaxPlace(listNums);
        
        // If we don't have anything that was adjacent to it already in ans, append it
        if (max>0 && !maxPlaceList.contains(Integer.valueOf(maxPlace + 1)) 
            		&& !maxPlaceList.contains(Integer.valueOf(maxPlace - 1)) ){
                
                ans.add(Integer.valueOf(max));                   // append Integer value of int max to answer list
                maxPlaceList.add(Integer.valueOf(maxPlace));     // append Integer value of int place of max
                
                listNums[maxPlace] = 0;      					 // get out of the way
          		listNumsList.remove(listNumsList.indexOf(Integer.valueOf(max))); // remove Integer max from listNumsList 
           
        }else{
            listNums[maxPlace] = 0;          					 // get out of the way
            listNumsList.remove(listNumsList.indexOf(Integer.valueOf(max))); // remove Integer max from listNumsList - will eventually terminate loop
        }
    }
  
  return ans;
}

// Helper, returns int sum of a List
public static int sumOfList(List<Integer> ans){
     
    int sum = 0;
    
    for(int i=0; i<ans.size(); i++){
        sum += ans.get(i).intValue();
    }
    return sum;
}


// Helper, returns int max
 public static int findMax(int [] A){
 	int max = A[0];
    
    for(int i=0; i<A.length; i++){
        if(A[i] > max){
            max = A[i];
        }
    }
    return max;
}
// Helper, returns int location of max
public static int findMaxPlace(int [] A){
    int maxi = 0;
    
    for(int i=0; i<A.length; i++){
        if(A[i] > A[maxi]){
            maxi = i;
        }
    }
    return maxi;
}




     public static void main(String []args){
        
        
       int [] A = {5,1,1,5};
        
        
        System.out.print(largestNonAdjSum(A));
        
        
     }
}

