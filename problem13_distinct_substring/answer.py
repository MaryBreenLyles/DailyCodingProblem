'''by Amazon.

Given an integer k and a string s, find the length of the longest substring that contains at most k distinct characters.

For example, given s = "abcba" and k = 2, the longest substring with k distinct characters is "bcb", so your function should return 3.'''

from collections import deque

s = 'abcccbbbbdabcabcabcabcabcccbbbbdabcabcabcabcabcccbbbbdabcabcabcabc'
k = 3

def longest_substring(s, k):
  len_substring = 0
  substring = deque()
  i = 0
  
  if k == 0:
    return 0
  
  else:
    while i < len(s):
      substring.append(s[i])
      if len(set(substring)) == k:
        if len(substring) > len_substring:
          len_substring = len(substring)
      elif len(set(substring)) > k:
        substring.popleft()
      i += 1
  return len_substring
  
print longest_substring(s, k)  
    