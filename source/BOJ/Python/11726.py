n = int(input())
dp = [1,1]

for i in range(1,n):
    dp.append(  (dp[-1]+dp[-2])%10007)

print(dp[n])