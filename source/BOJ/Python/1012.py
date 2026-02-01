import sys
from collections import deque

dxy = [[0,-1],[-1,0],[0,1],[1,0]]

for _ in range(int(sys.stdin.readline())):
    m, n ,k = map(int, sys.stdin.readline().rstrip().split())

    field = [[0] * m for _ in range(n)]
    for _ in range(k):
        x, y = map(int, sys.stdin.readline().rstrip().split())
        field[y][x] = 1

    answer = 0
    visit = [[False] * m for _ in range(n)]

    for i in range(n):
        for j in range(m):
            que = deque()
            if field[i][j] == 1 and visit[i][j] == False:
                que.append([i,j])
                field[i][j] = 0
                while len(que) > 0:
                    x, y = que.popleft()
                    visit[x][y] = True
                    for k in range(4):
                        dx = x + dxy[k][0]
                        dy = y + dxy[k][1]
                        
                        if dx < 0 or dx >= n or dy < 0 or dy >= m:
                            continue
                        
                        if field[dx][dy] == 1 and visit[dx][dy] == False:
                            field[dx][dy] = 0
                            que.append([dx,dy])
                answer += 1
    print(answer)