import math

n = int(input())
answer = 0

for i in str(math.prod( i for i in range(1,n+1)))[::-1]:
    if i =="0": answer += 1
    else: break

print(answer)