import sys

n = int(sys.stdin.readline())

arr = list(map(int, sys.stdin.readline().rstrip().split()))
arr.sort()
sum_num = 0
for i in range(n):
    sum_num += sum(arr[:i+1])
print(sum_num)