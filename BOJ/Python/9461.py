dp = [1,1,1,2,2,3,4,5,7,9]

for _ in range(int(input())):
    n = int(input())

    if n <= len(dp):
        print(dp[n-1])
    else:
        for _ in range(n-len(dp)):
            dp.append(dp[-2]+dp[-3])
        print(dp[n-1])