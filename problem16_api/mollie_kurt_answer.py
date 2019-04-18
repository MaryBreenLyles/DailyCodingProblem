
'''
You run an e-commerce website and want to record the last N order ids in a log. Implement a data structure to accomplish this, with the following API:

record(order_id): adds the order_id to the log
get_last(i): gets the ith last element from the log. i is guaranteed to be smaller than or equal to N.
You should be as efficient with time and space as possible.
'''
# record order ids as they come in and then only store up to N, removing IDs
# that are too far in the past (greater than N ids ago)

#import array as arr 

class Api:


# N has a default value, it does not need to be passed into constructor

    def __init__(self, N=100):
        self.N = N
        self.index = -1
        self.my_dict = [0]*N
        

    def getCurrIndex(self, i): 
        return i % self.N  # CIRCULARLY COUNTING INDEX
    
    def record(self, order_id):
            
        self.index += 1
        self.my_dict[self.getCurrIndex(self.index)] = order_id
        

    def get_last(self, last):
        print(self.my_dict[self.getCurrIndex(self.index-last+1)])


my_api = Api(7)

my_api.record(12)
my_api.record(35)
my_api.record(40)
my_api.record(100)
my_api.record(13) #i=4
my_api.record(28)
my_api.record(42)
my_api.record(22)
my_api.record(12)
my_api.record(78)
print(my_api.my_dict)


# N=7

my_api.get_last(6)


