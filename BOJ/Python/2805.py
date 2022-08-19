import sys
input = sys.stdin.readline

N, M = map(int,input().split())
arr = list(map(int,input().split()))
left, right = 1, max(arr)

while left <= right:
    mid = (left+right) // 2

    tree = 0
    for i in arr:
        if i > mid:
            tree += i - mid
    
    if tree >= M:
        left = mid + 1
    else:
        right = mid - 1
print(right)