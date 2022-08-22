m = int(input())

cup = [1,2,3]

for i in range(m):
    x, y = map(int,input().split())
    x_idx = cup.index(x)
    y_idx = cup.index(y)
    cup[x_idx], cup[y_idx] = cup[y_idx], cup[x_idx]
print(cup[0])