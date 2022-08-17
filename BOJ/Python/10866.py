from collections import deque
import sys

input = sys.stdin.readline
print = sys.stdout.write

deq = deque()

for i in range(int(input())):
    order = input().rstrip()

    if order[:10] == "push_front":
        deq.appendleft(order[11:])
    elif order[:9] == "push_back":
        deq.append(order[10:])
    elif order[:9] == "pop_front":
        if len(deq):
            print(deq.popleft() + "\n")
        else:
            print("-1\n")
    elif order[:8] == "pop_back":
        if len(deq):
            print(deq.pop() + "\n")
        else:
            print("-1\n")
    elif order[:4] == "size":
        print(str(len(deq)) + "\n")
    elif order[:5] == "empty":
        print(str(int(len(deq) == 0)) + "\n")
    elif order[:5] == "front":
        if len(deq):
            print(deq[0] + "\n")
        else:
            print("-1\n")
    elif order[:4] == "back":
        if len(deq):
            print(deq[-1] + "\n")
        else:
            print("-1\n")