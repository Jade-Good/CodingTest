n, m = map(int,input().split())

before = input()

for i in range(n-1):
    new = input()

    flag = True
    for j in range(1,m+1):
        if new[m-j:] == before[:j] or new[:j] == before[m-j:]:
            break
    else:
        flag = False

    if flag:
        before = new
    else:
        print(0)
        break
else:
    print(1)
