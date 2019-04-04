#https://www.onlinegdb.com/online_python_compiler

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
