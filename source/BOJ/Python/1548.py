from re import A
import time
start = time.time()  # 시작 시간 저장

# n = 16
# arr = [1, 1, 1, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 10000]

# n = 3
# arr = [1, 2, 3]

# n = 7
# arr = [2,3,4,1,3,4,5]

# n = 8
# arr = [1,1,1,1,1,1,1,1]

# n = 6
# arr = [1,1,1,1000000000, 1000000000, 1000000000]

# n = 1
# arr = [1000000000]

# n = 50
# arr = [1, 1, 1, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 10000, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5]

n = int(input())
arr = list(map(int,input().split()))
arr.sort()

def solution(N, arr):
    for n in range(N, 0, -1):
        for i in range(N - n + 1):
            print(n, i)
            if n < 3 or arr[i]+arr[i+1] > arr[i+n-1]:
                return n

print(solution(n, arr))


# ##########################################
# # dfs를 사용한 풀이 : 시간초과
# ##########################################
# # n = int(input())
# # arr = list(map(int,input().split()))
# arr.sort()

# answer = 0
# before = -1

# def triple(b):
#     for i in range(len(b)-1):
#         for j in range(i+1,len(b)):
#             for k in b:
#                 if b[i]+b[j] <= k:
#                     return False
#     return True

# def dfs(d, b):
#     global answer

#     if n-d <= answer:
#         return

#     if triple(b):
#         if answer < n-d:
#             answer = n-d
#         return

#     for i in range(len(b)):
#         if b[i] == b[i-1]:
#             continue
        
#         temp = b[:]
#         temp.pop(i)
#         dfs(d+1, temp)

# dfs(0, arr)
# print(answer)
# ##########################################


print("time :", (time.time() - start)*100000)  # 현재시각 - 시작시간 = 실행 시간