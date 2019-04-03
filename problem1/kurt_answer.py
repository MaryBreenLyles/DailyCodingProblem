#https://www.onlinegdb.com/online_python_compiler
def sumOfAnyTwoEqualsK(nums, k):
    nums.sort()
    p1 = 0
    p2 = len(nums) - 1

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