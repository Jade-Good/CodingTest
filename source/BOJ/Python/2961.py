n = int(input())

taste = []
visit = [0] * n
answer = 1000000000

for _ in range(n):
    taste.append(list(map(int,input().split())))

def dfs(d, m, s, b, x):
    global answer
    if d >= m:
        if s > b:
            sum = s - b
        else:
            sum = b - s
        answer = min(answer, sum)
        return
    
    for i in range(x,n):
        if visit[i] == 0:
            visit[i] = 1
            dfs(d+1, m, s*taste[i][0], b+taste[i][1], i)
            visit[i] = 0

for i in range(1, n+1):
    dfs(0, i, 1, 0, 0)

print(answer)