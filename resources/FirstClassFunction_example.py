# If functions are first class then you can:
# - pass it into another function as a variable
# - return it from a function
# - modify it
# - assign it to a variable


def modList(f, listNums):
    return f(listNums)

def reverse(listNums):
    ansList = []
    
    for i in range(len(listNums)-1, -1, -1): # from listNums.length-1 to 0 (not inclusive, hence -1), decrement -1
        ansList.append(listNums[i])
    
    return ansList


## return the reversed list
listNums = [1,2,2,4,5,6]

print(modList(reverse, listNums))
