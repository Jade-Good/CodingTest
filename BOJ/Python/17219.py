import sys

n, m = map(int, sys.stdin.readline().rstrip().split())
passwd = dict()

for _ in range(n):
    i = sys.stdin.readline().rstrip().split()
    passwd[i[0]] = i[1]

for _ in range(m):
    sys.stdout.write(passwd[sys.stdin.readline().rstrip()] + "\n")