#https://www.onlinegdb.com/online_python_compiler
def cons(a, b):
    def pair(f):
        return f(a, b)
    return pair

def car(pair):
    def first (val1, val2):
        return val1
    return pair(first)
    
def cdr(pair):
    def second(val1, val2):
        return val2
    return pair(second)
    
print(car(cons(3, 4)))
print(cdr(cons(3, 4)))