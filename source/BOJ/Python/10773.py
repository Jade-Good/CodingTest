import sys
from collections import deque

input = sys.stdin.readline
K = int(input().strip())

d = deque()

for i in range(K):
    n = int(input().strip())
    if n == 0:
        d.pop()
    else:
        d.append(n)

print(sum(d))
