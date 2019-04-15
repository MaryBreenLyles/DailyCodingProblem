//https://www.onlinegdb.com/online_python_compiler

/*
-------------------------------------------------------
 Question
-------------------------------------------------------
This problem was recently asked by Google.

Given a list of numbers and a number k, return whether any two numbers from the 
list add up to k.

For example, given [10, 15, 3, 7] and k of 17, return true since 10 + 7 is 17.

Bonus: Can you do this in one pass?

-------------------------------------------------------
 Algorithm Explanation 
-------------------------------------------------------

Hash the array, iterate through, and check if target - curr is in the map

*/

public boolean twoSum(int[] nums, int target) {

    //Edge Cases
    if(nums.length == 0 || nums == null) return false;

    Map<Integer, Integer> complementMap = new HashMap<>();

    //check if target - curr is in the map
    for (int i = 0; i < nums.length; i++) {
         int curr = nums[i];
         if(complementMap.containsKey(target - curr)){
           return true;
         }
        complementMap.put(curr, i);
    }
  return false;
}