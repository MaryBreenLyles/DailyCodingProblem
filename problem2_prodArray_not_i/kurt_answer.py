#https://www.onlinegdb.com/online_python_compiler

'''
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
by the current value to get the product of all elements except self. Place at index and continue. 

'''

def problem2(ints):
    intsProduct = 1
    for num in ints:
        intsProduct *= num
    answer = []
    for num in ints:
        answer.append(int(intsProduct/num))
    return answer

print(problem2([1,2,3,4,5]))

#Things I did wrong
#   - I originally forgot to cast to an int, so the array came back as doubles. Java would help with this
#   - Didnt account for 0s. Fixed this in the Java case.
