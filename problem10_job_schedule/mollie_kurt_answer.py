'''
This problem was asked by Apple.

Implement a job scheduler which takes in a function f and an integer n, and calls f after n seconds.

# Key Things Learned:
- Use the Thread class from threading to run code async 
- The Thread class utilize the combination of Keyword arguments and default parameters, allowing us to only pass arguments we care about
- If we want to use every value in a list as arguments to a function, we can simply do: function(*list)

'''

import threading
import time

def waitAndExecute(f, seconds, argsToFunction):
    time.sleep(seconds)
    f(*argsToFunction)

def scheduleJob(f, seconds, args):
    threading.Thread(target=waitAndExecute, args=(f,seconds, args)).start()

def say(msg):
    print(msg)


scheduleJob(f=say, seconds=2, args=["Third"])
scheduleJob(f=say, seconds=1, args=["Second"])
scheduleJob(f=say, seconds=3, args=["Fourth"])
print("First!")
