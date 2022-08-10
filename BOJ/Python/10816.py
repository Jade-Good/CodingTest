import sys

input = sys.stdin.readline
print = sys.stdout.write

dic = {}

int(input().strip())
arr = input().strip().split()
for i in arr:
    if i in dic:
        dic[i] += 1
    else:
        dic[i] = 1

int(input().strip())
arr = input().strip().split()
for i in arr:
    if i in dic:
        print(str(dic[i]) + " ")
    else:
        print("0 ")
