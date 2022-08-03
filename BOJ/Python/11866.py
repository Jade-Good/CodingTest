N, K = map(int,input().split())

arr = list(range(1,N+1))

print("<",end="")
index = 0
count = 1
while len(arr) > 1 :
    index = (index+K-1)%len(arr)
    print(arr[index],', ',sep="",end="")
    arr.pop(index)
print(arr[0],">",sep="")