import sys

input = sys.stdin.readline

N = int(input())

arr = [0]

for i in range(N):
    h = int(input())
    while True:
        if len(arr) == 0:
            arr.append(h)
            break
        elif arr[-1] <= h:
            arr.pop()
        else:
            arr.append(h)
            break
print(len(arr))