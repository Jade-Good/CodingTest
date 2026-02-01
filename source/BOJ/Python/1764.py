import sys

n, m = map(int, sys.stdin.readline().split())

name = set()
answer = list()

for i in range(n):
    name.add(sys.stdin.readline().rstrip())

for i in range(m):
    isin = sys.stdin.readline().rstrip()
    if isin in name:
        answer.append(isin)

answer.sort()

sys.stdout.write(str(len(answer)) + "\n")
for i in answer:
    sys.stdout.write(i + "\n")
