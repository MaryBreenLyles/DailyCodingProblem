#https://www.onlinegdb.com/online_python_compiler

'''
-------------------------------------------------------
 Question
-------------------------------------------------------
This problem was recently asked by Google.

Given a list of numbers and a number k, return whether any two numbers from the 
list add up to k.

For example, given [10, 15, 3, 7] and k of 17, return true since 10 + 7 is 17.

Bonus: Can you do this in one pass?

-------------------------------------------------------
 First Algorithm Explanation 
-------------------------------------------------------

My idea is to sort the array, and close in on the answer with two pointers.
O(nlogn) + O(n/2)

However, this is not one pass.

'''

def sumOfAnyTwoEqualsK(nums, k):
    
    #Sort the array and place pointers at each end
    nums.sort()
    p1 = 0
    p2 = len(nums) - 1

    #Move pointers inward based on if the current sum is too low or too high
    while p1 != p2:
        sum = nums[p1] + nums[p2]
        if sum < k:
            p1 += 1
        elif sum > k:
            p2 -= 1
        else:
            return str(nums[p1]) + " and " + str(nums[p2])
            
    return "False"
    

array = [3,10,1,6,22,34,4,1,4]
print(sumOfAnyTwoEqualsK(array, 9))

