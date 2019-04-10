
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
