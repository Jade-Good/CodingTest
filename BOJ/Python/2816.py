import sys
input = sys.stdin.readline

arr = []
for i in range(int(input())):
    arr.append(input().rstrip())

kbs1 = arr.index("KBS1")
kbs2 = arr.index("KBS2")
now = 0

for i in range(kbs1):
    print(1,end="")
for i in range(kbs1):
    print(4,end="")
if kbs1>kbs2:
    for i in range(kbs2+1): 
        print(1,end="")
    for i in range(kbs2):
        print(4,end="")
else:
    for i in range(kbs2):
        print(1,end="")
    for i in range(kbs2-1):
        print(4,end="")