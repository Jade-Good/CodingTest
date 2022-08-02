T = int(input())

apt = [list(range(1,15))]

for i in range(1,15):
    apt.append([1])
    for j in range(1,14):
        apt[i].append(apt[i][j-1] + apt[i-1][j])

for i in range(T):
    print(apt[int(input())][int(input())-1])