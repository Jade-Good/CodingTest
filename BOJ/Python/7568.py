N = int(input())

arr = []

for i in range(N):
    arr.append(list(map(int,input().split())))
answer = [1] * len(arr)

for i in range(len(arr)):
    for j in range(len(arr)):
        if j != i and arr[j][0] > arr[i][0] and arr[j][1] > arr[i][1]:
            answer[i] += 1

for i in answer:
    print(i,end=" ")