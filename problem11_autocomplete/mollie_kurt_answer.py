'''
This problem was asked by Twitter.

Implement an autocomplete system. That is, given a query string s and a set of all possible query strings, return all strings in the set that have s as a prefix.

For example, given the query string de and the set of strings [dog, deer, deal], return [deer, deal].

Hint: Try preprocessing the dictionary into a more efficient data structure to speed up queries.
'''

# FIRST: preprocess the Dictionary 
#   - params: list of words
#   - returns: hashmap* 
#     *(don't need to return sorted 
#     array b/c arrays are passed by reference & it just 
#     be operated on by the method with no need to return modified array)

def preProcess(words): #(return map) 
    words.sort()    # alphabetize array
    letterMap = {}  # define a map
    
    currLetter = ''
    for i, word in enumerate(words):
        if word[0] != currLetter:
            letterMap[word[0]] = i # stores value of beginning index for each 1st letter
        
        currLetter = word[0]
        
    return letterMap
    
# Now find if words in letterMap contain prefix queryS
def autoComplete(queryS, words):
    letterMap = preProcess(words)
    
    sLength = len(queryS)
    results = []
    
    for i, word in enumerate(words):
        if sLength < len(word) and word[:sLength]==queryS:
            results.append(word)
            
    return results
            
    

test = ["dog", "bat", "apple", "cat", "dank", "dock", "d"]

print(autoComplete("a", test))




