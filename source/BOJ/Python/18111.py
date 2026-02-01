import sys

n, m, b = map(int, sys.stdin.readline().split())
arr = [list(map(int, sys.stdin.readline().split())) for _ in range(n)]

answer = sys.maxsize
index = 0

for floor in range(257):
    up, down = 0, 0

    for i in range(n):
        for j in range(m):
            if arr[i][j] >= floor:
                up += arr[i][j] - floor
            else:
                down += floor - arr[i][j]
    
    if b + up >= down and down + (up * 2) <= answer:
        answer = down + (up * 2)
        index = floor

print(answer, index)

# import sys
# input = sys.stdin.readline

# N, M, B = map(int, input().split())

# strs = ""
# for i in range(N):
#     strs += input().rstrip() + " "
# arr = list(map(int,strs.split()))

# all_same = False
# answer = 0

# while not all_same:
#     if len(set(arr)) == 1:
#         all_same = True
#         break

#     if not all_same:
#         hi = max(arr)
#         low = min(arr)
#         hc = arr.count(hi)
#         lc = arr.count(low)
#         if hc < lc or B < lc:
#             arr = list(map(lambda x: x-1 if x==hi else x, arr))
#             B += hc
#             answer += 2 * hc
#         else:
#             arr = list(map(lambda x: x+1 if x==low else x, arr))
#             B -= lc
#             answer += lc
# print(answer)