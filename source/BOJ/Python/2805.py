# python3 : 39% , pypy : 통과
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



# python3 :47% , pypy : 47%

# import sys

# input = sys.stdin.readline

# N, M = map(int,input().split())

# arr = list(map(int,input().split()))

# arr.sort()

# answer = arr[-1]
# tree = 0

# while tree < M: # 절단기의 높이(answer) 하나씩 낮추기
#     left = 0
#     right = N-1
#     answer -= 1
    
#     while right > left: # 잘리는 나무중에 가장 작은 인덱스 찾기
#         mid = (left+right)//2
#         if arr[mid] <= answer:
#             left = mid+1
#         else:
#             right = mid
#     tree += N - right
# print(answer)