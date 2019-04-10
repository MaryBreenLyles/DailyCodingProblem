''' 1) DIVISION - O(2n): Won't work for Array values of zero

    2) NO DIVISION - O(): Will work for Array vals of zero '''



''' REMEMBER INDENTATION '''

''' #### This shit still not workin ###
    Error - 
        B[i] = B[i]*A[j]
        IndexError: list index out of range
'''
     
''' 1) Can't take zero in A (DIVISION)'''
def prodNoti_NoZero(A):
         
    prod = 1
    B = [0] * len(A) #B is an array of zeros
         
    for i in A:
        prod = prod*A[i]
    
         
    for i in A:
        B[i] = (prod/A[i]) 
    
         
    return B

     
     
''' 2) Can take zero in A (NO DIVISION) '''
def prodNoti_canZero(A):

    B = [1] * len(A) #B is an array of ones
         
         
    for i in A:
        for j in A:
                 
            if j==i:
                continue
            else:
                B[i] = B[i]*A[j]
    
    return B
     
     


guyz = [3, 2, 1]
print(prodNoti_canZero(guyz))
    
        


