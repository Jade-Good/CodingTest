fact = [0] * 20
fact[0] = 1
for i in range(1, 20):
    fact[i] = fact[i-1] * i

n = int(input())

if n == 0:
    print("NO")
else:
    for i in range(19, -1, -1):
        if n >= fact[i]:
            n -= fact[i]
    if n:
        print("NO")
    else:
        print("YES")