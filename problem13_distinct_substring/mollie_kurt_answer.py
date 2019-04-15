#https://www.onlinegdb.com/online_python_compiler
'''
-------------------------------------------------------
 Question
-------------------------------------------------------
This problem was asked by Amazon.

Given an integer k and a string s, find the length of the longest substring that contains at most k distinct characters.

For example, given s = "abcba" and k = 2, the longest substring with k distinct characters is "bcb".

-------------------------------------------------------
 Algorithm Explanation 
-------------------------------------------------------


'''

def Problem13(S, K):
    p1 = 0
    p2 = 0
    longest = 0
    distinct = 0
    letterMap = {}
    count = 0

    while p2 < len(S):
        if S[p2] not in letterMap:
            letterMap[S[p2]] = 1
            distinct += 1
        elif distinct <= K:
            letterMap[S[p2]] += 1
        
        if distinct > K:
            longest = max(longest, count)
            letterMap[S[p1]] -= 1
            if letterMap[S[p1]] == 0:
                distinct -= 1
                letterMap.pop(S[p1])
            p1 += 1
            count -= 1
            if distinct <= K:
                p2 += 1
                count += 1
        else:
            p2 += 1
            count += 1
    return max(longest, count)


S = "abcccbbbbdabcabcabcabc"
print(Problem13(S, 3))