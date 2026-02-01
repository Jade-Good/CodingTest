from collections import deque
from sys import stdin,stdout

input = stdin.readline
print = stdout.write

N = int(input())

n = 0
que = deque()
while n != -1:
    n = int(input())

    if n == 0:
        que.popleft()
    elif n > 0 and len(que) < N:
        que.append(n)

if len(que):
    for i in que:
        print(str(i) + " ")
else:
    print("empty")