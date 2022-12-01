s = input()
r = 0
c = 0

for i in range(1, len(s)//2 + 1):
    if len(s) % i == 0 and i <= len(s)//i:
        r = i
        c = len(s)//i

for i in range(r):
    for j in range(c):
        print(s[i+r*j], end="")
