import math

n = int(input())
for i in range(n):
    string = input()
    size = int(math.sqrt(len(string)))

    arr = []
    for j in range(size):
        arr.append(string[j*size:j*size+size])
    
    result = ""

    for j in range(size):
        for k in range(size-1,-1,-1):
            result += arr[k][j]
    print(result[::-1])
