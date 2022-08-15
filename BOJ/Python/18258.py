import sys
from collections import deque
input = sys.stdin.readline
print = sys.stdout.write

que = deque()

for i in range(int(input())):
    order = input().rstrip()

    if order[:4] == "push":
        que.append(order[5:])
    elif order == "pop":
        if len(que) == 0:
            print("-1\n")
        else:
            print(que.popleft() + "\n")
    elif order == "size":
        print(str(len(que))+"\n")
    elif order == "empty":
        if len(que) == 0:
            print("1\n")
        else:
            print("0\n")
    elif order == "front":
        if len(que) == 0:
            print("-1\n")
        else:
            print(que[0]+"\n")
    elif order == "back":
        if len(que) == 0:
            print("-1\n")
        else:
            print(que[-1]+"\n")