from collections import deque

N = int(input())

que = deque(range(1,N+1))

while len(que) != 1:
    print(que.popleft(),end=" ")
    # que.append(que.popleft())
    que.rotate(-1)

print(que.pop())