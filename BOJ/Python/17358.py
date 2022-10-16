import math


n = int(input())
arr = [i for i in range(1,n+1)]

answer = 1

while n > 0:
    answer *= n-1 
    answer %= 1000000007
    n -= 2
    print(answer , n)

print(answer)