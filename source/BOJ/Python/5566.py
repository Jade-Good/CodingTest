import sys
input = sys.stdin.readline

n, m = map(int,input().split())
board = [0] * n

for i in range(n):
    board[i] = int(input().rstrip())

index = 0
for i in range(m):
    index += int(input())
    if index >= n-1:
        print(i+1)
        break
    index += board[index]
    if index >= n-1:
        print(i+1)
        break