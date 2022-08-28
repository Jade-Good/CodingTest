import sys

n, k = map(int, sys.stdin.readline().split())

coin = []

for i in range(n):
    c = int(sys.stdin.readline())
    if c <= k:
        coin.append(c)

answer = 0

for i in coin[::-1]:
    if k >= i:
        answer += k//i
        k %= i
sys.stdout.write(str(answer) + "\n")