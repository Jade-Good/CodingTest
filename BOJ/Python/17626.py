## dp
# n = int(input())
# dp = [i for i in range(n+1)]

# for i in range(2,n+1):
#     j = 1
#     min_v = 4
#     while((j**2)<=i):
#         dp_v = dp[i-(j**2)]
#         min_v = min(min_v, dp_v)
#         j+=1
#     dp[i] = min_v+1    
# print(dp[n])

# 브루트 포스
def solution(n):
    if int(n**0.5) == n**0.5:
        return 1
    for i in range(1, int(n**0.5) + 1):
        if int((n - i**2)**0.5) == (n - i**2)**0.5:
            return 2
    for i in range(1, int(n**0.5) + 1):
        for j in range(1, int((n - i**2)**0.5) + 1):
            if int((n - i**2 - j**2)**0.5) == (n - i**2 - j**2)**0.5:
                return 3
    return 4

n = int(input())
print(solution(n))