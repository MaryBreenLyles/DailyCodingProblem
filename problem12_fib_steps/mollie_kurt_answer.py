#https://www.onlinegdb.com/online_python_compiler
'''
-------------------------------------------------------
 Question
-------------------------------------------------------
This problem was asked by Amazon.

There exists a staircase with N steps, and you can climb up either 1 or 2 steps at a time. 
Given N, write a function that returns the number of unique ways you can climb the staircase. 
The order of the steps matters.

For example, if N is 4, then there are 5 unique ways:

1, 1, 1, 1
2, 1, 1
1, 2, 1
1, 1, 2
2, 2

What if, instead of being able to climb 1 or 2 steps at a time, you could climb any number 
from a set of positive integers X? For example, if X = {1, 3, 5}, you could climb 1, 3, or 5 
steps at a time.

-------------------------------------------------------
 Algorithm Explanation 
-------------------------------------------------------

We realized that this was the Fib sequence + 1, so we wrote the Fib sequence, and made a 
helper function to call the Fib(n + 1). This solved the first part of the problem.

For the follow up, we verified that modifying the fib function to return fib(n-a) + fin(n-b) + fib(n-c)...etc
(where a, b, and c are members of the "valid steps to climb" set) would yield the correct result. 

So, we made a function that creates a custom fib function based on the set of numbers. 

'''

def createFib(listOfValidSteps):
    
    def customFib(n):
        if n <= 0:
            return 0
        if n == 1:
            return 1
        
        sumFibs = 0
        for validSteps in listOfValidSteps:
            sumFibs += customFib(n - validSteps)
        return sumFibs
    return customFib

def numWays(n):
    customFib = createFib([1,3,5])
    return customFib(n+1)
    

print(numWays(30))