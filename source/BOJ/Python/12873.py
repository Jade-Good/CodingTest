from collections import deque
import math

N = int(input())
t = 0
member = deque(range(1,N+1))

while len(member) != 1:
    t += 1
    member.rotate(-((int(math.pow(t,3))%len(member))-1))
    member.popleft()
print(member.pop())