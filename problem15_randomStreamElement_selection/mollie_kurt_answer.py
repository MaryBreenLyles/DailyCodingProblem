#https://www.onlinegdb.com/online_python_compiler
'''
-------------------------------------------------------
 Question
-------------------------------------------------------

This problem was asked by Facebook.

Given a stream of elements too large to store in memory, pick a random element from the stream with uniform probability.

-------------------------------------------------------
 Algorithm Explanation 
-------------------------------------------------------

probEisWritten: [1/1, 1/2, 1/3, 1/4, 1/5]
             E: [ a ,  b ,  c ,  d ,  e ]
answer = null; #start
answer = a #fist read from stream
answer = b #1/2 probability its b...b is chosen
answer = b #1/3 failed
answer = b #1/4 failed
answer = e #1/5 passed

answer is e

p(A is not overwritten, i.e. returns A) = 1/2 * 2/3 * 3/4 * 4/5 = 1/5
p(B is not overwritten) = 1/2  *2/3*3/4*4/5 = 1/5
                           ^p(B even gets written in)
p(C is not overwritten) = 1/2*1/3 *3/4*4/5 = 1/5
                             ^p(C even gets written in
.
.
.


Since the probability that each element is not overwritten (i.e. that it is saved as the return value) is 1/5 for every element. Therefore, a return element is picked with uniform probability.

-------------------------------------------------------
 TAKE AWAYS
-------------------------------------------------------
Always frame and reframe the problem. 
Think about more tangible framings (in this one we thought about rolling a dice for each element, but just add one to the dice for each element).

But also think about what is actually being done and whether there might be an alternative way to do it.

'''

import random

def pick(big_stream):
    random_element = None

    for i, e in enumerate(big_stream):
        if i == 0:
            random_element = e
        elif random.randint(1, i + 1) == 1:
            random_element = e
    return random_element


