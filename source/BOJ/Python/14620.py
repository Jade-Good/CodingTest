import sys
input = sys.stdin.readline

N = int(input())
flower = []
visit = [[0]*N for _ in range(N)]
answer = 200*16
dx = [0, 0, -1, 0, 1]
dy = [0, -1, 0, 1, 0]

for i in range(N):
    n = list(map(int,input().strip().split()))
    flower.append(n)


def check(x, y):
    for i in range(5):
        if visit[x+dx[i]][y+dy[i]] == 1:
            return False
    return True

def switch(flag,x,y):
    sum = 0
    for i in range(5):
        visit[x+dx[i]][y+dy[i]] = flag
        sum += flower[x+dx[i]][y+dy[i]]
    return sum

def dfs(coin, count, x):
    global answer
    if count >= 3:
        if coin < answer:
            answer = coin
        return

    for i in range(x, N-1):
        for j in range(1, N-1):
            if check(i,j):
                dfs(coin + switch(1,i,j), count+1, i)
                switch(0,i,j)


dfs(0, 0, 1)
print(answer)