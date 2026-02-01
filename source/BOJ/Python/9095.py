dp = [1,2,4]
for _ in range(int(input())):
    t = int(input())
    
    if len(dp) < t:
        for _ in range(t - len(dp)):
            dp.append(dp[-1] + dp[-2] + dp[-3])
    
    print(dp[t-1])