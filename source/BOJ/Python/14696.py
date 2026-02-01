import sys
input = sys.stdin.readline

for i in range(int(input())):
    a = list(map(int, input().rstrip().split()))[1:]
    b = list(map(int, input().rstrip().split()))[1:]

    for j in range(4,0,-1):
        if a.count(j) > b.count(j):
            print("A")
            break
        elif a.count(j) < b.count(j):
            print("B")
            break
    else: print("D")
        