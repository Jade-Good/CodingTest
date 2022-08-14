import sys
from collections import deque

input = sys.stdin.readline
print = sys.stdout.write

N = int(input().strip())

q = deque()

for i in range(N):
    order = input().strip()

    if order[:4] == "push":
        q.append(order[5:])
    elif order == "pop":
        if len(q) == 0:
            print("-1\n")
        else:
            print(str(q.popleft()) + "\n")
    elif order == "size":
        print(str(len(q)) + "\n")
    elif order == "empty":
        print(str(int(len(q) == 0)) + "\n")
    elif order == "front":
        if len(q) == 0:
            print("-1\n")
        else:
            print(str(q[0]) + "\n")
    elif order == "back":
        if len(q) == 0:
            print("-1\n")
        else:
            print(str(q[-1]) + "\n")