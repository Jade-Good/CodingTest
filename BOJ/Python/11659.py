import sys

n, m = map(int, sys.stdin.readline().rstrip().split())
arr = list(map(int, sys.stdin.readline().rstrip().split()))
acc = [0]

for i in arr:
    acc.append(acc[-1] + i)

for _ in range(m):
    start, end = map(int, sys.stdin.readline().rstrip().split())
    sys.stdout.write(str(acc[end] - acc[start-1]) + "\n")