import sys
input = sys.stdin.readline
print = sys.stdout.write

N = int(input().strip())
arr = []

for i in range(N):
    order = input().strip()
    
    if order[:4] == "push":
        arr.append(int(order[5:]))
    elif order == "pop":
        if(len(arr) == 0): print(str(-1)+'\n')
        else:
            print(str(arr[-1])+'\n')
            arr.pop()
    elif order == "size":
        print(str(len(arr))+'\n')
    elif order == "empty":
        if(len(arr) == 0): print(str(1)+'\n')
        else: print(str(0)+'\n')
    elif order == "top":
        if(len(arr) == 0): print(str(-1)+'\n')
        else: print(str(arr[-1])+'\n')
