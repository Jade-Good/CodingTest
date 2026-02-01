import sys

lines = sys.stdin.readlines()

for line in lines:
    n, b, m = map(float,line.split())

    count = 0
    while n <= m:
        n += n * b / 100
        count += 1
    print(count)